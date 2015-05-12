/**
 * 
 */
package com.sinkanic.business;



/**
 * @author humanbooster
 *
 */
public class PlayerCroissant extends Player {
	
	public Cell getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical) {
		nbTries++;
		int X = 0;
		int Y = 0;
		int line = 0;
		while (nbTries <= (tailleGrilleHorizontal*tailleGrilleVertical) && line < tailleGrilleVertical) {
			if (nbTries <= ((line+1)*tailleGrilleHorizontal)) {
				X = (tailleGrilleHorizontal - 1) - (tailleGrilleHorizontal * (line + 1) - nbTries);
				Y = line;
				break;
			} else {
				line++;
			}
		}
		Cell guessedCell = new Cell(X, Y);
		return guessedCell;
	}

}
