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
	 * @param size
	 * @param x
	 * @param y
	 * @param direction
	 */
	public PatrolBoat(int x, int y, boolean vertical) {
		super(2, x, y, vertical);
	}
}
