public abstract class Lebensmittel 
{
	private final String name;
	int menge; // in Milliliter bzw. Gramm

	public Lebensmittel(String name, int menge) {
		this.name = name;
		if(menge < 0){
			System.out.println("Menge von " + name +" darf nicht kleiner als 0 sein.");
			System.exit(-1);
		}
		this.menge = menge;
	}

	public abstract String getMenge();

	public boolean essen(){
		return false;
	}

	public boolean trinken(){
		return false;
	}


	public String toString() {
		return (this.getClass().getName() + " (" + this.name + ", " + getMenge() + ")");
	}
}