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

	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param direction boolean true if the boat is vertical
	 */
	public Ship(int size, int gridX, int gridY, boolean vertical) {
		// Set ship orientation bool
		isVertical = vertical;
	}

}
