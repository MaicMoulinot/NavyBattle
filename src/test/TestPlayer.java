package test;
import logic.Cellule;
import logic.Player;
import logic.PlayerRandom;

/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public class TestPlayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// première technique : dans l'ordre
		Player player = new PlayerRandom();
		Cellule cell = player.getGuess(7, 1);
		System.out.println("Le joueur essaye la case (" + cell.getPositionHorizontal() + "," + cell.getPositionVertical() + ")");
		cell = player.getGuess(10, 1);
		System.out.println("Le joueur essaye la case (" + cell.getPositionHorizontal() + "," + cell.getPositionVertical() + ")");
		cell = player.getGuess(10, 10);
		System.out.println("Le joueur essaye la case (" + cell.getPositionHorizontal() + "," + cell.getPositionVertical() + ")");
	}

}
