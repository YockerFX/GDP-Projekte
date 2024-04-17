public class PlaetzchenPruefer{

	public static int pruefePlaetzchen(int anzahlPlaetzchen){
		//Rekursionsabbruch
		if(anzahlPlaetzchen == 0){return 0;}

		//Rekursionsauffruf fuer gerade Anzahl
		if(anzahlPlaetzchen % 2 == 0){return 2 + pruefePlaetzchen((anzahlPlaetzchen-2)/2);}

		//Rekursionsauffruf fuer ungerade Anzahl
		return 1 + pruefePlaetzchen((anzahlPlaetzchen-1));
	}

	public static void main(String[] args){

		//Kontrolle ob genau eine Eingabe gegeben wurde
		if(args.length != 1){
			System.out.println("Bitte geben Sie eine positive dezimal Ganzzahl ein.");
			System.exit(-1);
		}
		int nPlaetzchen = Integer.parseInt(args[0]);

		//Kontrolle ob die Anzahl natuerlich ist
		if(nPlaetzchen < 0){
			System.out.println("Bitte geben Sie eine positive dezimal Ganzzahl ein.");
			System.exit(-1);
		}

		//Ausgabe und Aufruch der Funktion
		System.out.println(pruefePlaetzchen(nPlaetzchen));
	}
}