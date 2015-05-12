/**
 * 
 */
package com.sinkanic.ships;

/**
 * @author matthieumaunier
 *
 */
public class Battleship extends Ship {

	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param direction boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public Battleship(int x, int y, boolean vertical) {
		super(4, x, y, vertical);
	}

}
