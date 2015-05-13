/**
 * 
 */
package com.sinkanic.ships;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinkanic.business.Cell;
import com.sinkanic.ships.PatrolBoat;
import com.sinkanic.ships.Ship;

/**
 * @author humanbooster
 *
 */
public class ShipTest {
	
	private Ship boat;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		boat = new PatrolBoat(0, 0, false); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#Boat(boolean, int, com.sinkanic.business.Cell)}.
	 */
	@Test
	public final void testBoatBooleanIntCellule() {
		assertFalse("test constructor Boat", boat.getPositions().isEmpty());
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#checkGuess(int, int)}.
	 */
	@Test
	public final void testCheckGuess() {
		assertEquals(boat.checkGuess(0, 0), Ship.HIT);
		assertNotEquals(boat.checkGuess(9, 9), Ship.HIT);
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#isHit(int, int)}.
	 */
	@Test
	public final void testIsTouched() {
		boat.checkGuess(0, 0);
		assertTrue(boat.isHit(0, 0));
	}

	/**
	 * Test method for {@link com.sinkanic.business.Ship#isSunk()}.
	 */
	@Test
	public final void testIsDestroyed() {
		boat.checkGuess(0, 0);
		boat.checkGuess(1, 0);
		assertTrue(boat.isSunk());
	}

}
