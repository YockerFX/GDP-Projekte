# Nutzerdefinierte Datentypen (25 P)
Beschreibung
Häufig will man schnell und speichersparend entscheiden, ob unter einer Anzahl von Werten (hier Zahlen) jeder maximal einmal vorkommt. Nun könnte man die (jeweils bereits verarbeiteten) Zahlen in einem Array anordnen und damit etwa folgendermaßen arbeiten:
```
int[] menge = new int[n]; // "Menge" der verarbeiteten Zahlen
int i = 0; // Anzahl der bereits verarbeiteten Zahlen

while (/* noch nicht alle Zahlen wurden verarbeitet */) {
    int zahl = /* wähle die nächste Zahl */;
    // prüfe, ob die Zahl bereits vorkam
    for (int j = 0; j < i; ++j) {
        if (zahl == menge[j]) /* Duplikat gefunden */
            return /* something */;
    }
    // bisher kein Duplikat, also neue Zahl in die Menge mit aufnehmen
    menge[i++] = zahl;
}
// kein Duplikat wurde entdeckt
```
Dieser Ansatz hat zwei entscheidende Nachteile:

Für jede neue Zahl müssen alle bereits berücksichtigten Zahlen erneut (linear) durchsucht werden. Damit ist der Testaufwand in der Größenordnung O(n2). Für n == 9 ist das sicher noch überschaubar, für große n jedoch u.U. viel höher als nötig.
Bereits für die Mengenrepräsentation von 9 Zahlen benötigt man Platz für 9 int-Zahlen, das sind bei Java 9 • 4 = 36 Byte oder 9 • 32 Bit = 288 Bit. Was für eine Platzverschwendung! In 288 Bit könnte man potentiell Mengen bis zu 288 Elementen erfassen, wenn man jedes Bit einem (möglichen) Element zuordnet: der Bitwert 1 zeigt an, dass das zugehörige Element in der Menge enthalten ist, der Bitwert 0 dagegen zeigt an, dass das zugehörige Element nicht in der Menge enthalten ist.
Die Umsetzung der bitweisen Mengendarstellung behebt zugleich auch das erste Problem: da jedem Element eine Bitposition fest zugeordnet ist, kann man darauf in konstanter Zeit zugreifen und die Prüfung, ob eine Zahl bereits in der Menge enthalten ist, reduziert sich somit auf einen konstanten Aufwand.

Die einzige Voraussetzung für dieses Verfahren besteht darin, dass man vorab festlegen muss, welche Zahlenwerte maximal in der Menge vorkommen dürfen.

Aufgabenstellung
Sie sollen diese Idee unter Zuhilfenahme der in Java verfügbaren Bitoperationen umsetzen. Die Schnittstelle der von Ihnen zu implementierenden Klasse für einen bitbasierten Mengentyp nicht negativer ganzer Zahlen zeigen wir Ihnen hier der Übersicht halber:
```
public class IntSet implements Iterable<Integer> {
    public IntSet(int n) {...}

    public int capacity() {...}
    public IntSet resize(int n) {...}
    public boolean contains(int e) {...}
    public void insert(int e) {...}
    public void insert(int[] es) {...}
    public void remove(int e) {...}
    public void remove(int[] es) {...}

    public IntSet complement() {...}
    public static IntSet union(IntSet s1, IntSet s2) {...}
    public static IntSet intersection(IntSet s1, IntSet s2) {...}
    public static IntSet difference(IntSet s1, IntSet s2) {...}

    public String bits() {...}

    @Override
    public String toString() {... }

    @Override
    public Iterator iterator() {...}

    public class Iterator implements java.util.Iterator<Integer> {
        public Iterator(IntSet s) {...}

        @Override
        public boolean hasNext() {...}

        @Override
        public Integer next() {...}
    }
}
```
All diese Operationen sind allerdings immer auf Variablen des Typs int anzuwenden, so dass Speicher für die Mengendarstellung immer in "int-Portionen" bereitgestellt werden muss: für Mengen bis maximal 32 Elementen reicht eine int-Zahl aus, für größere Mengen müssen ggf. mehrere int-Zahlen hintereinander verwendet werden. Diese liegen im Speicher unmittelbar hintereinander, so dass sich leicht errechnen lässt, in welcher int-Portion und dort an welcher Stelle eine gesuchte Zahl liegen muss. Die o.g. Zuordnung von Elementen (hier nicht negative Zahlen) auf Bitpositionen ist ganz einfach: Jede Zahl n wird durch das Bit Nr. n repräsentiert: 1 - die Zahl ist in der Menge enthalten, 0 - die Zahl ist nicht in der Menge enthalten.

Allerdings kann man mit den Bitoperationen immer nur auf die Bits einer int-Zahl zugreifen. Für Mengen mit mehr als 32 Elementen muss man also zunächst ermitteln, in welche int-Portion die entsprechende Bit-Position gehört und welches Bit relativ in diesem int für die Zahl steht.

Die Klasse wird zu einem sog. abstrakten Datentyp, indem die Details der Implementation dem Zugriff eines Benutzers dadurch entzogen bleiben, dass sie in der Klasse als private Daten bereitgestellt werden. Änderungen am Zustand einer solchen Menge sind somit nur über die öffentlichen Methoden der Klasse möglich. Entnehmen Sie die Semantik der zu implementierenden Funktionen der javadoc-Muster-Dokumentation und statten Sie ihren Quelltext mit geeigneten Kommentaren aus, der die automatische Erzeugung einer ähnliche Dokumentation aus Ihrer Implementation ermöglicht.

Testfall
Wenn Sie Ihre Implementation des Typs IntSet mit dem in der Vorlage enthaltenen Testprogramm verwenden, müssen exakt diese Ausgaben produziert werden:
```
s1.complement() = {0, 1, 2, 3, 4, 6, 7, 8, 9}
s2.complement() = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19}
s1 = {5}
s2 = {15}
s1 = {5}
s1.bits() = 000001000000000
s1.complement() = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14}
s1.complement().bits() = 111110111111111
s3 = {5, 15}
s3.capacity() = 20
s3.complement() = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19}
s4 = {}
s4.capacity() = 40
s4 = {5, 15}
s4 = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39}
0
7
14
21
28
35
s5 = {1, 2, 3, 4, 5, 6}
IntSet.difference(s4, s5) = {0, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39}
s6 = {2, 3, 5, 7, 11, 13, 17, 19}
```