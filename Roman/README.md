# Aufgabe 1: Römische Zahlen
Implementieren Sie in einem Java-Programm Roman.java eine Funktion

```static String roman(int n)```
die (positive) ganze Zahlen im Bereich von 1 bis 5000 im Römischen Zahlensystem (als String) in der üblichen Schreibweise (Ziffernzeichen I1V5X10L50C100D500M1000
) gemäß der römischen Zahlschrift darstellt. Überlegen Sie sich insbesondere, wie dabei Rekursion zum Einsatz kommen kann. Benutzen Sie dieses Quelltextfragment als Ausgangspunkt:
```
public class Roman {
	static String roman(int n) { /* TODO */ }
	public static void main(String[] args) {
		// Behandlung fehlender oder falscher Eingabeparameter
		assert(1 <= N && N <= 5000);
		System.out.println(roman(N));
	}
}
```
Es folgen einige Beispielaufrufe, die das Format der Ausgabe verbindlich vorgeben. Falls ein Parameter beim Programmaufruf angegeben wurde, können Sie davon ausgehen, dass es sich um eine ganze Zahl handelt.
```
$ java Roman
Bitte eine Zahl als Parameter angeben.
$ java Roman 0
Die Zahl muss zwischen 1 und 5000 liegen.
$ java Roman 1
I
$ java Roman 5000
MMMMM
```