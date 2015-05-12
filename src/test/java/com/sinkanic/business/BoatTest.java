/**
 * 
 */
package logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author humanbooster
 *
 */
public class BoatTest {
	
	private Boat boat;

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
		boat = new Boat(false, 2, new Cellule(0, 0)); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link logic.Boat#Boat(boolean, int, logic.Cellule)}.
	 */
	@Test
	public final void testBoatBooleanIntCellule() {
		assertFalse("test constructor Boat", boat.getPositions().isEmpty());
	}

	/**
	 * Test method for {@link logic.Boat#checkGuess(int, int)}.
	 */
	@Test
	public final void testCheckGuess() {
		assertEquals(boat.checkGuess(0, 0), Boat.HIT);
		assertNotEquals(boat.checkGuess(9, 9), Boat.HIT);
	}

	/**
	 * Test method for {@link logic.Boat#isTouched(int, int)}.
	 */
	@Test
	public final void testIsTouched() {
		boat.checkGuess(0, 0);
		assertTrue(boat.isTouched(0, 0));
	}

	/**
	 * Test method for {@link logic.Boat#isDestroyed()}.
	 */
	@Test
	public final void testIsDestroyed() {
		boat.checkGuess(0, 0);
		boat.checkGuess(1, 0);
		assertTrue(boat.isDestroyed());
	}

}
