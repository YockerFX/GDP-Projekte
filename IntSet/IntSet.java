/**
 * Mengen nichtnegativer ganzer Zahlen in kompakter
 * Speicherrepraesentation: ob eine Zahl in der Menge enthalten
 * ist, wird durch EIN BIT im Speicher erfasst!
 * 
 * <br>
 * Beispiel:
 * <br>
 * <code>
 * <br>IntSet set = new IntSet(8);
 * <br>int a[] = { 1, 3, 4, 5 };
 * <br>set.include( a );
 * <br>
 * <br> ... +---+---+---+---+---+---+---+---+
 * <br> ... | 0 | 0 | 1 | 1 | 1 | 0 | 1 | 0 |
 * <br> ... +---+---+---+---+---+---+---+---+
 * <br></code>
 */
public class IntSet implements Iterable<Integer> {
	private static final int BitsPerWord = Integer.SIZE;
	private final int Kapazitaet;
	private int[] storage;

	/**
	 * Konstruiert ein leere Zahlenmenge der Kapazitaet <code>n</code>:
	 * eine Menge, die (nichtnegative ganze) Zahlen im
	 * Bereich 0 bis n-1 als Elemente enthalten kann.
	 * 
	 * @param n die Kapazitaet der Menge
	 */
	public IntSet(int n, int[] konfiguration) {
		Kapazitaet = n;
		if(n < 0){
			System.out.println("Die Kapazitaet der Menge muss positiv sein.");
			n=0;}
		storage = konfiguration;
	}

	public IntSet(int n) {
        	Kapazitaet = n;
		if(n < 0){
			System.out.println("Die Kapazitaet der Menge muss positiv sein.");
			n=0;}
		storage = new int[((n-1) / BitsPerWord + 1)];
	}
    // Übergabe copie des Speicherarrays
    public int[] getArray(){
        int[] arr = new int[storage.length];
        for(int i = storage.length-1; i >= 0; i--){
            arr[i] += storage[i];
        }
        return arr;   
    }
	/**
	 * Ermittelt die Kapazitaet der Menge.
	 * 
	 * @return die Kapazitaet der Menge
	 */
    
	public int capacity() {
		return Kapazitaet;
	}

	/**
	 * Erzeugt aus <code>this</code> eine neue (identisch belegte) Zahlenmenge,
	 * die Werte im Bereich 0 bis n-1 als Elemente enthalten kann.
	 * 
	 * Die Originalmenge bleibt unveraendert!
	 * 
	 * @param n die Kapazitaet der Ergebnismenge
	 * @return die Ergebnismenge mit veraenderter Kapazitaet
	 */
	public IntSet resize(int n) {
		if(n < 0){
			System.out.println("Die Kapazitaet der Menge muss positiv sein.");
			return this;}
		int[] arr = new int[n / BitsPerWord +1];
	        int limit = (n > this.capacity())? this.capacity() : n;
	        for(int i = 0; i < arr.length && i < storage.length; i++){
		            arr[i] += storage[i];
	        }
	        arr[limit / BitsPerWord] = (storage[limit / BitsPerWord] & (~(-1<<limit%BitsPerWord)));
		IntSet s = new IntSet(n, arr);
	
		return s;
	}

	/**
	 * Ermittelt, ob eine nicht-negative ganze Zahl in der Menge enthalten ist.
	 * 
	 * @param e eine nichtnegative ganze Zahl
	 * @return ist e in dieser Menge enthalten?
	 */
	public boolean contains(int e) {
		if(e >= Kapazitaet){
			return false;}
        int position = e / BitsPerWord;
		int compare = 1 << (e % BitsPerWord);
		return compare == (storage[position] & compare);
	}

