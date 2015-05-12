package test;
import logic.Game;

/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public class TestGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Initialisation du jeu");
		Game game = new Game();
		game.setup(Game.BIDON);
		// Méthode play
		System.out.println(game.play());
	}

}
