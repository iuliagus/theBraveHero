package clase;

public class Monstru extends Jucator{

	public Monstru(int viata, int putere, int aparare, int viteza, int noroc) {
		super(viata, putere, aparare, viteza, noroc);
	}
	@Override
	public String toString() {
		return "Monstrul are urmatoarele caracteristi: " +super.toString();
	}
	
}
