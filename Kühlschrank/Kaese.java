public class Kaese extends Speise 
{
	public Kaese(String Name, int Menge) {
		super(Name, Menge);
	}

	public boolean essen(){
		return this.essen(20);
	}


}