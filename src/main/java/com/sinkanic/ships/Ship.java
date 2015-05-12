/**
 * 
 */
package com.sinkanic.ships;

import java.util.ArrayList;

import com.sinkanic.business.Cell;

/**
 * @author matthieumaunier
 *
 */
public abstract class Ship {

	public static final String MISSED = "Missed!";
	public static final String DESTROYED = "Destroyed!";
	public static final String HIT = "Hit!";

	protected ArrayList<Cell>	shipCells;
	protected boolean			isVertical;
	protected String			shipIdentity;

	/**

	 * Ship Constructor
	 * @param size Ship size in <Cell> determined by other ship
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param direction boolean true if the boat is vertical

	 * @param size int the number of {@link com.sinkanic.business.Cell}
	 * @param gridX int the horizontal position of the first cell
	 * @param gridY int the vertical position of the first cell
	 * @param vertical boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship

	 */
	public Ship(int size, int gridX, int gridY, boolean vertical) {
		// Set ship orientation
		isVertical = vertical;
		shipCells = new ArrayList<Cell>();

		// Ship has no identity. :(
		shipIdentity = "Basic Ship";

		int posX = 0;
		int posY = 0;
		// Create ship cells
		for (int i = 0; i < size; i++) {
			if (isVertical) {
				posX = gridX;
				posY = gridY + i;
			} else {
				posX = gridX + i;
				posY = gridY;
			}
			shipCells.add(new Cell(posX, posY));
		}
	}
	
	public String getIdentity() {
		return shipIdentity;
	}
	/**
	 * @return ArrayList<Cellule> ship positions list
	 */
	public ArrayList<Cell> getPositions() {
		return shipCells;
	}
	
	public boolean isHit(int testX, int testY) {
		boolean result = false;
		for (Cell testCell : shipCells) {
			if (testCell.isEquals(testX, testY)) {
				result = true;
				testCell.setHit();
				break;
			}
		}
		return result;
	}	

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
	 * @return boolean tells if enemy is destroyed.
	 */
	public boolean isSunk() {
		boolean result = true;
		for (Cell cellule : shipCells) {
			if (!cellule.isHit()) {
				result = false;
				break;
			}
		}
		return result;
	}

	public String displayCheatTextEnemyPositions() {
		StringBuilder sb = new StringBuilder();
		int compteur = 0;
		sb.append("[");
		for (Cell cell : getPositions()) {
			compteur++;
			sb.append("(" + cell.getHorizontalPosition() + "," + cell.getVerticalPosition() + ")");
			if (compteur < getPositions().size()) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();		
	}

	
	public int getShipSize()
	{		
		return (shipCells.size());
	}
}
