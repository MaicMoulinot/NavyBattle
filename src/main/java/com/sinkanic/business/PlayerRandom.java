/**
 * 
 */
package com.sinkanic.business;

import java.util.Random;

/**
 * @author humanbooster
 *
 */
public class PlayerRandom extends Player {

	/**
	 * @return la prochaine tentative du joueur
	 */
	public Cell getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical) {
		nbTries++;
		Random randomGenerator = new Random();
	    int randomHorizontal = randomGenerator.nextInt(tailleGrilleHorizontal-1);
	    int randomVertical = 0;
	    if (tailleGrilleVertical > 1) {
	    	randomVertical = randomGenerator.nextInt(tailleGrilleVertical-1);
	    }
	    Cell guessedCell = new Cell(randomHorizontal, randomVertical);
		return guessedCell;
	}

}
