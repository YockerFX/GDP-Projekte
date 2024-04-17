# Zahlenpalindrome (20 P)
Beschreibung
Bilden Sie den folgenden Algorithmus in Java nach:

Für eine beliebige natürliche Zahl N (in Dezimalschreibweise) sei R die Zahl, die sich durch 'Rückwärtslesen' der Ziffernfolge von N ergibt. N
 und R werden nun addiert. Ist die Summe eine Palindromzahl (eine Zahl, die vorwärts und rückwärts gelesen den gleichen Wert ergibt), ist der Algorithmus beendet. Falls die Summe keine Palindromzahl ist, wird der Algorithmus erneut auf die entstandene Summe angewendet: N wird dabei durch N+R ersetzt.

Für viele Zahlen terminiert dieser Algorithmus nach wenigen Iterationen, etwa:
```
N = 123 .... R = 321 .... Summe = 444 .... Palindrom, 
fertig nach einer Iteration

N = 19  .... R = 91 .... Summe = 110 .... kein Palindrom, 
N = 110 .... R = 11 .... Summe = 121 .... Palindrom, 
fertig nach zwei Iterationen
			
N = 983  .... R = 389  .... Summe = 1372 .... kein Palindrom, 
N = 1372 .... R = 2731 .... Summe = 4103 .... kein Palindrom, 
N = 4103 .... R = 3014 .... Summe = 7117 Palindrom, 
fertig nach drei Iterationen
```
Es gibt jedoch auch Zahlen, für die der Algorithmus (vermutlich) nie terminiert.

Implementieren Sie ein Java-Programm, welches beim Aufruf mit einer Dezimalzahl (z.B. 300) als Programmparameter (maximal 100000) alle Zahlen bis zu dieser Parameterzahl ausgibt, für die der o.a. Algorithmus nicht (wie unten beschrieben) terminiert.

Das Programm
```
$ java Looping 300 
196
295
```

soll demnach alle Zahlen mit der geforderten Eigenschaft bis 300 (eine pro Zeile) ausgeben. Es sind tatsächlich die beiden angegebenen. Falls das Programm ohne Argument aufgerufen wird, soll es eine entsprechende Fehlerausgabe erzeugen und sofort beendet werden.

```
$ java Looping
Bitte geben Sie die Obergrenze als Parameter an.
```
Sie können (vereinfachend) zunächst davon ausgehen, dass eine Zahl, die nach 100 Iterationen noch kein Palindrom erzeugt hat, vermutlich die geforderte Eigenschaft besitzt. Später werden wir konkret ein anderes Abbruchkriterium benutzen (Überlauf im Zahlenbereich long). Ob es tatsächlich (Dezimal-)Zahlen gibt, für die der Algorithmus nie abbricht, ist übrigens völlig offen!

Für den direkten Nachweis, dass ein Algorithmus nicht terminiert, ist dessen Abarbeitung auf Rechnern nun mal leider nicht geeignet lächelnd

Da die entstehenden Zahlen in jedem Iterationsschritt größer werden (im Durchschnitt verdoppeln sie sich in jedem Schritt), haben wir allerdings mit der Zählung der Iterationsschritte (bis maximal 100) ein ganz anderes Problem: Wenn Sie für die Darstellung von N und R den Typ int verwenden, werden Sie feststellen, dass schon bei der Berechnung für N=89 (stillschweigend) ein Überlauf stattfindet, der natürlich alle nachfolgenden Schritte falsch werden lässt. Eigentlich müsste für N=89 nach 24 Iterationen das Palindrom 8813200023188 entstehen! Verwenden Sie also gleich den Typ long der allerdings auch von dem Problem des Überlaufs (nur etwas später) betroffen ist.

Benutzen Sie demnach die Tatsache, dass u.U. bei der nächsten Addition N+R ein Überlauf stattfindet, direkt (und ausschließlich!) als Abbruchkriterium der oben beschriebenen Iteration (weit unter 100 Durchläufen). Informieren Sie sich dazu hier über die Klasse Long über Long.MAX_VALUE und verwenden Sie diese Konstante im Programm (statt deren numerischen Wert 9223372036854775807).

