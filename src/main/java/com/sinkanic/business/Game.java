package com.sinkanic.business;

import java.util.ArrayList;

import com.sinkanic.ships.Ship;


public class Game {
	
	// Attributs
	public final static String BIDON = "bidon";
	public final static String FACILE = "facile";
	public final static String TROP_DUR = "balaise";
	
	/**
	 * Taille horizontale d'une grille.
	 */
	private int tailleGrilleHorizontal;
	/**
	 * Taille verticale d'une grille.
	 */
	private int tailleGrilleVertical;
	
	private String level;

	/**
	 * Joueur.
	 */
	private Player player1; //joueur
	private PlayerAI player2; //ordi
	
	
	// Méthodes
	/**
	 * Launch a game.
	 * @param difficulte a String the chosen level.
	 * @param name a String the player's name
	 */
	public Game(String difficulte, String name) {
		level = difficulte;
		switch (level) {
		case BIDON:
			// 1D 1 bateau de taille 3
			tailleGrilleHorizontal = 7;
			tailleGrilleVertical = 1;
			player1 = new Player(name);
			player2 = new PlayerAI();
			addRandomBoatOnPlayerAI(3);
			break;
		case FACILE:
			// 2D 1 bateau de taille 3
			tailleGrilleHorizontal = 10;
			tailleGrilleVertical = 10;
			player1 = new Player(name);
			player2 = new PlayerAI();
			addRandomBoatOnPlayerAI(3);
			addRandomBoatOnPlayerAI(3);
			break;
		case TROP_DUR:
			// 2D flotte de 2 bateaux de taille 3, 2 bateau de taille 2, 1 bateau de taille 1
			tailleGrilleHorizontal = 10;
			tailleGrilleVertical = 10;
			player1 = new Player(name);
			player2 = new PlayerAI();
			break;
		}
	}
	
	/**
	 * As long as the AI player is not dead, the game
	 * asks the player his next try and test the AI player's fleet.
	 * When AI player is dead, displays the number of tries.
	 * @return a list of results.
	 * */
	public ArrayList<String> play() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			while (!player2.isDead()) {
				Cell tryPlayer = ((PlayerAI) player2).getRandomCell(tailleGrilleHorizontal, tailleGrilleVertical);
				result.add("Essai du joueur sur " + tryPlayer.toString() + ": " + checkGuess(player1, player2, tryPlayer.getIntX(), tryPlayer.getIntY()));
			}
			result.add("Partie terminée en " + player1.getNbEssais() + " essais.");
		} catch (Exception exception) {
			System.out.println("Trouble : " + exception.getMessage());
		}
		return result;
	}

	/**
	 * @return a list of cheat tips.
	 */
	public ArrayList<String> afficheTriche() {
		ArrayList<String> resultat = new ArrayList<String>();
		resultat.add("ATTENTION TRICHE : essaye donc les cases ");
		resultat.addAll(getPlayer2().afficheBoats());
		return resultat;
	}
	
	/**
	 * 
	 * @param playing the Player trying to hit a boat from the checked's player fleet
	 * @param checked the Player beeing checked
	 * @param testX int the horizontal position to check
	 * @param testY int the vertical position to check
	 * @return a String the result belonging to one of these :
	 * {@link com.sinkanic.ships.Ship#MISSED},
	 * {@link com.sinkanic.ships.Ship#HIT},
	 * {@link com.sinkanic.ships.Ship#DESTROYED}.
	 * @see com.sinkanic.business.Player#checkGuess(int, int)
	 */
	public String checkGuess(Player playing, Player checked, int testX, int testY) {
		playing.incrementNbEssais();
		return checked.checkGuess(testX, testY);
	}

	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @return the tailleGrilleHorizontal
	 */
	public int getTailleGrilleHorizontal() {
		return tailleGrilleHorizontal;
	}

	/**
	 * @return the tailleGrilleVertical
	 */
	public int getTailleGrilleVertical() {
		return tailleGrilleVertical;
	}

	public void setFleetAI() {
		for (Ship bateau : getPlayer1().getFleet()) {
			addRandomBoatOnPlayerAI(bateau.getShipSize());
		}
	}

	private void addRandomBoatOnPlayerAI(int taille) {
		player2.createRandomBoat(tailleGrilleHorizontal, tailleGrilleVertical, taille);
	}

	public String getLevel() {
		return level;
	}
}
