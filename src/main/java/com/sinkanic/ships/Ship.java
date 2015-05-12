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

	private ArrayList<Cell>	shipCells;
	private boolean			isVertical;
	private String			identity;

	/**
	 * Ship Constructor
	 * @param size Ship size in <Cell> determined by other ship
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param direction boolean true if the boat is vertical
	 */
	public Ship(int size, int gridX, int gridY, boolean vertical) {
		// Set ship orientation
		isVertical = vertical;
		shipCells = new ArrayList<Cell>();

		// Ship has no identity. :(
		identity = "Basic Ship";

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
}
