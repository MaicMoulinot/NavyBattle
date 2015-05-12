package test;
import logic.Boat;
import logic.Cellule;

/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public class TestEnemy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Boat boat = new Boat(new Cellule(1, 1));
		
		// On vérifie qu'un Boat non touché renvoie bien "Missed"
		System.out.println("On vérifie qu'un Boat non touché renvoie bien Missed");
		System.out.println(boat.checkGuess(6, 1));
		
		// On vérifie qu'un Boat touché renvoie bien "Hit"
		System.out.println("On vérifie qu'un Boat touché renvoie bien Hit");
		System.out.println(boat.checkGuess(1, 1));

		// On vérifie qu'un Boat coulé renvoie bien "Destroyed"
		System.out.println("On vérifie qu'un Boat coulé renvoie bien Destroyed");
		boat.checkGuess(2, 1);
		System.out.println(boat.checkGuess(3, 1));
	}

}
