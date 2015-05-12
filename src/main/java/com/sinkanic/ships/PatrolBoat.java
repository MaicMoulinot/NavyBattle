/**
 * 
 */
package com.sinkanic.ships;

/**
 * @author matthieumaunier
 *
 */
public class PatrolBoat extends Ship {

	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param vertical boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public PatrolBoat(int x, int y, boolean vertical) {
		super(2, x, y, vertical);
	}
}
