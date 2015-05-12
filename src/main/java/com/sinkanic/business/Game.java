package com.sinkanic.business;

import java.util.ArrayList;


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

	/**
	 * Joueur.
	 */
	private Player player1; //joueur
	private Player player2; //ordi
	
	
	// Méthodes
	/**
	 * Génère une partie.
	 * @param <String> difficulte la difficulté choisie
	 */
	public Game(String difficulte) {
		switch (difficulte) {
		case BIDON:
			// 1D 1 bateau de taille 3
			tailleGrilleHorizontal = 7;
			tailleGrilleVertical = 1;
			player1 = new PlayerReel();
			player2 = new PlayerRandom();
			addRandomBoatPlayer2();
			break;
		case FACILE:
			// 2D 1 bateau de taille 3
			tailleGrilleHorizontal = 10;
			tailleGrilleVertical = 10;
			player1 = new PlayerReel();
			player2 = new PlayerCroissant();
			addBoatRandomPlayer2(3);
			addBoatRandomPlayer2(3);
			break;
		case TROP_DUR:
			// 2D flotte de 2 bateaux de taille 3, 2 bateau de taille 2, 1 bateau de taille 1
			tailleGrilleHorizontal = 10;
			tailleGrilleVertical = 10;
			player1 = new PlayerReel();
			player2 = new PlayerRandom();
			break;
		}
	}
	
	/**
	 * Tant que l'ennemi n'est pas mort, le jeu	
	 * demande son prochain essai au joueur et demande à
	 * l'ennemi d'indiquer s'il est touché. Quand l'ennemi est
	 * mort, affiche le nombre d'essais utilisés puis quitte.
	 * @return ArrayList<String> les résultats
	 * */
	public ArrayList<String> play() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			for (Boat boat : player1.getFlotte()) {
				while (!boat.isSunk()) {
					Cell tryPlayer = player1.getGuess(tailleGrilleHorizontal, tailleGrilleVertical);//TODO
					int X = tryPlayer.getHorizontalPosition();
					int Y = tryPlayer.getVerticalPosition();
					result.add("Essai du joueur sur (" + X + "," + Y + "): " + checkGuess(X, Y));
				}
			}
			result.add("Partie terminée en " + player1.getNbEssais() + " essais.");
		} catch (NullPointerException exception) {
			System.out.println("Paramètre null : " + exception.getMessage());
		}
		return result;
	}

	/**
	 * @return de la triche le bateau est situé sur les cases
	 */
	public ArrayList<String> afficheTriche() {
		ArrayList<String> resultat = new ArrayList<String>();
		resultat.add("ATTENTION TRICHE : essaye donc les cases ");
		resultat.addAll(getPlayer2().afficheBoats());
		return resultat;
	}

	/**
	 * @see Player.checkGuess()
	 */
	public String checkGuess(int testX, int testY) {
		player1.incrementNbEssais();
		return player2.checkGuess(testX, testY);
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
	
	private void addRandomBoatPlayer2() {
		addBoatRandomPlayer2(3);
	}

	public void addBoatRandomPlayer2(int taille) {
		player2.createRandomBoat(tailleGrilleHorizontal, tailleGrilleVertical, taille);
	}
}
