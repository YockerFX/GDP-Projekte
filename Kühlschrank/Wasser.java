public class Wasser extends Getraenk 
{
	public Wasser(String Name, int Menge) {
		super(Name, Menge);
	}

	public boolean trinken(){
		return this.trinken(200);
	}
}