public class Getraenk extends Lebensmittel 
{
	public Getraenk(String name, int menge) {
		super(name, menge);
	}

	public String getMenge(){
		return (this.menge + " ml");
	}

	public boolean trinken(int Menge){
		if(this.menge < Menge){
			this.menge = 0;
			return false;
		}
		this.menge -= Menge;
		return true;
	}


}