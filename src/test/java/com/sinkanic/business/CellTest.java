package com.sinkanic.business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinkanic.business.Cell;

/**
 * @author humanbooster
 *
 */
public class CellTest {

	private Cell cell;
	private Cell cell1;
	private Cell cell2;

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

	@Before
	public void setUp() throws Exception {
		cell  = new Cell(5, 3);
		cell1 = new Cell(5, 3);
		cell2 = new Cell(8, 2);
		
	}

	@After
	public void tearDown() throws Exception {
		cell = null;
		cell1 = null;
		cell2 = null;
	}

	@Test
	public final void testSetHit() {
		cell.setHit();
		assertTrue(cell.isHit());
	}

	@Test
	public final void testCell() {
		
		//cas de test 1
		assertNotNull("L'instance ne est pas créée", cell);
		
		//cas de test 2
		assertEquals("Dans le constructeur Horizontal Position ne est pas correct", 5, cell.getHorizontalPosition());
		assertEquals("Dans le constructeur Vertical Position ne est pas correct", 3, cell.getVerticalPosition());
		assertFalse("Dans le constructeur Hit ne est pas correct", cell.isHit());
	}

	@Test
	public final void testIsHit() {
		cell.setHit();
		
		assertTrue(cell.isHit());
	}

	@Test
	public final void testGetHorizontalPosition() {
		assertEquals("Dans GetHorizontalPosition la Position ne  est pas correct", 5, cell.getHorizontalPosition());
	}

	@Test
	public final void testGetVerticalPosition() {
		assertEquals("Dans GetVerticalPosition la Position ne  est pas correct", 3, cell.getVerticalPosition());
	}

	@Test
	public final void testIsEqualsCell() {
		assertTrue("la IsEqualsCell function ne est pas correct pour le cas positif", cell.isEquals(cell1));
		assertFalse("la IsEqualsCell function ne est pas correct  pour le cas négatif", cell.isEquals(cell2));
	}

	@Test
	public final void testIsEqualsIntInt() {
		assertTrue("la IsEqualsCell function ne est pas correct pour le cas positif", cell.isEquals(5,3));
		assertFalse("la IsEqualsCell function ne est pas correct pour le cas négatif", cell.isEquals(4,2));
	}
}
