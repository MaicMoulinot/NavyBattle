/**
 * 
 */
package com.sinkanic.ships;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author humanbooster
 *
 */
public class PatrolBoatTest {
	
	private PatrolBoat ship;
	
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
	 * Test method for {@link com.sinkanic.ships.PatrolBoat#PatrolBoat(int, int, boolean)}.
	 */
	@Test
	public final void testPatrolBoat() {
		assertTrue(ship.getShipSize() == 2);
		assertEquals("O hai, I'm the naval Fast & Furious. aka Patrol Boat", ship.getIdentity());
	}

}
