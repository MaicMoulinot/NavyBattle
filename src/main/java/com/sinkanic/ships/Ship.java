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
	 * 	Base ship
	 */
	public Ship(int size, int gridX, int gridY, boolean vertical) {
		// Set ship orientation
		isVertical = vertical;

	}

}