Hilfestellung
Entwickeln (und testen) Sie Ihren Algorithmus stufenweise, so dass Sie sicher sind, dass der bisher erstellte (Teil-)Algorithmus korrekt arbeitet, bevor Sie ihn in der nächsten Stufe verwenden! Fangen Sie mit einem Kern des Algorithmus an, der zunächst für ein festes (aber im Test variierendes) N die Zahl R (korrekt!) bestimmt. Davon können Sie sich überzeugen, indem das Programm das errechnete R ausgibt:
```
public static void main(String[] s) {
	long N = 123; // und andere Werte, auch mal mit 0 als Einerziffer :-)
	// Ihr Kernalgorithmus …
	long R = … // der von Ihnen bestimmte ‚umgedrehte‘ Zahlenwert
	System.out.println("R = " + R);  // ist es 321?
}
```
Die nächste Stufe könnte sein, dass Sie den Überlauftest implementieren:
```
public static void main(String[] s) {
	long N = …; // Werte, die zum Ueberlauf fuehren oder nicht
	// Ihr Kernalgorithmus …
	long R = … // der von Ihnen bestimmte ‚umgedrehte‘ Zahlenwert
	// System.out.println("R = " + R); // wird nicht mehr gebraucht, kann
	// aber als Kommentar im Programm verbleiben und ggf. aktiviert werden
	
	if (N+R könnte zu einem Überlauf führen)
		System.out.println("Ueberlauf"); 
	else 
		System.out.println(N+R); // korrekt, ohne Ueberlauf 
}
```
Danach vielleicht die Erkennung ob N schon ein Palindrom ist? Dafür haben Sie eigentlich schon alles parat lächelnd

Achtung: Ist die Startzahl selbst ein Palindrom (z.B. 4994) soll der Algorithmus noch nicht abbrechen, sondern wenigstens einmal N+R
 bestimmen!

Nun könnten Sie die Iteration einbauen, die in einer Schleife N
 durch N+R
 ersetzt, das neue R
 bestimmt und die Schleife verlassen, wenn ein Überlauf droht.

Abschließend (wenn bis dahin alles wie erwartet funktioniert) setzen Sie alles bisherige in eine Schleife, die N
 bis zur (als Programmparameter gegebene) Obergrenze variiert.

## Zusatzaufgabe für Fortgeschrittene (5 Zusatzpunkte)
Die oben beschriebene Abbruchbedingung (bei drohendem Überlauf) führt u.U. dazu, dass Zahlen ausgegeben werden, die zu einem Palindrom geführt hätten (also genau genommen nicht zu den erwünschten Zahlen in der Ausgabe gehören), wenn wir die Berechnung nur lange genug (z.B. wirklich bis 100 Iterationen) hätten ausführen können. Ermitteln Sie (zusätzlich zur bislang beschriebenen Aufgabe und offenbar mit einer anderen Zahlenrepräsentation als long) die kleinste Zahl, bei der bei bis zu 100 Iterationen doch ein Palindrom entsteht, also die kleinste, die bei Überlauf-Abbruch in der Ausgabe bei der Basisaufgabe erscheint, aber eigentlich nicht dazugehört (weil sie bei ‚exaktem‘ Rechnen in einem Palindrom endet)?

Ihr Programm soll dann (neben der oben beschriebenen Grundfunktionalität) einen zusätzlichen Parameter (x
 als zweites Argument) berücksichtigen:
```
$ java Looping 12345 
196
295
```
…                              wie gehabt
```
$ java Looping 1234 x```

alle Zahlen werden auch durch Abbruch per Ueberlauf gefunden

```$ java Looping 12345 x```

????? braucht ?? Iterationen bis zum Palindrom ??? …… ???  
Statt der Fragezeichen soll Ihr Programm natürlich die richtige kleinste Zahl (wie oben beschrieben), die Anzahl der Iterationen für diese Zahl und das entstehende Palindrom ausgeben.