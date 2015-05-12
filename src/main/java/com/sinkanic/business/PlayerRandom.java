/**
 * 
 */
package logic;

import java.util.Random;

/**
 * @author humanbooster
 *
 */
public class PlayerRandom extends Player {

	/**
	 * @return la prochaine tentative du joueur
	 */
	public Cellule getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical) {
		nbTries++;
		Random randomGenerator = new Random();
	    int randomHorizontal = randomGenerator.nextInt(tailleGrilleHorizontal-1);
	    int randomVertical = 0;
	    if (tailleGrilleVertical > 1) {
	    	randomVertical = randomGenerator.nextInt(tailleGrilleVertical-1);
	    }
	    Cellule guessedCell = new Cellule(randomHorizontal, randomVertical);
		return guessedCell;
	}

}
