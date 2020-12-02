package main;

import clase.Erou;
import clase.Jucator;
import clase.Monstru;

public class Main {
	
	public static boolean aFolositScutulFermecat =false;
    public static int generateRandomNumber(double minim, double maxim) {
    	return (int) ((Math.random()  * (maxim - minim) + minim));
    }
    public static void afisareDamage(boolean aAtacatEroul, int damage) {
    	if(aAtacatEroul == true) {
			System.out.println("Daunele au fost: " + damage + " pentru bestie. A atacat eroul prima data!");
		}else {
			System.out.println("Daunele au fost: " + damage + " pentru erou. A atacat bestia prima data!");
			
		}
    }
    public static boolean incepeRunda(Jucator jucator1, Jucator jucator2,boolean aAtacatEroul, int randomNumber) {
   	int damage = 0;
   	if(jucator1.getViteza() > jucator2.getViteza()) {
		  damage = jucator1.ataca(jucator2);
		if(jucator1 instanceof Erou) {
			aAtacatEroul = true;
		}else {
			aAtacatEroul = false;
		}
	}else if(jucator1.getViteza() < jucator2.getViteza()) {
		damage = jucator2.ataca(jucator1);
		    if(jucator2 instanceof Erou) {
			  aAtacatEroul = true;
		    }else {
			  aAtacatEroul = false;
		    }
	}else if(jucator1.getViteza() == jucator2.getViteza()) {
		if(jucator1.getNoroc() > jucator2.getNoroc()) {
			damage = jucator1.ataca(jucator2);
			if(jucator1 instanceof Erou) {
  			aAtacatEroul = true;
  		    }else {
  			aAtacatEroul = false;
  		    }
		}else if(jucator1.getNoroc() < jucator2.getNoroc()) {
			damage = jucator2.ataca(jucator1);
			if(jucator2 instanceof Erou) {
  			aAtacatEroul = true;
  		    }else {
  			aAtacatEroul = false;
  		    }
		}
	}
	if(randomNumber % 2 == 0){
	 int viata = 0;
	 if(jucator2 instanceof Erou) {
		aFolositScutulFermecat = ((Erou) jucator2).activeazaPuteri(jucator1, aAtacatEroul, aFolositScutulFermecat);
  	   if(aFolositScutulFermecat == true) {
  		   viata = jucator2.getViata() + damage;
  	       jucator2.setViata(viata);
	   }
  	 }else if(jucator1 instanceof Erou) {
  		aFolositScutulFermecat = ((Erou) jucator1).activeazaPuteri(jucator2, aAtacatEroul, aFolositScutulFermecat);
      	if(aFolositScutulFermecat == true) {
      		viata = jucator1.getViata() + damage;
      	    jucator1.setViata(viata);
  		}
  	 }
	}
    afisareDamage(aAtacatEroul, damage);
   	return aAtacatEroul;
    }
	public static void main(String[] args) {
		Jucator carl = new Erou(60,70,80,90,100);
		Jucator bestie = new Monstru(50, 60, 70, 80, 90);
		boolean aAtacatEroul = false;
		int damage = 0;
		int contor = 1;
		while(contor  <= 20 && carl.getViata() > 0  && bestie.getViata() > 0) {
			System.out.println("In cadrul rundei cu numarul " + contor + " s-au intamplat urmatoarele: ");
			int randomNumber = generateRandomNumber(10, 20);
			carl.setViata(generateRandomNumber(65, 95));
			carl.setPutere(generateRandomNumber(60, 70));
			carl.setAparare(generateRandomNumber(40, 50));
			carl.setViteza(generateRandomNumber(40, 50));
			carl.setNoroc(generateRandomNumber(10, 30));

			bestie.setViata(generateRandomNumber(55, 80));
			bestie.setPutere(generateRandomNumber(50, 80));
			bestie.setAparare(generateRandomNumber(35, 55));
			bestie.setViteza(generateRandomNumber(40, 60));
			bestie.setNoroc(generateRandomNumber(25, 40));
			aAtacatEroul = incepeRunda(carl, bestie, aAtacatEroul,randomNumber);
			if(aAtacatEroul == true) {
					 damage = bestie.ataca(carl);
					 aAtacatEroul = false;
						System.out.println("Daunele au fost: "+ damage +" pentru erou. A atacat bestia ultima data!");
			}else if(aAtacatEroul == false) {
					damage = carl.ataca(bestie);
					aAtacatEroul = true;
					System.out.println("Daunele au fost: "+ damage +" pentru bestie. A atacat eroul ultima data!");
			}
			if(randomNumber%2 == 0) {
			   if(carl instanceof Erou) {
		        	  aFolositScutulFermecat = ((Erou) carl).activeazaPuteri(bestie, aAtacatEroul, aFolositScutulFermecat);
		        	  if(aFolositScutulFermecat == true) {
		        	     carl.setViata(carl.getViata()+damage);
		        	  }
			   }
		    }
			System.out.println("Eroul are urmatoarele caracteristici: " + carl.toString());
			System.out.println("Bestia are urmatoarele caracteristici: " + bestie.toString()+ "\n");
			if(carl.getViata() <= 0 && bestie.getViata() > 0 ) {
					System.out.println("A castigat bestia!" + "\n");
			}else if(bestie.getViata() <= 0 && carl.getViata() > 0) {
					System.out.println("A castigat eroul!" + "\n");
			}else if(bestie.getViata() < 0 && carl.getViata() < 0) {
					System.out.println("Au murit amandoi!" + "\n");
			}
			contor++;
			}
	}
}
