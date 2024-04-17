public class Speise extends Lebensmittel 
{
	public Speise(String name, int menge) {
		super(name, menge);
	}

	public String getMenge(){
		return (this.menge + " g");
	}

	public boolean essen(int Menge){
		if(this.menge < Menge){
			this.menge = 0;
			return false;
		}
		this.menge -= Menge;
		return true;
	}


}