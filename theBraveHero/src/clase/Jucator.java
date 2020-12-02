package clase;

public class Jucator {
	
	private int viata;
	private int putere;
	private int aparare;
	private int viteza;
	private int noroc;
	public Jucator(int viata, int putere, int aparare, int viteza, int noroc) {
		super();
		this.viata = viata;
		this.putere = putere;
		this.aparare = aparare;
		this.viteza = viteza;
		if(noroc >= 0 && noroc <= 100) {
			this.noroc = noroc;
		}
	}
	public int getViata() {
		return viata;
	}
	public void setViata(int viata) {
		this.viata = viata;
	}
	public int getPutere() {
		return putere;
	}
	public void setPutere(int putere) {
		this.putere = putere;
	}
	public int getAparare() {
		return aparare;
	}
	public void setAparare(int aparare) {
		this.aparare = aparare;
	}
	public int getViteza() {
		return viteza;
	}
	public void setViteza(int viteza) {
		this.viteza = viteza; 
	}
	public int getNoroc() {
		return noroc;
	}
	public void setNoroc(int noroc) {
		if(noroc >= 0 && noroc <= 100) {
		this.noroc = noroc;
		}
	}
	@Override
	public String toString() {
		return "viata=" + viata + ", putere=" + putere + ", aparare=" + aparare + ", viteza=" + viteza
				+ ", noroc=" + noroc + "%";
	}
	public  int ataca(Jucator adversar) {
		int damage = this.putere - adversar.aparare;
		if(damage < 0) {
			damage = 0;
		}else if(damage > 100) {
			damage = 100;
		}
		int viataAdversar = adversar.getViata() - damage;
		adversar.setViata(viataAdversar);
		if(adversar.getViata()<0) {
			adversar.setViata(0);
		}
		return damage;
	}
}
