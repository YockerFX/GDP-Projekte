# Aufgabe 4.1: Weihnachtsplätzchen (10 Punkte)

Die Weihnachtszeit steht kurz bevor und damit auch das allseits beliebte Backen von Weihnachtsplätzchen. Auch beim Backen von Plätzchen möchte man natürlich stets hohe Qualitätsstandards sicherstellen. Wir betrachten daher im Folgenden eine ausgeklügelte Peer-Review-Strategie, um diese Standards zu gewährleisten. Grundlage der Strategie ist es, einzelne Plätzchen stichprobenartig auszuwählen und zu „testen“. Bei einer stark wachsenden Anzahl an Plätzchen möchten wir jedoch sicherstellen, dass die Testmenge nicht zu schnell wächst, da dem Tester ansonsten unwohl werden könnte. Daher wird folgende Strategie angewendet:
 Wenn kein Plätzchen da ist, kann auch keines probiert werden.
Wenn es nur ein Plätzchen gibt, sollte dieses auch getestet werden.
Wenn es eine gerade Anzahl an Plätzchen gibt, werden 2 Plätzchen getestet. Die
verbleibende Menge wird dann in zwei gleichgroße Haufen geteilt und nur ein Haufen wird
weiter getestet.
Wenn es eine ungerade Anzahl an Plätzchen gibt, dann testen wir eines und testen die
verbleibende Menge wie zuvor.
Implementieren Sie ein Java-Programm PlaetzchenPruefer.java, welches eine rekursive Funktion enthält, die zu einer gegebenen Anzahl an Plätzchen die Anzahl der getesteten Plätzchen wie ober beschrieben berechnet und zurückgibt. Die Funktion soll folgende Signatur haben:


```public static int pruefePlaetzchen(int anzahlPlaetzchen)```

Ihr Programm soll die Anzahl der zu testenden Plätzchen als Argument beim Aufruf erhalten und die Anzahl der zu prüfenden Plätzchen ohne weitere, beschreibende Informationen auf der Standardausgabe ausgeben.Zum Beispiel, um die Anzahl zu prüfenden Plätzchen für 100 gebackene Plätzchen zu ermitteln wird das 

Programm wie folgt aufgerufen:
```

$ java PlaetzchenPruefer 100
13
```
Denken Sie daran Ihr Programmquellcode zu kommentieren und auf dem Referenzsystem zu testen. Laden Sie die Datei PlaetzchenPruefer.java als einfache Textdatei in UTF-8-Kodierung (ohne BOM) rechtzeitig in Moodle hoch.