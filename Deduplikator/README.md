# Aufgabe 3.1: Deduplikator (8 Punkte)
Schreiben Sie das Java-Programm Deduplikator.java welches per Kommandozeilenargument Zahlen als String übergeben bekommt, diese in double-Zahlen wandelt und gleichwertige Zahlen nur einmal ausgibt. Sollten also Zahlenwerte mehrfach auftreten, werden diese nicht nocheinmal ausgegeben. Jede Zahl wird in einer neuen Zeile ausgegeben, die Reihenfolge ist dabei beliebig.

Hier ein Beispielaufruf mit Ausgabe:
```
$ java Deduplikator 6.5 2.0 5.2E6 2 -33.7 1. 2.0E0 5 02 01
   6.5
   2.0
   5200000.0
   -33.7
   1.0
   5.0
```
Laden Sie bitte Ihre Java-Quelldatei Deduplikator.java als einfache Textdatei in UTF-8-Kodierung (ohne BOM) in Moodle hoch.