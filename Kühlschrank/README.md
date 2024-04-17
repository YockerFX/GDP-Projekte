# Aufgabe 5.1: Kühlschrank (10 Punkte)
In dieser Aufgabe modellieren wir einen Külschrank (z.B. damit fehlende Lebensmittel automatisch nachbestellt werden können). Gegeben sei die folgende abstrakte Basisklasse Lebensmittel:
```
public abstract class Lebensmittel 
{
    private final String name;
    protected int menge; // in Milliliter bzw. Gramm

    public Lebensmittel(String name, int menge) {
        this.name = name;
        this.menge = menge;
    }

    public abstract boolean essen();

    public abstract boolean trinken();

    public String toString() {
        return "Lebensmittel";
    }
}
```
Schreiben Sie die sechs zusätzlichen Klassen Getraenk, Speise, Wasser, Mate, Brot und Kaese für die gilt:

Jedes Getraenk und jede Speise ist ein Lebensmittel.
Jedes Wasser und jede Mate ist ein Getraenk.
Jedes Brot und jede Kaese ist eine Speise.
Für jede Speise soll eine Methode essen(int menge) und für jedes Getraenk eine Methode trinken(int menge) implementiert werden.
Die Klassen Wasser und Mate sollen beim Aufruf der Methode essen() stets false zurückgeben. Beim Aufruf von trinken() wird die Menge von Wasser um 200ml und die von Mate um 100ml reduziert.
Die Klassen Kaese und Brot sollen beim Aufruf der Methode trinken() stets false zurückgeben. Beim Aufruf von essen() wird die Menge von Käse um 20g und die von Brot um 50g reduziert.
Kein Lebensmittel kann eine Menge von weniger als 0ml oder 0g haben. Sollte die zu konsumierende Menge beim Aufruf von essen() oder trinken() größer sein als die verfügbare Menge, wird 0 als neue Menge festgelegt und false zurückgegeben. Dementsprechend kann es kein Lebensmittel mit einer Menge weniger als 0 geben.
Der einzige explizite Konstruktor der Klasse Mate soll nur den Namen als Parameter erhalten, die Menge ist stets 500ml.
Der einzige explizite Konstruktor der Klasse Brot soll statt des Namens eine Nummer (Integer) als Parameter erhalten mit folgender Bedeutung:
0 – Weißbrot,
1 – Schwarzbrot,
2 – Mischbrot,
sonst: Spezialbrot. Nach dem Aufruf des Konstruktors hat jedes Brot den entsprechenden Namen.
Die Methode toString() soll den Namen der jeweiligen Klasse und die Instanzvariable name und menge als formatierten String zurückgeben. Die Ausgabe der Menge soll dabei jeweils mit der entsprechenden Einheit (g oder ml) erfolgen. Beispiel: eine Instanz der Klasse Mate mit dem Namen "Club Mate" und einer Menge von 500ml gibt bei Aufruf von toString() folgenden String zurück:

Mate (Club Mate, 500 ml)
Hinweise zur Umsetzung
Versuchen Sie die Klassendefinitionen möglichst klein zu halten.
Benutzen Sie so oft wie möglich Funktionalität übergeordneter Klassen bzw. implementieren Sie Funktionalität in der Klassenhierarchie so weit oben wie möglich.

Sie dürfen die Basisklasse Lebensmittel verändern und bei Bedarf zusätzliche Funktionalitäten hinzufügen.

Die Instanzvarieblen sollten so geringe Sichtbarkeit haben wie nur möglich.
Benutzen Sie zum Testen Ihrer Lösung die beiliegende Klasse Kuehlschrank.java. Der Aufruf

java Kuehlschrank
sollte folgende Aufgabe erzeugen:
```
Mate (Club Mate, 500 ml)
Brot (Schwarzbrot, 750 g)
Wasser (Sprudel, 250 ml)
Mate (Flora Power, 500 ml)
Brot (Spezialbrot, 1000 g)
Kaese (Parmesan, 200 g)
Wasser (Still, 1500 ml)
Trinken: Mate (Club Mate, 400 ml)
Essen: Brot (Schwarzbrot, 700 g)
Trinken: Wasser (Sprudel, 50 ml)
Trinken: Mate (Flora Power, 400 ml)
Essen: Brot (Spezialbrot, 950 g)
Essen: Kaese (Parmesan, 180 g)
Trinken: Wasser (Still, 1300 ml)
```

Hinweise zur Abgabe
Kommentieren Sie ihre Klassen und Methoden wie gewohnt.
Achten Sie bei der Abgabe darauf eventuelle Package-Namen zu entfernen.
Achten Sie auf die korrekte Kodierung ihrer Dateien im UTF-8 Format (ohne BOM).
Laden Sie die sieben Java-Quelldateien:
Lebensmittel.java,
Speise.java,
Getraenk.java,
Wasser.java,
Mate.java,
Kaese.java und
Brot.java rechtzeitig in Moodle hoch.