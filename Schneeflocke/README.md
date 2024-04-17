# Aufgabe 4.2: Koch-Schneeflocke (12 Punkte)
In dieser Aufgabe sollen Sie ein rekursives Programm zur Berechnung und Darstellung einer Koch-Schneeflocke schreiben.

Grundlage für die Erstellung einer Koch-Schneeflocke ist die Koch-Kurve, welche 1904 von dem schwedischen Mathematiker Helge Koch entdeckt wurde. Es handelt sich um eine überall stetige aber nicht differenzierbare Kurve. Jedes Stück dieser Linie besteht aus wiederholten Kopien von sich selbst. Solche Gebilde werden als Fraktale bezeichnet. Diese Kurve lässt sich rekursiv berechnen bzw. zeichnen. Hierdurch ist es möglich, eine fraktale Schneeflocke zu erzeugen.

Die Koch-Kurve kann in einem iterativen Prozess erstellt werden:

Im ersten Schritt (n=0) besteht die Kurve nur aus einer einzigen geraden Linie.
Diese wird im nächsten Schritt (n=1) durch einen aus vier Linien bestehenden
Linienabschnitt ersetzt, von denen jede die Länge 1⁄3 der Ausgangslinie. Dieser
Linienabschnitt ist folgendermaßen aufgebaut: (Linie 1) - (60° Winkel) - (Linie 2) - (120° Winkel in Gegenrichtung) - (Linie 3) - (60° Winkel) - (Linie 4)
In den weiteren Schritten (n=2,3,4,...)  wird nun jede Linie wieder durch einen eben beschriebenen Linienabschnitt ersetzt.
Die folgende Abbildung illustriert den Erstellungsprozess der Koch-Kurve über verschiedene Tiefen :

[!https://moodle.hu-berlin.de/pluginfile.php/5835313/mod_assign/intro/grafik.png]

Beginnt man den Ersetzungsprozess nicht mit einer einzigen Linie, sondern mit einem
gleichseitigen Dreieck, erhält man die Koch-Schneeflocke wie in der folgenden Abbildung:

[!https://moodle.hu-berlin.de/pluginfile.php/5835313/mod_assign/intro/grafik%20%281%29.png]

Aufgabenstellung

Implementieren Sie ein Programm KochSchneeflocke.java, welches von der Kommandozeile mit dem Parameter
aufgerufen werden kann und eine Koch-Schneeflocke zeichnet. Nutzen Sie hierzu den in Moodle verfügbaren Vorlage und implementieren Sie die rekursive Funktion:


```
public static void zeichneKochKurve(int n, double x1, double y1, double x5, double y5)
```
Für n = 0 zeichnet zeichneKochKurve einfach eine Linie von (x1,y1) nach (x5,y5) (Rekursionsanker)
Für n > 0 ruft sich die Funktion vier mal selbst mit n - 1 und den entsprechenden Koordinaten für die 4 Teilstücke wieder auf (Rekursionsschritt). Folgende Abbildung Zeigt die Berechnung der Koordinaten der Teilstücke:

[!https://moodle.hu-berlin.de/pluginfile.php/5835313/mod_assign/intro/grafik%20%282%29.png]

Hinweise

Sie dürfen die Definition der Funktion zeichneKochKurve() nicht verändern, d.h. bspw. nicht deren Namen verändern und keine zusätzlichen Parameter einfügen oder entfernen.
Belassen Sie auch die main() Methode im Ursprungszustand der Vorlage.
Falls notwendig können Sie eigene Funktionen hinzufügen.
Zur Berechnung der Wurzelfunktion können Sie die in Java bereits vorhandene Funktion Math.sqrt() nutzen.
Denken Sie daran Ihr Programmquellcode zu kommentieren und auf dem Referenzsystem zu testen. Laden Sie die Datei KochSchneeflocke.java als einfache Textdatei in UTF-8-Kodierung (ohne BOM) rechtzeitig in Moodle hoch.