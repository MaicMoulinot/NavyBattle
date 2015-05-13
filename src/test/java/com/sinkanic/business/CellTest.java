/**
 * 
 */
package com.sinkanic.business;

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
public class CellTest {
	private Cell cell;

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
		cell  = new Cell(0, 0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cell = null;
	}
	
	/**
	 * Test method for {@link com.sinkanic.business.Cell#setHit()}.
	 */
	@Test
	public final void testSetHit() {
		assertFalse(cell.isHit());
		cell.setHit();
		assertTrue(cell.isHit());
	}

	/**
	 * Test method for {@link com.sinkanic.business.Cell#isSamePosition(int, int)}.
	 */
	@Test
	public final void testIsSamePosition() {
		assertTrue(0 == cell.x && 0 == cell.y);
	}

}
