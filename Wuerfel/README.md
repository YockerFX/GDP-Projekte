# Aufgabe 2: Würfelexperimente, Schleifen (10 Punkte)
Einige Problemklassen lassen sich unter Nutzung von Zufallszahlen lösen. Einige Algorithmen, die auf der Nutzung von Zufallszahlen basieren, werden auch randomisierte Algorithmen genannt. Für die Erzeugung von Zufallszahlen besitzt Java die Funktion Math.random(). Diese Methode liefert einen zufälligen Wert zwischen 0.0 und 1.0 vom Typ double. Die erzeugten Zufallswerte sind gleichverteilt, das bedeutet, dass jeder Wert zwischen 0.0 und 1.0 mit gleicher Wahrscheinlichkeit zurückgegeben wird.

Wir betrachten einen fairen N-seitigen Würfel, das heißt, dass bei einem Wurf jede Augenzahl von 1
 bis N mit gleicher Wahrscheinlichkeit fällt. Das bedeutet, dass bei einem Wurf jede Zahl des Würfels mit gleicher Wahrscheinlichkeit fällt. Das Gesetz der großen Zahlen besagt (vereinfacht gesagt), dass nach sehr vielen Versuchen jede der Augenzahlen in etwa gleich oft auftreten wird.

Wir stellen uns nun ein einfaches Würfelspiel vor, das gewonnen ist, wenn die höchste Zahl des Würfels (N), K-mal in Folge (direkt hintereinander) gewürfelt wird. Wie lange dauert ein solches Spiel durchschnittlich? Das heißt, wie oft muss durchschnittlich gewürfelt werden, bis K-mal hintereinander N gefallen ist?

Schreiben Sie ein Java Programm Wuerfel.java, welches diese Frage mithilfe einer Simulation beantwortet.

Die Anzahl der Seiten des Würfels N, die zum Gewinn notwendige Anzahl K, sowie die Zahl der Spiele S sollen dem Programm als Argumente übergeben werden:

```$ java Wuerfel <N> <K> <S>```
Beispiel: zweiseitiger Würfel (Münze), Gewinnfolge 5, Wiederholungen 100000

```$ java Wuerfel 2 5 1000000```
Ausgabe: Das Programm gibt die durchschnittliche Anzahl notwendiger Würfe bei Durchführung der S Spiele auf die Konsole aus. Zum Beispiel erzeugt der obige Aufruf folgende Ausgabe:

```
$ java Wuerfel 2 5 1000000
62.067853
```
Testen Sie das Programm mit verschiedenen Werten;

Bemerkung: Da die Simulation auf Zufallszahlen basiert kann das Ergebnis bei jedem Aufruf variieren. Je mehr Experimente durchgeführt werden (großes S), desto genauer wird das Ergebnis. Für lange Gewinnfolgen kann die Berechnung sehr lange dauern.

Berechnen Sie den Wert für N=6 und K=2. Testen Sie, wie hoch S gewählt werden muss, damit das Ergebnis sich nur noch in der Nachkommastelle ändert.

Sparen Sie auch hier nicht mit hilfreichen Programmkommentaren.

Bitte laden Sie die Datei Wuerfel.java rechtzeitig bei Moodle hoch.