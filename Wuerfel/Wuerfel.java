public class Wuerfel {
	public static void main(String[] args) {
		//Abbruch wenn mehr oder weniger als drei Eingaben uebergeben wurden
		if(args.length != 3){
			System.out.println("Benötige als Eingabe: <N> <K> <S>");
			System.exit(-1);
		}
		// Setze n, k und s Auf die uebergebenen Werte
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int s = Integer.parseInt(args[2]);
		//Setze die Anzahl der Treffer (Erfuellung der Bedingung K mal hintereinander N erreicht) auf 0
		int point = 0;
		// Wiederholung die Zufallsziehung S mal
		for (; s>0; s--){
			//Ziehung von z einer Zufallszahl von 1 bis N
			int z = (int) (Math.random()*n)+1;
			//Wenn N gezogen, Veringerung von k um 1, sonst Zuruecksetzung von k 
			k = (z == n)? k-1 : Integer.parseInt(args[1]);
			//Wenn K mal in Folge N gezogen, dann Erhoehung von point um 1 und Zurueksetzung von k
			if(k == 0){
				k = Integer.parseInt(args[1]);
				point++;
			}
			
}
		//Ausgabe der Berechnung der durchschnittlichen Anzahl der Versuche um K hintereinander mal N zu ziehen
		System.out.println((double)Integer.parseInt(args[2]) / point);




}}