package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public abstract class Player {

	protected ArrayList<Boat> listBoats;

	/**
	 * Nombre de fois où le joueur a tiré.
	 */
	protected int nbTries;

	/**
	 * @return la prochaine tentative du joueur
	 */	
	public int getNbEssais() {
		return nbTries;
	}

	public Player() {
		listBoats = new ArrayList<Boat>();
		nbTries = 0;
	}

	/**
	 * @return la prochaine tentative du joueur
	 */
	public abstract Cellule getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical);
	//	1ère solution : renvoit les valeurs de 0 à 6 dans l'ordre
	//	2ème solution : renvoit des tirages aléatoires
	//	3ème solution : renvoit le choix par bouton

	public void incrementNbEssais() {
		nbTries++;
	}

	public void createRandomBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau) {
		Random randomGenerator = new Random();
		boolean isVertical = (randomGenerator.nextInt(2) == 0);
		createRandomBoat(tailleGrilleHorizontal, tailleGrilleVertical, tailleBateau, isVertical);
	}

	public void createRandomBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical) {
		int X = 0;
		int Y = 0;
		Random randomGenerator = new Random();
		Boat bateau = null;
		//TODO attention aux marges
		do {
			if(isVertical) {
				X = randomGenerator.nextInt(tailleGrilleHorizontal);
				if (tailleGrilleVertical > tailleBateau) {
					Y = randomGenerator.nextInt(tailleGrilleVertical - tailleBateau);
				}
			} else {
				Y = randomGenerator.nextInt(tailleGrilleVertical);
				if (tailleGrilleHorizontal > tailleBateau) {
					X = randomGenerator.nextInt(tailleGrilleHorizontal - tailleBateau);
				}
			}
			bateau = new Boat(isVertical, tailleBateau, new Cellule(X, Y));
		} while (!isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical));
		listBoats.add(bateau);
	}

	/**
	 * @see Boat.checkGuess()
	 */
	public String checkGuess(int testX, int testY) {
		String resultat = Boat.MISSED;
		for (Boat bateau : getFlotte()) {
			resultat = bateau.checkGuess(testX, testY);
			if (!resultat.matches(Boat.MISSED)) {
				break;
			}
		}
		return resultat;
	}

	/**
	 * @return ArrayList<Cellule> la liste de toutes les cellules de la flotte du joueur.
	 */
	public ArrayList<Cellule> getAllPositions() {
		ArrayList<Cellule> listeCellules = new ArrayList<Cellule>();
		for (Boat bateau : getFlotte()) {
			for (Cellule cellule : bateau.getPositions()) {
				listeCellules.add(cellule);
			}
		}
		return listeCellules;
	}

	public ArrayList<Boat> getFlotte() {
		return listBoats;
	}
	
	public ArrayList<String> afficheBoats() {
		ArrayList<String> resultat = new ArrayList<String>();
		for (Boat bateau : getFlotte()) {
			resultat.add(bateau.affichePositions());
		}
		return resultat;
	}

	private boolean isBoatIntegre(Boat nouveauBateau, int tailleGrilleHorizontal, int tailleGrilleVertical) {
		boolean resultat = true;
		for (Cellule testCellule : nouveauBateau.getPositions()) {
			if (testCellule.getPositionHorizontal() >= tailleGrilleHorizontal || testCellule.getPositionVertical() >= tailleGrilleVertical) {
				resultat = false;
				break;
			} else {
				for (Cellule cellule : getAllPositions()) {
					if (testCellule.isEquals(cellule)) {
						resultat = false;
						break;
					}
				}
			}
		}
		return resultat;
	}
	
	public boolean isDead() {
		boolean resultat = true;
		for (Boat bateau : getFlotte()) {
			if (!bateau.isDestroyed()) {
				resultat = false;
				break;
			}
		}
		return resultat;
	}

	public Boat addBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical, int firstCellX, int firstCellY) {
		Boat bateau = new Boat(isVertical, tailleBateau, new Cellule(firstCellX, firstCellY));
		if (isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
			listBoats.add(bateau);
		} else {
			bateau = null;
		}
		return bateau;
	}
	
	public Boat tryBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical, int firstCellX, int firstCellY) {
		Boat bateau = new Boat(isVertical, tailleBateau, new Cellule(firstCellX, firstCellY));
		if (!isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
			bateau = null;
		}
		return bateau;
	}

}
