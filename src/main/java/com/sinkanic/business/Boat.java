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
	
	// Constructeurs
	/**
	 * Constructeur
	 * @param <Cell> la première position
	 */
	public Boat(Cell premierePosition) {
		this(false, 1, premierePosition);
	}
	
	/**
	 * Constructeur
	 * @param boolean est vertical
	 * @param taille nombre de cellule
	 * @param <Cell> la première position
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
	 * @see Player.checkGuess()
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
	 * @return ArrayList<Cellule> la liste des positions
	 */
	public ArrayList<Cell> getPositions() {
		return listeCellule;
	}
	
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
	 * @return boolean détermine si l'ennemi est détruit ou non.
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
	
	/**
	 * @param <String> typeBateau
	 * @return <Integer> la taille du bateau
	 */
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

	/**
	 * @return the nbCellule
	 */
	public int getTaille() {
		return nbCellule;
	}
}
