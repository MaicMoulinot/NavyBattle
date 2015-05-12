/**
 * 
 */
package com.sinkanic.ships;

/**
 * @author matthieumaunier
 *
 */
public class Submarine extends Ship {
	
	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param vertical boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public Submarine(int x, int y, boolean vertical) {
		super(3, x, y, vertical);
		
		shipIdentity = "I'm a sneaky sneaky Submarine";
	}

}
