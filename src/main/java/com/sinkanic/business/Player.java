package com.sinkanic.business;

import java.util.ArrayList;
import java.util.Random;

import com.sinkanic.ships.AircraftCarrier;
import com.sinkanic.ships.Battleship;
import com.sinkanic.ships.PatrolBoat;
import com.sinkanic.ships.Ship;
import com.sinkanic.ships.Submarine;

/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public abstract class Player {

	protected ArrayList<Ship> listBoats;

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
		listBoats = new ArrayList<Ship>();
		nbTries = 0;
	}

	public abstract Cell getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical);
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
		Ship bateau = null;
		


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
			
			// instantiate proper ship type
			switch (tailleBateau) {
			case 5:
				bateau = new AircraftCarrier(X, Y, isVertical);
				break;
			case 4:
				bateau = new Battleship(X, Y, isVertical);
				break;
			case 3:
				bateau = new Submarine(X, Y, isVertical);
				break;
			case 2:
				bateau = new PatrolBoat(X, Y, isVertical);
				break;
				
			default:
				break;
			}
		} while (!isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical));
		listBoats.add(bateau);
	}

	/**
	 * @param testX int the horizontal position to check
	 * @param testY int the vertical position to check
	 * @return a String the result 
	 * @see com.sinkanic.business.Ship.MISSED
	 * @see com.sinkanic.business.Ship.HIT
	 * @see com.sinkanic.business.Ship.DESTROYED
	 */
	public String checkGuess(int testX, int testY) {
		String resultat = Ship.MISSED;
		for (Ship bateau : getFlotte()) {
			resultat = bateau.checkGuess(testX, testY);
			if (!resultat.matches(Ship.MISSED)) {
				break;
			}
		}
		return resultat;
	}
	
	public ArrayList<Cell> getAllPositions() {
		ArrayList<Cell> listeCellules = new ArrayList<Cell>();
		for (Ship bateau : getFlotte()) {
			for (Cell cellule : bateau.getPositions()) {
				listeCellules.add(cellule);
			}
		}
		return listeCellules;
	}

	public ArrayList<Ship> getFlotte() {
		return listBoats;
	}
	
	public ArrayList<String> afficheBoats() {
		ArrayList<String> resultat = new ArrayList<String>();
		for (Ship bateau : getFlotte()) {
			resultat.add(bateau.displayPositions());
		}
		return resultat;
	}

	private boolean isBoatIntegre(Ship nouveauBateau, int tailleGrilleHorizontal, int tailleGrilleVertical) {
		boolean resultat = true;
		for (Cell testCellule : nouveauBateau.getPositions()) {
			if (testCellule.getHorizontalPosition() >= tailleGrilleHorizontal || testCellule.getVerticalPosition() >= tailleGrilleVertical) {
				resultat = false;
				break;
			} else {
				for (Cell cellule : getAllPositions()) {
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
		for (Ship bateau : getFlotte()) {
			if (!bateau.isSunk()) {
				resultat = false;
				break;
			}
		}
		return resultat;
	}
	public boolean addBoatX(Ship shipToAdd, int gridCols, int gridRows, boolean isVertical, int x, int y) {
		if (!isBoatIntegre(shipToAdd, gridRows, gridCols))
			return false;
		listBoats.add(shipToAdd);
		return true;
	}
	
	public Ship addBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical, int firstCellX, int firstCellY) {
		// instantiate proper ship type
		Ship bateau = null;
		switch (tailleBateau) {
		case 5:
			bateau = new AircraftCarrier(firstCellX, firstCellY, isVertical);
			break;
		case 4:
			bateau = new Battleship(firstCellX, firstCellY, isVertical);
			break;
		case 3:
			bateau = new Submarine(firstCellX, firstCellY, isVertical);
			break;
		case 2:
			bateau = new PatrolBoat(firstCellX, firstCellY, isVertical);
			break;
			
		default:
			break;
		}
		if (isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
			listBoats.add(bateau);
		} else {
			bateau = null;
		}
		return bateau;
	}
	
	public Ship tryBoat(int tailleGrilleHorizontal, int tailleGrilleVertical, int tailleBateau, boolean isVertical, int firstCellX, int firstCellY) {
		Ship bateau = null;
		// instantiate proper ship type
		switch (tailleBateau) {
		case 5:
			bateau = new AircraftCarrier(firstCellX, firstCellY, isVertical);
			break;
		case 4:
			bateau = new Battleship(firstCellX, firstCellY, isVertical);
			break;
		case 3:
			bateau = new Submarine(firstCellX, firstCellY, isVertical);
			break;
		case 2:
			bateau = new PatrolBoat(firstCellX, firstCellY, isVertical);
			break;
			
		default:
			break;
		}
		if (!isBoatIntegre(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
			bateau = null;
		}
		return bateau;
	}

}
