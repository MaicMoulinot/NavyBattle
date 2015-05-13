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
public class AircraftCarrierTest {
	
	private AircraftCarrier ship;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ship = new AircraftCarrier(0, 0, false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ship = null;
	}

	/**
	 * Test method for {@link com.sinkanic.ships.AircraftCarrier#AircraftCarrier(int, int, boolean)}.
	 */
	@Test
	public final void testAircraftCarrier() {
		assertTrue(ship.getShipSize() == 5);
		assertEquals("I'm a big bad Aircraft Carrier", ship.getIdentity());
	}

}
