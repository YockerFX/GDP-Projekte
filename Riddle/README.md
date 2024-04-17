# Aufgabe 2: Zahlenrätsel
In einem Feld der Länge 2∗N sollen die Zahlen von 1 bis N so platziert werden, dass jede Zahl genau zweimal vorkommt und zwischen den beiden Platzierungen jeder Zahl n exakt n andere Zahlen in dem Feld stehen. Die folgende Abbildung zeigt eine Lösung für N=3.

Die Zahl 2 3 1 2 1 3 als mögliche Lösung für N = 3.

Implementieren Sie eine Klasse Riddle, die das Problem für 0<N≤15 löst, indem es entweder die Zeichenkette "keine Loesung“ ausgibt, wenn keine Lösung existiert, oderfalls Lösungen existieren für N<10 alle (verschiedenen) Lösungen nacheinander (im weiter unten angegebenen Format) zeilenweise gefolgt von einer Zeile mit der Anzahl der gefundenen Lösungen ausgibt, oderfalls Lösungen existieren für N≥10 nur die Anzahl der verschiedenen Lösungen ausgibt.
Als verschieden gelten zwei Lösungen dann, wenn sie NICHT durch Spiegelung (rückläufiges Auslesen des Feldes) aufeinander identisch abgebildet werden können. In diesem Sinne sind für N=3 die Lösungen

2 3 1 2 1 3  und 3 1 2 1 3 2 identisch. In diesem Fall soll NUR die Lösung ausgegeben werden, die mit der kleinsten Zahl beginnt (hier die erste von beiden).

Überlegen Sie sich eine Lösung, die das Problem geeignet rekursiv angeht! Versuchen Sie dazu, Ihre Vorgehensweise beim Lösen mit Papier und Bleistift (und Radiergummi?) so zu formulieren, dass ein rekursiver Ansatz erkennbar wird.

Halten Sie sich an das Format der folgenden (korrekten) Musterausgaben:
```
$ java Riddle 1
keine Loesung
$ java Riddle 2
keine Loesung
$ java Riddle 3
231213
eine Loesung
$ java Riddle 7
23726351417654
26721514637543
23627345161475
36713145627425
26327435614175
26325734615147
24723645317165
46171435623725
52462754316137
35723625417164
27423564371516
25623745361417
52642753461317
41617435263275
41716425327635
34673245261715
15146735423627
15163745326427
15173465324726
16135743625427
14167345236275
14156742352637
15167245236473
16172452634753
17126425374635
17125623475364
26 Loesungen
$ java Riddle 10
keine Loesung
$ java Riddle 11
17792 Loesungen
```