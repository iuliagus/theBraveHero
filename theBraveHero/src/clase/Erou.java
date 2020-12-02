package clase;

import interfete.PutereErou;

public class Erou extends Jucator implements PutereErou{
	
	public Erou(int viata, int putere, int aparare, int viteza, int noroc) {
		super(viata, putere, aparare, viteza, noroc);
	}
	@Override
	public void activeazaScutulFermecat(Jucator bestie) {
		bestie.setViata(bestie.getViata()/2);
		bestie.setPutere(bestie.getPutere()/2);
		bestie.setAparare(bestie.getAparare()/2);
		bestie.setViteza(bestie.getViteza()/2);
		bestie.setNoroc(bestie.getNoroc()/2);
	}
	@Override
	public void activeazaFortaDragonului() {
		this.setPutere(2*this.getPutere());
	}
	@Override
	public boolean activeazaPuteri(Jucator adversar, boolean aAtacatEroul, boolean aFolositScutulFermecat) {
		if(this.getNoroc() == 10 && aAtacatEroul == true) {
    		this.activeazaFortaDragonului();
    	    System.out.println("Eroul a folosit forta dragonului.");
    	}else if(this.getNoroc() == 20 && aAtacatEroul == false) {
    		   this.activeazaScutulFermecat(adversar);
    		   System.out.println("Eroul a folosit scutul fermecat.");
    		   aFolositScutulFermecat = true;
    	      }else {
    		   aFolositScutulFermecat = false;
    	}
		return aFolositScutulFermecat;
	}
	@Override
	public String toString() {
		return "Erou are urmatoarele caracteristi: " + super.toString();
	}
}
