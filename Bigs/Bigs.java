public class Bigs {

	// entfernt fuehrende Nullen
	static int[] cutNull(int[] n){
		int[] m;
		while(n[n.length-1] == 0){
			m = new int[n.length-1];
			for(int i = m.length -1; i >= 0; i--){
				m[i] = n[i];
			}
			n = m;
		}
		return n;
	}

	// addiert die Ziffernfelder a und b
	static int[ ] add (int[ ] a, int[ ] b) { 
		int length = (a.length>b.length)? a.length + 1: b.length + 1;
		int[] out = new int[length];
		for(int i = 0; i < out.length-1; i++){
			out[i+1] = ( (out[i]+((i < a.length)?a[i]:0)+((i < b.length)?b[i]:0))/10);
			out[i] = ( (out[i]+((i < a.length)?a[i]:0)+((i < b.length)?b[i]:0))%10);
		}
		return cutNull(out);
	}
			
	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	static void print (int[ ] n){
		for (int i = n.length-1; i >= 0; i--){
			System.out.print(n[i]);
		}
		System.out.println();
	}
	
	// konstruiert ein einstelliges Ziffernfeld aus d
	static int[ ] digit(int d){
		int[] out = new int[1];
		out[0] = d%10;	// um aus jeder Ganzzahl eine einzige ziffer zu bekommen rechenen wir % 10 	
		return out;
	}
 
	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[ ] Null() {
		int[] out = {0};
		return out;
	}
	
	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[ ] One(){
		int[] out = {1};
		return out;
	}

	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[ ] n) {
		return n[0];
	}

	// ganzzahliger Quotient bei Division durch 10
	static int[ ] div10(int[ ] n){ 
		int [] out = new int [n.length-1];
		for (int i = n.length-1; i > 0; i--){
			out[i-1]=n[i];
		}
		return out;
	}

	// Umwandlung einer int-Zahl in ein Ziffernfeld	
	static int[ ] fromInt(int n){
		int length = 1;
		int space = 10;
		while(n >= space){
			length++;
			space *= 10;
		}
		int[] out = new int[length];
		for(int i = 0; i < length; i++){
			out[i] = n % 10;
			n /= 10;
		}
		return out;
	}

	// kopiert den Wert von a
	static int[ ] copy(int[ ] n){
		int[] out = new int[n.length];
		for (int i = n.length-1; i >= 0; i--){
			out[i]=n[i];
		}
		return out;
	}

	// multipliziert das Ziffernfeld a mit einer int-Zahl
	static int[ ] times(int[ ] n, int d){
		int[] out = fromInt(d);
		return times(n, out);	
	}

        // multipliziert das Ziffernfeld n mit 10
	static int[ ] times10(int[ ] n){
		int[] out = new int[n.length+1];
		for(int i = n.length; i > 0; i--){
			out[i] = n[i-1];
		}
		return out;
	}

	// multipliziert zwei Ziffernfelder	
	static int[ ] times(int[ ]a, int[ ] b)   {
		int[] out = new int[a.length + b.length+1];
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < a.length; j++){
				out[i+j] += a[j] * b[i];
				out[i+j+1] += out[i+j] / 10;
				out[i+j] %= 10;
			}
			
		}
		return cutNull(out);
	}

        // Quadratzahl eines Ziffernfeldes
	static int[ ] square(int[ ]a)            {
		return times(a, a);
	}

    // Kubikzahl eines Ziffernfeldes
	static int[ ] cubic(int[ ]a){
		return times(times(a, a),a);
	}

    // ist dieses Ziffernfeld ein Palindrom? Bemühen Sie sich um eine Implementation,
    // die ohne ein weiteres Zahlenfeld auskommt !
	static boolean palindrom(int[] a){
		a = cutNull(a);
		int j = 0;
		for(int i = a.length -1; i > j; i--){
			if(a[i] != a[j++]){return false;}
		}
		return true;
	}

	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less (int[ ] a, int[ ] b) {
		if(a.length < b.length){return true;}
		if(a.length > b.length){return false;}
		for(int i = a.length -1; i >= 0; i--){
			if(a[i] < b[i]){return true;}
			else if(a[i] > b[i]){return false;}
		}
		return false;
	}

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal (int[ ] a, int[ ] b){
		if(a.length != b.length){return false;}
		for(int i = a.length -1; i >= 0; i--){
			if(a[i] != b[i]){return false;}
		}
		return true;
	}

	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
    // mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
    // keine fuehrenden Nullen (ausser bei Null selbst) 
	static boolean ok (int[ ] n){
		if(n.length < 0){return false;}
		if(n.length > 0 && n[n.length-1] == 0){return false;}
		for(int i = n.length -1; i >= 0; i--){
			if(n[i] < 0 || n[i] > 9){return false;}
		}
		return true;
	}

    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus
	static void maxDigit(int[] n){
		int[] count = new int[10];
		for (int i = n.length -1; i >= 0; i--){
			count[n[i]]++;
		}
		int max = 0;
		for(int i = 1; i < 10; i++){
			if(count[i] > count[max]){max = i;}
		}
		System.out.println( max);
	}

	public static void main (String[ ] s) {
  		int[] a = One();

		for (int i=0; i<33222; ++i) {
			a = times(a, 2);
		}

		System.out.println("2^33222 hat " + a.length + " Stellen");
		print(a); 
		System.out.println(); 

		int[] b = fromInt(13);
		int[] c = copy(b);
		
		for (int i=1; i<8978; ++i) {
			c=times(c, b);
		}
		
		System.out.println("13^8978 hat " + c.length + " Stellen");
		print(c); 
		System.out.println(); 

		System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
                maxDigit(a);
                maxDigit(c);
	}
}
