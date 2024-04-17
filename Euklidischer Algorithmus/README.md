# Euklidischer Algorithmus (11 P)
Beschreibung
Erstellen Sie (am besten in einem neuen eclipse-Projekt) ein Java-Programm GGT.java, welches (in Anlehnung an die demonstrierte Berechnung der Summe zweier Zahlen) den größten gemeinsamen Teiler von zwei positiven ganzen Zahlen nach dem Euklidischen Algorithmus berechnet und ausgibt.

Das Prinzip des Euklidischen Algorithmus wird auch gegenseitige Wechselwegnahme genannt. Eingangsgrößen seien zwei positive ganze Zahlen a
 und b
. Bei der Berechnung verfährt man nach Euklid wie folgt:

Setze m=a und n=b
Ist m<n, so vertausche m und n
Berechne r=m−n
Setze m=n und n=r
Ist r≠0, so fahre fort mit Schritt 2
Nach Ablauf des Verfahrens hat man mit m den ggT von a und b gefunden.

Überzeugen Sie sich durch geeignete Tests von der Korrektheit Ihrer Implementation. Versuchen Sie auch den Algorithmus strukturell so zu formulieren, dass man die obige verbale Beschreibung wiedererkennen kann. Sorgen Sie dafür, dass im Programm geprüft wird, ob die beiden als Argumente übergebenden Zahlen tatsächlich echt positiv (also > 0) sind. Ansonsten funktioniert der oben beschriebene Ablauf vielleicht gar nicht richtig!? Das macht man in Java beispielsweise so:

// die Bedingung muessen Sie natuerlich geeignet formulieren:
```
if (someCondition) {
	System.out.println("eine passende Ausschrift");
	System.exit(-1); // Programmm sofort beenden 
	// negative Parameter bei exit weisen den Rufer 
	// auf ein abnormales Ende hin 
}
```
Abschließend hier noch ein paar Beispielaufrufe, die zeigen, wie sich Ihr Programm verhalten soll - offenbar müssen Sie sich NICHT darum kümmern, dass tatsächlich zwei Zahlen als Argumente übergeben werden.
```
$ java GGT 12 14
ggT(12, 14) = 2
$ java GGT 36 12
ggT(36, 12) = 12
$ java GGT 36 -12
nur positive ganze Zahlen als Argumente erlaubt
$ java GGT -36 12
nur positive ganze Zahlen als Argumente erlaubt
$ java GGT 666
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
        at GGT.main(GGT.java:6)
$ java GGT 6 sieben
Exception in thread "main" java.lang.NumberFormatException: For input string: "sieben" at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.lang.Integer.parseInt(Integer.java:492)
        at java.lang.Integer.parseInt(Integer.java:527)
        at GGT.main(GGT.java:6)
```
(dabei können die angegebenen Zeilennummern natürlich andere sein: sie beziehen sich auf Ihren Quelltext und auf die jeweilige Implementation der Java-Bibliothek)