	/**
	 * Nimmt die Zahl <code>e</code> in diese Menge auf.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void insert(int e) {
        if(e >= Kapazitaet){
			System.out.println("Kapazität zu klein für " + e);
			return;}
		int position = e / BitsPerWord;
		int compare = 1 << (e % BitsPerWord);
		storage[position] = (storage[position] | compare);
	}

	/**
	 * Nimmt alle Elemente aus dem Array <code>es</code> in die Menge auf.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void insert(int es[]) {
		for(int e : es){
			insert(e);
}
	}
	
	/**
	 * Entfernt die Zahl <code>e</code> aus dieser Menge.
	 * 
	 * @param e eine nichtnegative ganze Zahl zwischen 0 und capacity
	 */
	public void remove(int e) {
        if(e >= Kapazitaet){
			System.out.println("Kapazität zu klein für " + e);
			return;}
		int position = e / BitsPerWord;
		int compare = ~(1 << (e % BitsPerWord));
		storage[position] = (storage[position] & compare);
	}

	/**
	 * Entfernt alle Elemente aus dem Array <code>es</code> aus der Menge.
	 * 
	 * @param es ein Array von nichtnegativen ganzen Zahlen
	 */
	public void remove(int[] es) {
		for(int e : es){
			remove(e);}
	}

	/**
	 * Berechnet die Komplementaermenge zu dieser Menge: die Menge gleicher
	 * Kapazitaet, die genau alle Elemente enthaelt, die nicht in
	 * <code>this</code> enthalten sind.
	 * 
	 * Originalmenge bleibt unveraendert !
	 * 
	 * @return die Komplementaermenge
	 */
	public IntSet complement() {
		int[] s = new int[storage.length];
		for(int i = storage.length -1; i >= 0; i--){
			s[i] = ~storage[i];
		}
        if((BitsPerWord * storage.length -Kapazitaet) > 0){
            int x = ~(-1 << (32-(BitsPerWord * storage.length -Kapazitaet)));
            s[storage.length-1] &= x;
        }
        IntSet r = new IntSet(Kapazitaet, s);
		return r;
	}

	/**
	 * Erzeuge aus <code>s1</code> und <code>s2</code> die Vereinigungsmenge
	 * <br>
	 * es wird eine Menge der Kapazitaet der groesseren
	 * Kapazitaet der beiden Mengen erzeugt
	 * <br>
	 * <code>s1</code> und <code>s2</code> bleiben unveraendert !
	 * 
	 * @param s1 Mengen, die
	 * @param s2 verknuepft werden sollen
	 * @return die Vereinigungsmenge
	 */
	public static IntSet union(IntSet s1, IntSet s2) {
            int c1 = s1.capacity();
            int c2 = s2.capacity();
            int[] arr1 = s1.getArray();
            int[] arr2 = s2.getArray();
        if(s1.capacity() > s2.capacity()){
            c1 = s2.capacity();
            c2 = s1.capacity();
            arr1 = s2.getArray();
            arr2 = s1.getArray();
        }
        int[] arr = new int[c2 / BitsPerWord +1];
        for(int i = c1/BitsPerWord; i >= 0; i--){
            arr[i] = arr1[i] | arr2[i];
        }
        for( int i = (c2 / BitsPerWord); i > (c1 / BitsPerWord); i--){
            arr[i] = arr2[i];
        }

        IntSet r = new IntSet(c2, arr);
		return r;
	}

	/**
	 * Erzeuge aus <code>s1</code> und <code>s2</code> die symmetrische
	 * Differenzmenge.
	 * 
	 * Die Eingabemengen bleiben unveraendert!
	 * 
	 * @param s1 erste Menge
	 * @param s2 zweite Menge
	 * @return die symmetrische Differenzmenge
	 */
	public static IntSet intersection(IntSet s1, IntSet s2) {
        int c1 = s1.capacity();
            int c2 = s2.capacity();
            int[] arr1 = s1.getArray();
            int[] arr2 = s2.getArray();
        if(s1.capacity() > s2.capacity()){
            c1 = s2.capacity();
            c2 = s1.capacity();
        }
        int[] arr = new int[c2 / BitsPerWord +1];
        for(int i = c1/BitsPerWord; i >= 0; i--){
            arr[i] = arr1[i] & arr2[i];
        }

        IntSet r = new IntSet(c2, arr);
		return r;
	}

