package com.sinkanic.business;

import java.util.ArrayList;

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
public class Player {

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

	public void incrementNbEssais() {
		nbTries++;
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

	protected boolean isBoatAddable(Ship nouveauBateau, int tailleGrilleHorizontal, int tailleGrilleVertical) {
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
		if (!isBoatAddable(shipToAdd, gridRows, gridCols))
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
		if (isBoatAddable(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
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
		if (!isBoatAddable(bateau, tailleGrilleHorizontal, tailleGrilleVertical)) {
			bateau = null;
		}
		return bateau;
	}
}
