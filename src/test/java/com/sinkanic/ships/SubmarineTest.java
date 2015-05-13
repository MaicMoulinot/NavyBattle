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
public class SubmarineTest {
	
	private Submarine ship;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ship = new Submarine(0, 0, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ship = null;
	}

	/**
	 * Test method for {@link com.sinkanic.ships.Submarine#Submarine(int, int, boolean)}.
	 */
	@Test
	public final void testSubmarine() {
		assertTrue(ship.getShipSize() == 3);
		assertEquals("I'm a sneaky sneaky Submarine", ship.getIdentity());
	}

}
