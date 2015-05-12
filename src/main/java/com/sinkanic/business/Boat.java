package com.sinkanic.business;

import java.util.ArrayList;

/**
 * @author humanbooster
 *
 */
public class Boat {
	
	// Attributs
	public static final String MISSED = "Missed!";
	public static final String HIT = "Hit!";
	public static final String DESTROYED = "Destroyed!";
	public static final String PORTE_AVION = "Porte-avion";
	public static final String CROISEUR = "Croiseur";
	public static final String TORPILLEUR = "Torpilleur";
	public static final String PLANCHE_A_VOILE = "Planche à voile";
	private boolean isVertical;
	private int nbCellule;
	/**
	 * Détermine les positions du bateau.
	 */
	private ArrayList<Cell> listeCellule;
	
	/**
	 * Constructor
	 * @param vertical boolean true if the Boat is vertical
	 * @param taille number of Cells
	 * @param premierePosition {@link com.sinkanic.business.Cell} the first Cell
	 */
	public Boat(boolean vertical, int taille, Cell premierePosition) {
		isVertical = vertical;
		nbCellule = taille;
		listeCellule = new ArrayList<Cell>();
		listeCellule.add(premierePosition);
		for (int i = 1; i < nbCellule; i++) {
			int positionX = 0;
			int positionY = 0;
			if (isVertical) {
				positionX = premierePosition.getHorizontalPosition();
				positionY = premierePosition.getVerticalPosition() + i;
			} else {
				positionX = premierePosition.getHorizontalPosition() + i;
				positionY = premierePosition.getVerticalPosition();
			}
			listeCellule.add(new Cell(positionX, positionY));
		}
	}

	// Méthodes
	/**
	 * @param testX int the horizontal position to check
	 * @param testY int the vertical position to check
	 * @return a String the result 
	 * @see com.sinkanic.business.Boat#MISSED
	 * @see com.sinkanic.business.Boat#HIT
	 * @see com.sinkanic.business.Boat#DESTROYED
	 */
	public String checkGuess(int testX, int testY) {
		String resultat = MISSED;
		try {
			if (isHit(testX, testY)) {
				if (isSunk()) {
					resultat = DESTROYED;
				} else {
					resultat = HIT;
				}
			}
		} catch (NullPointerException exception) {
			System.out.println("Paramètre null " + exception.getMessage());
			resultat = "Paramètre null!!";
		}
		return resultat;
	}
	
	/**
	 * @return a list of positions {@link com.sinkanic.business.Cell}
	 */
	public ArrayList<Cell> getPositions() {
		return listeCellule;
	}
	
	/**
	 * @param testX int the horizontal position to test
	 * @param testY int the vertical position to test
	 * @return true if the boat is hit on position (X, Y).
	 */
	protected boolean isHit(int testX, int testY) {
		boolean result = false;
		for (Cell testCell : listeCellule) {
			if (testCell.isEquals(testX, testY)) {
				result = true;
				testCell.setHit();
				break;
			}
		}
		return result;
	}

	/**
	 * @return true if the boat is sunk.
	 */
	protected boolean isSunk() {
		boolean result = true;
		for (Cell cellule : listeCellule) {
			if (!cellule.isHit()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public String affichePositions() {
		StringBuilder resultat = new StringBuilder();
		int compteur = 0;
		resultat.append("[");
		for (Cell cell : getPositions()) {
			compteur++;
			resultat.append("(" + cell.getHorizontalPosition() + "," + cell.getVerticalPosition() + ")");
			if (compteur < getPositions().size()) {
				resultat.append(",");
			}
		}
		resultat.append("]");
		return resultat.toString();
	}
	
	public static int getTailleBateau(String typeBateau) {
		int taille = 0;
		switch (typeBateau) {
		case PORTE_AVION:
			taille = 5;
			break;
		case CROISEUR:
			taille = 4;
			break;
		case TORPILLEUR:
			taille = 3;
			break;
		case PLANCHE_A_VOILE:
			taille = 1;
			break;
		}
		return taille;
	}

	public int getTaille() {
		return nbCellule;
	}
}