	/**
	 * Erzeugt aus <code>s1</code> und <code>s2</code> die Differenzmenge mit
	 * der Kapazitaet von s1.
	 * 
	 * Beide Eingabemengen bleiben unveraendert!
	 * 
	 * @param s1 erste Menge
	 * @param s2 zweite Menge
	 * @return die Differenzmenge
	 */
	public static IntSet difference(IntSet s1, IntSet s2) {
         int c1 = s1.capacity();
            int c2 = s2.capacity();
            int[] arr1 = s1.getArray();
            int[] arr2 = s2.getArray();
        if(s1.capacity() > s2.capacity()){
            c1 = s2.capacity();
            c2 = s1.capacity();}
        int[] arr = new int[c2 / BitsPerWord +1];
        for(int i = c1/BitsPerWord; i >= 0; i--){
            arr[i] = arr1[i] & (~arr2[i]);
        }
        for(int i = (s1.capacity() / BitsPerWord); i > (c1 / BitsPerWord); i--){
            arr[i] = arr1[i];
        }
        IntSet r = new IntSet(c2, arr);
		return r;
	}

	/**
	 * Stringrepraesentation der Bits dieser Menge beginnend mit Index 0,
	 * etwa "01011100".
	 * 
	 * @return Stringrepraesentation der Bits der Menge
	 */
	public String bits() {
		String bitString = "";
		int j = 0;
		int compare;
		while(j < storage.length-1){
			compare = 1;
			for(int i = 0; i < 32; i++){
				bitString += (compare == (storage[j] & compare)? 1 : 0);
                	compare <<= 1;
			}
			j++;
		}
		compare = 1;
		for(int i = 0; i < Kapazitaet % BitsPerWord; i++){
				bitString += (compare == (storage[j] & compare)? 1 : 0);
                	compare <<= 1;
		}

		return bitString;
	}

	/**
	 * Ermittelt die Stringrepraesentation dieser Menge, etwa "{1, 3, 4, 6}".
	 * 
	 * @return Stringrepraesentation der Menge
	 */
	@Override
	public String toString() {
		String s = "{";
	    	for(int j = 0; j < storage.length; j++){
			int compare = 1;
			for(int i = 0; i < 32; i++){
				s += (compare == (storage[j] & compare)? i + (j * 32) + "," : "");
                compare <<= 1;
			}
		}
		if(s.length() > 1){
        		s = s.substring(0, (s.length()-1));}
		return s + "}";
	}

	/**
	 * Erzeugt einen Iterator, mit dem ueber die Menge iteriert werden kann:
	 * <br>
	 * <code>
	 * <br>for (IntSet.Iterator it = menge.iterator(); it.hasNext(); )
	 * <br>         { ... it.next() ... }
	 * </code>
	 * 
	 * @return ein Iterator auf diese Menge
	 */
	@Override
	public Iterator iterator() {
		return new Iterator(this);
	}

	/**
	 * IntSet Mengen-Iterator
	 */
	public class Iterator implements java.util.Iterator<Integer> {
		private IntSet s;
		private int position;

		/**
		 * Erzeugt einen Iterator ueber <code>s</code>.
		 * 
		 * @param s die Menge, ueber die iteriert werden soll
		 */
		public Iterator(IntSet s) {
			this.s = s;
			position = 0;
		}

		/**
		 * Ermittelt, ob noch weitere Elemente in der Menge existieren.
		 */
		@Override
		public boolean hasNext() {
			for(int i = 1 + position; i < s.capacity()-1; i++){
				if(s.contains(i)){
					return true;}}
			return false;
		}

		/**
		 * Gibt das naechste Element zurueck und setzt den Iterator weiter.
		 * 
		 * @return das naechste Element
		 */
		@Override
		public Integer next() {
			while(position < s.capacity()-1){
				position++;
				if(s.contains(position)){
					return position;};
			}
			return -1;
		}
	}
}
