/**
 * 
 */
package logic;



/**
 * @author humanbooster
 *
 */
public class PlayerCroissant extends Player {

	/**
	 * @return <Cellule> la prochaine tentative du joueur
	 */
	public Cellule getGuess(int tailleGrilleHorizontal, int tailleGrilleVertical) {
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
		Cellule guessedCell = new Cellule(X, Y);
		return guessedCell;
	}

}
