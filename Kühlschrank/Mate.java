public class Mate extends Getraenk 
{
	public Mate(String Name) {
		super(Name, 500);
	}

	public boolean trinken(){
		return this.trinken(100);
	}
}