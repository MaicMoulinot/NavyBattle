package com.sinkanic.business;

import java.awt.Point;

/**
 * @author humanbooster
 *
 */
public class Cell extends Point {
	
	private static final long serialVersionUID = 1L;
	private boolean isHit;

	public void setHit() {
		isHit = true;
	}

	/**
	 * Untouched when initialized
	 * @param positionHorizontale int the hotizontal position
	 * @param positionVerticale int the vertical position
	 */
	public Cell(int positionHorizontale, int positionVerticale) {
		isHit = false;
		setLocation(positionHorizontale, positionVerticale);
	}
	
	public boolean isHit() {
		return isHit;
	}
	
	public boolean isSamePosition(Cell testCellule) {
		return isSamePosition(testCellule.x, testCellule.y);
	}
	
	public boolean isSamePosition(int positionHorizontal, int positionVertical) {
		boolean resultat = false;
		if (positionHorizontal == x && positionVertical == y) {
			resultat = true;
		}
		return resultat;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
