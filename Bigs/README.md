# Große Zahlen (15 P)
Beschreibung
Implementieren Sie eine Klasse Bigs, die es ermöglicht, mit sehr großen natürlichen Zahlen zu rechnen. Dazu sollen die Zahlen in Feldern von Ziffern repräsentiert werden, wobei an jeder Position nur Ziffern zwischen 0 und 9 erlaubt sind,
am Index 0 stets die Einerstelle der Zahl abzulegen ist (höherwertige Stellen folgen) und
stets nur so viele Feldpositionen wie nötig verwendet werden, so dass also nie führende Nullen (außer bei 0 selbst) erfasst werden.
Die Zahl mit der Dezimalrepräsentation 12345679 soll demzufolge die folgende Repräsentation haben: 9071625344352617, wobei die Zahl im Subskript den jeweiligen Index der Ziffer im Feld angibt.

Implementieren Sie dazu (mindestens) die im folgenden Programmfragment vorgegebenen Methoden:
```
class Bigs {
        
        // addiert die Ziffernfelder a und b
        public static int[ ] add (int[ ] a, int[ ] b) { /* TODO */ }
       
        // gibt das Ziffernfeld n in lesbarer dezimaler Form aus
        static void print (int[ ] n)            { /* TODO */ }
   
        // konstruiert ein einstelliges Ziffernfeld aus d
        static int[ ] digit(int d)              { /* TODO */ }
 
        // konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
        static int[ ] Null()            { /* TODO */ }
   
        // konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
        static int[ ] One()             { /* TODO */ }

        // Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
        static int mod10(int[ ] n)              { /* TODO */ }

        // ganzzahliger Quotient bei Division durch 10
        static int[ ] div10(int[ ] n)           { /* TODO */ }

        // Umwandlung einer int-Zahl in ein Ziffernfeld
        static int[ ] fromInt(int n)            { /* TODO */ }

        // kopiert den Wert von a
        static int[ ] copy(int[ ] n)            { /* TODO */ }

        // multipliziert das Ziffernfeld a mit einer int-Zahl
        static int[ ] times(int[ ] n, int d)            { /* TODO */ }

        // multipliziert das Ziffernfeld n mit 10
        static int[ ] times10(int[ ] n)         { /* TODO */ }
   
        // multipliziert zwei Ziffernfelder
        static int[ ] times(int[ ]a, int[ ] b)          { /* TODO */ }
   
        // Quadratzahl eines Ziffernfeldes
        static int[ ] square(int[ ]a)           { /* TODO */ }

        // Kubikzahl eines Ziffernfeldes
        static int[ ] cubic(int[ ]a)            { /* TODO */ }

        // ist dieses Ziffernfeld ein Palindrom? Bemühen Sie sich um eine Implementation,
        // die ohne ein weiteres Zahlenfeld auskommt !
        static boolean palindrom(int[ ] a)              { /* TODO */ }
   
        // Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
        static boolean less (int[ ] a, int[ ] b)                { /* TODO */ }

        // Test auf Gleichheit zweier Ziffernfelder
        static boolean equal (int[ ] a, int[ ] b)               { /* TODO */ }

        // Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
        // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
        // keine fuehrenden Nullen (ausser bei Null selbst)
        static boolean ok (int[ ] n)            { /* TODO */ }

        // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
        static void maxDigit(int[] n)           { /* TODO */ }

        public static void main (String[ ] s) {
                int[] a = One();

                for (int i=0; i<33222; ++i) {
                        a = times(a, 2);
                }

                System.out.println("2^33222 hat " + a.length + " Stellen");
                print(a);
                System.out.println();

                int[] b = fromInt(13);
                int[] c = copy(b);
     
                for (int i=1; i<8978; ++i) {
                        c=times(c, b);
                }
     
                System.out.println("13^8978 hat " + c.length + " Stellen");
                print(c);
                System.out.println();

                System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
                maxDigit(a);
                maxDigit(c);
        }
}
```
Änderungen an den Signaturen der vorgegebenen Methoden sind NICHT erlaubt.

Die Verwendung von weiteren Hilfsklassen (z.B. java.math.BigInteger) aus dem Java-API ist ebenfalls NICHT zulässig!

Hinweise
Achten Sie bei allen Operationen darauf, dass beim ggf. notwendigen Erzeugen neuer Ziffernfelder immer nur so viele Elemente beschafft werden, wie nötig!

Auch wenn Java prinzipiell die Verwendung von Umlauten (und vielen anderen Sonderzeichen) erlaubt, sollten Sie im Praktikum generell darauf verzichten, um sich nicht vom sog. encoding abhängig zu machen. Das betrifft übrigens auch Texte in Kommentaren!