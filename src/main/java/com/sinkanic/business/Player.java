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
	
	protected String name;

	protected ArrayList<Ship> fleet;

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

	public Player(String namePlayer) {
		name = namePlayer;
		fleet = new ArrayList<Ship>();
		nbTries = 0;
	}

	public void incrementNbEssais() {
		nbTries++;
	}

	/**
	 * @param testX int the horizontal position to check
	 * @param testY int the vertical position to check
	 * @return a String the result belonging to one of these :
	 * {@link com.sinkanic.ships.Ship#MISSED},
	 * {@link com.sinkanic.ships.Ship#HIT},
	 * {@link com.sinkanic.ships.Ship#DESTROYED}.
	 * @see com.sinkanic.ships.Ship#checkGuess(int, int)
	 */
	public String checkGuess(int testX, int testY) {
		String resultat = Ship.MISSED;
		for (Ship bateau : getFleet()) {
			resultat = bateau.checkGuess(testX, testY);
			if (!resultat.matches(Ship.MISSED)) {
				break;
			}
		}
		return resultat;
	}
	
	public ArrayList<Cell> getAllPositions() {
		ArrayList<Cell> listeCellules = new ArrayList<Cell>();
		for (Ship bateau : getFleet()) {
			for (Cell cellule : bateau.getPositions()) {
				listeCellules.add(cellule);
			}
		}
		return listeCellules;
	}

	public ArrayList<Ship> getFleet() {
		return fleet;
	}
	
	public ArrayList<String> afficheBoats() {
		ArrayList<String> resultat = new ArrayList<String>();
		for (Ship bateau : getFleet()) {
			resultat.add(bateau.displayCheatTextEnemyPositions());
		}
		return resultat;
	}

	protected boolean isBoatAddable(Ship nouveauBateau, int tailleGrilleHorizontal, int tailleGrilleVertical) {
		boolean resultat = true;
		for (Cell testCellule : nouveauBateau.getPositions()) {
			if (testCellule.x >= tailleGrilleHorizontal || testCellule.y >= tailleGrilleVertical) {
				resultat = false;
				break;
			} else {
				for (Cell cellule : getAllPositions()) {
					if (testCellule.isSamePosition(cellule)) {
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
		for (Ship bateau : getFleet()) {
			if (!bateau.isSunk()) {
				resultat = false;
				break;
			}
		}
		return resultat;
	}
	public boolean addBoat(Ship shipToAdd, int gridCols, int gridRows) {
		if (!isBoatAddable(shipToAdd, gridRows, gridCols))
			return false;
		fleet.add(shipToAdd);
		return true;
	}

	@Deprecated
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

	public String getName() { return name; }
	public void setName(String newName) { name = newName; }
}
