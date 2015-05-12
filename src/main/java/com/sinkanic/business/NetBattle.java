package com.sinkanic.business;
/**
 * 
 */

/**
 * @author humanbooster
 *
 */
public class NetBattle {
	
	public static Game startGame(String difficulte) {
		Game game = new Game();
		game.setup(difficulte);
		return game;
	}

}
