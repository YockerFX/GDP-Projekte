public class Caesar {
    public static void main(String[] args) {
	// Abfangen von Aufrufen mit weniger als 2 Eingaben
	if(args.length < 2){
		System.out.println("Benötige folgende Eingabe: <int K> <String Nachricht_1> ... <String Nachricht_N>");
		System.exit(-1);
	}
	// Setze k auf die erste Eingabe
	int k = Integer.parseInt(args[0]);
	// Abfangen von Eingaben mit Betrag von K groesser als 26	
	if(k < -26 || k > 26){
		System.out.println("Der Betrag von K darf maximal 26 sein.");
		System.exit(-1);
	}
	// Wiederholung der Verschluesselung fuer alle Eingegebenen Strings
	for(int i = 1; i < args.length; i++){
		// Setze s auf
		char[] s = args[i].toCharArray();
		//Wenn k groesser als 0 dann Verschiebung nach Rechts
		if(k > 0){
			//Durchfuehrung der Verschluesselung fuer jeden Buchstanben c im String s
			for(char c: s){
				c += (c >= 65 && c <= (90-k))?k : (c >= (90-k) && c <=90 )?(-26+k): 0 ;
				c += (c >= 97 && c <= (122-k))?k : (c >= (122-k) && c <=122 )?(-26+k): 0 ;
				//Ausgabe des verschluesseltem Buchstaben
				System.out.print( c);
}}
		//Wenn k kleiner als 0 dann Verschiebung nach Links
		if(k < 0){
			//Durchfuehrung der Verschluesselung fuer jeden Buchstanben c im String s
			for(char c: s){
				c += (c <= 90 && c >= (65-k))?k : (c <= (65-k) && c >=65 )?(26+k): 0 ;
				c += (c <= 122 && c >= (97-k))?k : (c <= (97-k) && c >=97 )?(26+k): 0 ;
				//Ausgabe des verschluesseltem Buchstaben
				System.out.print(c);
			
}}
		System.out.println();
}
    }
}