/**
 * 
 */
package com.sinkanic.ships;

/**
 * @author matthieumaunier
 *
 */

public class AircraftCarrier extends Ship {

	/**
	 * @param x int the horizontal position of the first cell
	 * @param y int the vertical position of the first cell
	 * @param vertical boolean true if the boat is vertical
	 * @see com.sinkanic.ships.Ship
	 */
	public AircraftCarrier(int x, int y, boolean vertical) {
		super(5, x, y, vertical);
		
		shipIdentity = "I'm a big bad Aircraft Carrier";
	}

}
