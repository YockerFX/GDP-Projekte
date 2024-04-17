/**
  Klasse KochSchneeflocke zeichnet eine fraktale Schneeflocke. 
  Zum Kompilieren und ausfuehren wird die Klasse StdDraw der 
  Bibliothek stdlib.jar genutzt.

  Dokumentation zur stdlib:
    https://introcs.cs.princeton.edu/java/stdlib/
    
  Download:
    https://introcs.cs.princeton.edu/java/stdlib/stdlib.jar

  Dokumentation der Klasse StdDraw:
    https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html

  Beispiel: kompilieren unter Linux/OSX und Windows:
  javac -cp stdlib.jar KochSchneeflocke.java 

  Beispielaufruf Linux/OSX:
    java -cp .:stdlib.jar KochSchneeflocke 2 1.0
    
  Beispielaufruf Windows:
    java -cp ".;stdlib.jar" KochSchneeflocke 2 1.0
  
*/

public class KochSchneeflocke 
{

    public static void main(String[] args) 
    {
        // Parameter ist die gewuenschte Tiefe
        int depth = Integer.parseInt(args[0]);
         
        // Initialisiere Zeichenflaeche:
        // Setze die Aufloesung und die Groesse, 
        // sodass die Schneeflocke gut sichtbar ist
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(-0.3, 1.3);
        StdDraw.setYscale(-0.5, 1.0);
        
        // Optional: schalte double-buffering ein um schnell zu zeichnen.
        // Das Zeichnen erfolgt dann im Hintegrund und wird erst 
        // angezeigt, wenn StdDraw.show() aufgerufen wird (siehe unten)
        //StdDraw.enableDoubleBuffering();
        
        // Definiere die Punkte eines gleichschenkligen Dreiecks: 
        //   a = (0,0), b = (0.5, sqrt(3)/2), c = (1, 0)
        double ax = 0.0;
        double ay = 0.0;
        
        double bx = 0.5;
        double by = Math.sqrt(3.0) / 2.0;
        
        double cx = 1.0;
        double cy = 0.0;

        // Rufe fuer jede Seite des Dreiecks die rekursive Funktion
        // zum Zeichnen der Kochkurve auf.
        zeichneKochKurve(depth, ax, ay, bx, by);
        zeichneKochKurve(depth, bx, by, cx, cy);
        zeichneKochKurve(depth, cx, cy, ax, ay);
        
        // Optional: zeige, dass was im Hintergund gezeichnet wurde
        // (wenn double-buffering eingeschaltet ist)
        //StdDraw.show();
    }

    /**
    * Zeichnet rekrusiv eine Kochkurve mit der uebergebenen Tiefe 
    * im Linienabschnitt von (x1,y1) nach (x5, y5).
    * 
    * Fuer tiefe=0 zeichnet die Funktion einfach eine Linie von (x1,y1) nach (x5,y5) (Rekursionsanker). 
    * Fuer tiefe>0 ruft sich die Funktion viermal selbst mit tiefe-1 und den entsprechenden Koordinaten 
    * fuer die 4 Teilstücke wieder auf (Rekursionsschritt). 
    * 
    * @param tiefe - Aktuelle Tiefe der Kochkurve
    * @param x1    - x-Koordinate des Beginns des akutellen Linienabschnitts 
    * @param y1    - y-Koordinate des Beginns des aktuellen Linienabschnitts
    * @param x5    - x-Koordinate des Endes des aktuellen Linienabschnitts
    * @param y5    - y-Koordinate des Endes des aktuellen Linienabschnitts
    */
    public static void zeichneKochKurve(int tiefe, double x1, double y1, double x5, double y5) 
    {
    	// TODO: Implementieren Sie das Zeichnen der Koch-Kurve

		//Rekursionsabbruch bei Tiefe 0 & Linie zeichnen
		if(tiefe == 0){
			StdDraw.line(x1,y1,x5,y5);
			return;
		}
		
		//Berechnung der Werte 
		double x2 = x1 + 1. / 3 * (x5 - x1);
		double y2 = y1 + 1. / 3 * (y5 - y1);
		double x3 = 0.5 * (x1 + x5) + Math.sqrt(3.0) / 6.0 * (y1 -y5);
		double y3 = 0.5 * (y1 + y5) + Math.sqrt(3.0) / 6.0 * (x5 -x1);
		double x4 = x1 + 2. / 3 * (x5 - x1);
		double y4 = y1 + 2. / 3 * (y5 - y1);

		//Rekursionsauffruf der Ebene eins tiefer
		zeichneKochKurve(tiefe -1, x1, y1, x2, y2);
		zeichneKochKurve(tiefe -1, x2, y2, x3, y3);
		zeichneKochKurve(tiefe -1, x3, y3, x4, y4);
		zeichneKochKurve(tiefe -1, x4, y4, x5, y5);
	
/*
		StdDraw.line(x1,y1,x2,y2);
		StdDraw.line(x2,y2,x3,y3);
		StdDraw.line(x3,y3,x4,y4);
		StdDraw.line(x4,y4,x5,y5);*/
	
    }
}