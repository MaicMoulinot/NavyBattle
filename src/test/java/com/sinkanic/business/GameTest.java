/**
 * 
 */
package com.sinkanic.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinkanic.ships.Cruiser;
import com.sinkanic.ships.Ship;
import com.sinkanic.ships.Submarine;

/**
 * @author humanbooster
 *
 */
public class GameTest {
	
	private Game game;

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
		game = new Game(Game.TROP_DUR, "TestDriveName");
		Ship littleShip = new Submarine(0, 0, false);
		Ship mediumShip = new Cruiser(1, 1, false);
		game.getPlayer1().addBoat(littleShip, 10, 10);
		game.getPlayer1().addBoat(mediumShip, 10, 10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		game = null;
	}

	/**
	 * Test method for {@link com.sinkanic.business.Game#setFleetAI()}.
	 */
	@Test
	public final void testSetFleetAI() {
		assertNotEquals(game.getPlayer1().getFleet().size(), game.getPlayer2().getFleet().size());
		game.setFleetAI();
		assertEquals(game.getPlayer1().getFleet().size(), game.getPlayer2().getFleet().size());
	}
	
	/**
	 * Test method for {@link com.sinkanic.business.Game#checkGuess(com.sinkanic.business.Player, com.sinkanic.business.Player, int, int)}.
	 */
	@Test
	public final void testCheckGuess() {
		int nbTries = game.getPlayer1().getNbEssais();
		String resultat = game.checkGuess(game.getPlayer1(), game.getPlayer2(), 5, 5);
		assertTrue(game.getPlayer1().getNbEssais() == nbTries+1);
		assertFalse(resultat == Ship.HIT);
		assertFalse(resultat == Ship.DESTROYED);
		assertTrue(resultat == Ship.MISSED);
	}

}
