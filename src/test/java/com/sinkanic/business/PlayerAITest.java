/**
 * 
 */
package com.sinkanic.business;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author humanbooster
 *
 */
public class PlayerAITest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sinkanic.business.PlayerAI#getRandomCell(int, int)}.
	 */
	@Test
	public final void testGetRandomCell() {
		PlayerAI ai = new PlayerAI();
		Cell cell = ai.getRandomCell(10, 10);
		assertTrue(cell.x < 10 && cell.y < 10);
	}

	/**
	 * Test method for {@link com.sinkanic.business.PlayerAI#createRandomBoat(int, int, int)}.
	 */
	@Test
	public final void testCreateRandomBoatIntIntInt() {
		PlayerAI ai = new PlayerAI();
		int initialSize = ai.getFleet().size();
		ai.createRandomBoat(10, 10, 3);
		assertTrue(ai.getFleet().size() == initialSize + 1);
	}

	/**
	 * Test method for {@link com.sinkanic.business.PlayerAI#createRandomBoat(int, int, int, boolean)}.
	 */
	@Test
	public final void testCreateRandomBoatIntIntIntBoolean() {
		PlayerAI ai = new PlayerAI();
		int initialSize = ai.getFleet().size();
		ai.createRandomBoat(10, 10, 3, false);
		assertTrue(ai.getFleet().size() == initialSize + 1);
	}

}
