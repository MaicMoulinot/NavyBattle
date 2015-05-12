/**
 * 
 */
package com.sinkanic.ships;

/**
 * @author matthieumaunier
 *
 */
public class Cruiser extends Ship {

	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param direction boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public Cruiser(int x, int y, boolean vertical) {
		super(3, x, y, vertical);
	}

}
