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
public class BattleshipTest {
	
	private Battleship ship;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ship = new Battleship(0, 0, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ship = null;
	}

	/**
	 * Test method for {@link com.sinkanic.ships.Battleship#Battleship(int, int, boolean)}.
	 */
	@Test
	public final void testBattleship() {
		assertTrue(ship.getShipSize() == 4);
		assertEquals("I'm the sheriff in da hood. aka Battleship", ship.getIdentity());
	}

}
