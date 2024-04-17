public class Roman {
	static String roman(int n) {
		if(n >= 1000){return "M" + roman(n-1000);}
		if(n >= 900){return "C" + roman(n+100);}
		if(n >= 500){return "D" + roman(n-500);}
		if(n >= 400){return "C" + roman(n+100);}
		if(n >= 100){return "C" + roman(n-100);}
		if(n >= 90){return "X" + roman(n+10);}
		if(n >= 50){return "L" + roman(n-50);}
		if(n >= 40){return "X" + roman(n+10);}
		if(n >= 10){return "X" + roman(n-10);}
		if(n >= 9){return "I" + roman(n+1);}
		if(n >= 5){return "V" + roman(n-5);}
		if(n >= 4){return "I" + roman(n+1);}
		if(n >= 1){return "I" + roman(n-1);}
		return "";


	}

	public static void main(String[] args) {
		// Behandlung fehlender oder falscher Eingabeparameter
		if(args.length != 1){
			System.out.print("Bitte eine Zahl als Parameter angeben.\n");
			System.exit(-1);
			}
		int N = Integer.parseInt(args[0]);
		if(1 > N || N > 5000){
			System.out.print("Die Zahl muss zwischen 1 und 5000 liegen.\n");
			System.exit(-1);
		}
		assert(1 <= N && N <= 5000);
		System.out.println(roman(N));
	}
}