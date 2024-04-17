public class Brot extends Speise 
{
	public Brot(int Nummer, int Menge) {
		super(((Nummer == 0)? "Weißbrot" : (Nummer == 1)? "Schwarzbrot" : (Nummer == 2)? "Mischbrot" : "Spezialbrot"), Menge);
	}

	public boolean essen(){
		return this.essen(50);
	}


}