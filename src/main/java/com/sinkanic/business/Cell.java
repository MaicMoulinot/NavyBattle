package com.sinkanic.business;

/**
 * @author humanbooster
 *
 */
public class Cell {
	
	private boolean isHit;
	private int positionHorizontal;
	private int positionVertical;

	void setHit() {
		isHit = true;
	}

	/**
	 * Non touché à l'initialisation
	 */
	public Cell(int positionHorizontale, int positionVerticale) {
		isHit = false;
		positionHorizontal = positionHorizontale;
		positionVertical = positionVerticale;
	}
	
	public boolean isHit() {
		return isHit;
	}

	/**
	 * @return the positionHorizontal
	 */
	public int getHorizontalPosition() {
		return positionHorizontal;
	}

	/**
	 * @return the positionVertical
	 */
	public int getVerticalPosition() {
		return positionVertical;
	}
	
	public boolean isEquals(Cell testCellule) {
		return isEquals(testCellule.getHorizontalPosition(), testCellule.getVerticalPosition());
	}
	
	public boolean isEquals(int positionHorizontal, int positionVertical) {
		boolean resultat = false;
		if (positionHorizontal == getHorizontalPosition() && positionVertical == getVerticalPosition()) {
			resultat = true;
		}
		return resultat;
	}

}
