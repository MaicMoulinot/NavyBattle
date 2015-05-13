/**
 * 
 */
package com.sinkanic.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sinkanic.ships.Ship;
import com.sinkanic.ships.Submarine;

/**
 * @author humanbooster
 *
 */
public class PlayerTest {
	
	/**
	 * Test method for {@link com.sinkanic.business.Player#checkGuess(int, int)}.
	 */
	@Test
	public final void testCheckGuess() {
		Ship littleShip = new Submarine(0, 0, false);
		Player player = new Player("PlayerTest");
		player.addBoat(littleShip, 10, 10);
		assertEquals(player.checkGuess(7, 7), Ship.MISSED);
		assertEquals(player.checkGuess(0, 0), Ship.HIT);
		assertEquals(player.checkGuess(1, 0), Ship.HIT);
		assertEquals(player.checkGuess(2, 0), Ship.DESTROYED);
	}

	/**
	 * Test method for {@link com.sinkanic.business.Player#isBoatAddable(com.sinkanic.ships.Ship, int, int)}.
	 */
	@Test
	public final void testIsBoatAddable() {
		Player player = new Player("PlayerTest2");
		Ship littleShip = new Submarine(0, 0, false);
		assertFalse(player.isBoatAddable(littleShip, 2, 2));//out of grid
		assertTrue(player.isBoatAddable(littleShip, 10, 10));
		player.addBoat(littleShip, 10, 10);
		assertFalse(player.isBoatAddable(littleShip, 10, 10));//already a ship here
	}

	/**
	 * Test method for {@link com.sinkanic.business.Player#isDead()}.
	 */
	@Test
	public final void testIsDead() {
		Ship littleShip = new Submarine(0, 0, false);
		Player player = new Player("PlayerTest3");
		player.addBoat(littleShip, 10, 10);
		assertFalse(player.isDead());
		player.checkGuess(0, 0);
		player.checkGuess(1, 0);
		player.checkGuess(2, 0);
		assertTrue(player.isDead());
	}

	/**
	 * Test method for {@link com.sinkanic.business.Player#addBoat(com.sinkanic.ships.Ship, int, int)}.
	 */
	@Test
	public final void testAddBoat() {
		Player player = new Player("PlayerTest4");
		int initialSize = player.getFleet().size();
		Ship littleShip = new Submarine(0, 0, false);
		player.addBoat(littleShip, 10, 10);
		assertTrue(player.getFleet().size() == initialSize + 1);
	}

}
