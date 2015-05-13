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
public class CruiserTest {
	
	private Cruiser ship;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ship = new Cruiser(0, 0, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ship = null;
	}

	/**
	 * Test method for {@link com.sinkanic.ships.Cruiser#Cruiser(int, int, boolean)}.
	 */
	@Test
	public final void testCruiser() {
		assertTrue(ship.getShipSize() == 3);
		assertEquals("I'm a Cruiser bro !", ship.getIdentity());
	}

}
