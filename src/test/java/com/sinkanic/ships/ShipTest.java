/**
 * 
 */
package com.sinkanic.ships;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author humanbooster
 *
 */
public class ShipTest {
	
	private Ship ship;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ship = new PatrolBoat(0, 0, false); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ship = null;
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#Boat(boolean, int, com.sinkanic.business.Cell)}.
	 */
	@Test
	public final void testShipBooleanIntCellule() {
		assertFalse("test constructor Boat", ship.getPositions().isEmpty());
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#checkGuess(int, int)}.
	 */
	@Test
	public final void testCheckGuess() {
		assertEquals(ship.checkGuess(0, 0), Ship.HIT);
		assertNotEquals(ship.checkGuess(9, 9), Ship.HIT);
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#isHit(int, int)}.
	 */
	@Test
	public final void testIsTouched() {
		ship.checkGuess(0, 0);
		assertTrue(ship.isHit(0, 0));
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#isSunk()}.
	 */
	@Test
	public final void testIsDestroyed() {
		ship.checkGuess(0, 0);
		ship.checkGuess(1, 0);
		assertTrue(ship.isSunk());
	}

}
