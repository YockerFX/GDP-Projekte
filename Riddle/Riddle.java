public class Riddle {
	
	public static String feld(int N){
		// Erstellung Feld als Array
		int[] feld = new int[2*N];
		// N <= 10 ->Ausgabe der Loesungen
		boolean print = false;
		if(N <= 10) { print = true;}

		//Ermittelung der Loesungen
		int out = teste(feld, N, print);
		// Ausgabe der Anzahl der Loesungen
		if(out == 0) {return "keine Loesung \n";}
		if(out == 1) {return "eine Loesung \n";}
		return out + " Loesungen\n";
		

	}

	public static int teste(int[] feld, int N, boolean print){
		// Abbruchbedingung
		if(N == 0){			
			// Ausgabe der Loesungen im Terminal
			if(print){
				for(int i = feld.length-1; i > -1; i--){
					System.out.print(feld[i]);
				}
				System.out.println();
			}
			return 1;
		}

		//erste Feld muss vor dem letzten belegt werden 
		int len = (feld[0] == 0)? (feld.length -2) : (feld.length -1);

		// Zaehler fuer die Loesungen durch die Rekursion
		int out = 0;
		int[] copy;

		//Rekursive Aufruf fuer jede Position der des aukuellen N	
		for (int i = 0; i < len-N;i++){
			if(feld[i]==0)
				if(feld[i+1+N] == 0){
					copy = feld.clone();
					copy[i] = N;
					copy[i+1+N] = N;
					out += teste(copy, N-1, print);
				}
		}
		return out;
	}


	public static void main(String[] args) {
		// Behandlung fehlender oder falscher Eingabeparameter
		if(args.length != 1){
			System.out.print("Bitte eine Zahl als Parameter angeben.\n");
			System.exit(-1);
			}
		int n = Integer.parseInt(args[0]);
		if(n < 1 || n > 15){
			System.out.print("Die Zahl muss größer als 0 und maximal 15 sein.\n");
			System.exit(-1);
		}
		System.out.print(feld(n));

	}
}