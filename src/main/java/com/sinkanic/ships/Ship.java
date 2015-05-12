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
	 * @param size int the number of {@link com.sinkanic.business.Cell}
	 * @param gridX int the horizontal position of the first cell
	 * @param gridY int the vertical position of the first cell
	 * @param vertical boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public Ship(int size, int gridX, int gridY, boolean vertical) {
		// Set ship orientation bool
		isVertical = vertical;
	}

}
