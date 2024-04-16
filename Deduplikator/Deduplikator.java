public class Deduplikator{

	public static void main(String[] args) {
		//Schreibe alle Argumente in einen Array
		double array [] = new double[args.length];
		for(int i = args.length -1; i>= 0; i--){ 
		array[i] = Double.parseDouble(args[i]);
		}

		//Gebe jede jede Zahl des Arrays aus, falls diese nicht schon vorher ausgegeben wurde...
		for(int i = 0; i < array.length; i++){
			boolean first = true;
			//...falls die Zahl vorher schon ausgegeben wurde wird first auf false gesetzt
			for(int j = i-1; j >= 0; j--){
				if((array[i] == array[j])){first = false;}
			}
			if(first){System.out.println(array[i]);}

		}

	}
}