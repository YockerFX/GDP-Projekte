public class Looping {

// sum ist die Addition für als Dezimalzahlen interpretierte Strings

	public static String sum(String a, String b){
		while(a.length() > b.length()){b = "0" + b;}
		while(b.length() > a.length()){b = "0" + b;}

		char[] x = a.toCharArray();
		char [] y = b.toCharArray();
		String s = "";
		int merke = 0;
		for(int i = y.length -1; i >= 0; i--){
			x[i] += y[i] - 48*2 + merke;

			if(x[i] >= 10){
				x[i] -= 10;
				merke = +1;}
			else{merke = 0;}
			x[i] += 48;
			s = x[i] + s;
			

		}
		if( merke > 0){s = "1" + s;}
		return s;
	}

// Twist dreht die Zahl so dass anschließend die erste Zahl die letzte ist
	// fuer Dezimalzahlen
	public static long twist(long i){
		long count = 0;
		while(i > 0){
			count *=10;
			count += i % 10;
			i /= 10;
		}
		return count;
	}

	//Fuer Strings
	public static String twist(String s){
		char [] c = s.toCharArray();
		String o = "";
		boolean first = true;
		for(int i = c.length -1; i >= 0 ; i--){
			if(first){
				if(c[i] == '0'){
					continue;}
				else{first = false;}
			}
			o += c[i];
		}
		return o;
	}

//UEBerpruefung ob beide Zahlen identisch sind
	//fuer Dezimalzahlen
	public static boolean isPal(long a, long b){
		if(a == b){
			return true;
		}
		return false;
	}

	// Fuer Strings wird jeder einzelne Buchstabe (char) verglichen
	public static boolean isPal(String a, String b){
		if(a.length() != b.length()){return false;}
		char[] x = a.toCharArray();
		char [] y = b.toCharArray();
		for(int i = x.length -1; i >= 0; i--){
			if(x[i] != y[i]){return false;}
		}
		return true;
	}

	public static void main(String[] args) {
		// advanced wird auf true gesetzt falls der 2. Argument ein x ist
		boolean advanced = false;
		if(args.length == 2){advanced = ((args[1].toCharArray()[0] == 'x') || (args[1].toCharArray()[0] == 'X'));}
		// falls nicht 2 oder ein Argument eingegeben wurde
		else if(args.length != 1){
			System.out.println("Bitte geben Sie die Obergrenze als Parameter an.");
			System.exit(-1);
		}
		int l = Integer.parseInt(args[0]);
		// falls eine Zahl die negativ oder groeßer als 100000 eingegeben wurde
		if(l < 0 || l > 100000){
			System.out.println("Die Obergrenze muss zwischen 0 und 100000 liegen.");
			System.exit(-1);
		}

		// Beginn des Kernalgorithmus
		for(int i = 1; i <= l; i++){
			// setze N und R analog Aufgabenstellung
			long n = i;
			long r = twist(n);

			do{
				// UEberlauf
				if(Long.MAX_VALUE-n < r ){

					//Zustatz (Berechnung per String)
					if(advanced){
						String sn = String.valueOf(i);
						String sr = twist(sn);
	
						int count = 0;
						do{
							count++;
							sn = sum(sn,sr);
							sr = twist(sn);
						}while(!isPal(sn, sr) && count < 100);
						if(isPal(sn, sr)){
							System.out.println(i + " braucht " + count + " Iterationen bis zum Palindrom " + sn);
							// Beendung des Programms wenn der erste (kleinste gefunden wurde)							
							return;}
						//else{System.out.println(i + " braucht mehr als " + count +" Iterationen");}
					//ausgabe für des Wertes bei normaler Eingabe (ohne x)
					}else {System.out.println(i);}
					break;
				}
				n += r;
				r = twist(n);
			}while(!isPal(n, r));
		}
		

		
	}
}