package com.sinkanic.business;

/**
 * @author humanbooster
 *
 */
public class Cell {
	
	private boolean isTouched;
	private int positionHorizontal;
	private int positionVertical;

	void setTouched() {
		isTouched = true;
	}

	/**
	 * Non touché à l'initialisation
	 */
	public Cell(int positionHorizontale, int positionVerticale) {
		isTouched = false;
		positionHorizontal = positionHorizontale;
		positionVertical = positionVerticale;
	}
	
	public boolean isTouched() {
		return isTouched;
	}

	/**
	 * @return the positionHorizontal
	 */
	public int getPositionHorizontal() {
		return positionHorizontal;
	}

	/**
	 * @return the positionVertical
	 */
	public int getPositionVertical() {
		return positionVertical;
	}
	
	public boolean isEquals(Cell testCellule) {
		return isEquals(testCellule.getPositionHorizontal(), testCellule.getPositionVertical());
	}
	
	public boolean isEquals(int positionHorizontal, int positionVertical) {
		boolean resultat = false;
		if (positionHorizontal == getPositionHorizontal() && positionVertical == getPositionVertical()) {
			resultat = true;
		}
		return resultat;
	}

}
