# Aufgabe 1: Caesar-Verschlüsselung, String (10 Punkte)
Caesar-Verschlüsselung ist ein einfaches symmetrisches Verschlüsselungsverfahren. Dabei wird eine Textnachricht verschlüsselt, indem jeder Buchstabe um eine feste Anzahl von Stellen K innerhalb des Alphabets verschoben wird. Die Verschiebung erfolgt zyklisch, d.h. wenn ein Buchstabe über den letzten Buchstaben 'Z' hinausgeschoben wird, dann wird wieder von 'A' angefangen. Für K>0 erfolgt eine Verschiebung nach rechts und für K<0 eine Verschiebung nach links.

Beispiel:
Für K=3 werden die Kleinbuchstaben wie folgt verschoben:
```
Original: a b c d e f g h i j k l m n o p q r s t u v w x y z
Geheim:   d e f g h i j k l m n o p q r s t u v w x y z a b c
```
Nachricht: hello world wird zu khoor zruog.

Bemerkung: Die Entschlüsselung der Nachricht erfolgt durch eine umgekehrte Verschiebung (also in dem obigen Beispiel mit K=−3).

Schreiben Sie ein Programm, das Textnachrichten mithilfe einer Caesar-Verschlüsselung verschlüsselt, bzw. entschlüsselt. Das Programm muss folgende Anforderungen erfüllen:

Es werden nur Buchstaben [a-z] und [A-Z] verschoben, alle anderen Zeichen bleiben erhalten;
Kleine Buchstaben bleiben nach dem Verschieben klein und große groß. Zum Beispiel für K=3
 wird 'z' zu 'c' und 'Z' zu 'C';
Das Programm soll in einer Datei Caesar.java implementiert werden;
Der Verschiebeschlüssel K
 und die zu verschlüsselnde Nachrichten werden an das Programm wie folgt als Parameter übergeben:

```$ java Caesar <K> <Nachricht_1> ... <Nachricht_N>```

Beispiel:

```$ java Caesar 3 "Hello World!" "Bla, Bla, Bla."```
Es können mehrere Nachrichten übergeben werden;
Jede der übergebenen Nachrichten soll mit dem Schlüssel K verschlüsselt werden;
Die verschlüsselten Nachrichten sollen zeilenweise auf die Konsole ausgegeben werden. Zum Beispiel erzeugt der obige Aufruf folgende Ausgabe:

```
$ java Caesar 3 "Hello World!" "Bla, Bla, Bla."
Khoor Zruog!
Eod, Eod, Eod.
```
Hinweis: Um auf einzelne Buchstaben der Zeichenketten zuzugreifen nutzen Sie die Methode String.toCharArray(), die die Zeichenkette in ein Array von Buchstaben umwandelt. Beispiel:
```
String s = "Hello World.";
char[] buchstaben = s.toCharArray();
```
Sparen Sie nicht mit hilfreichen Kommentaren!
Bitte laden Sie die Datei Caesar.java rechtzeitig bei Moodle hoch.
