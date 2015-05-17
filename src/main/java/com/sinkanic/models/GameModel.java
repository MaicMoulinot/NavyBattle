package com.sinkanic.models;

import java.awt.Dimension;

import com.sinkanic.business.Player;
import com.sinkanic.business.PlayerAI;

public class GameModel extends SModel {
	
	// Singleton instance
	private static GameModel instance = null;
	
	// Attributs
	public final static String BIDON = "bidon";
	public final static String FACILE = "facile";
	public final static String TROP_DUR = "balaise";

	private Dimension 	gridSize;
	
	private Player		player1;
	private PlayerAI	player2;
	
	private String		gameLevel;
	
	private boolean		cheatMode;

	private GameModel() {
		this(10,10);
	}

	private GameModel(int gridRows, int gridCols) {
		
		gridSize = new Dimension(gridRows, gridCols);
		initialize();
		
		setChanged();
		notifyObservers();
	}

	public static GameModel getInstance() {
		if (instance == null)
		{
			instance = new GameModel();
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		return instance;
	}
	
	public Dimension getGridSize()	{ return gridSize; }		// returns Dimension object
	public int getGridRows() 		{ return gridSize.height; }	// returns specific dimension.
	public int getGridCols()		{ return gridSize.width; }	// this may be useless. 

	public Player 	getPlayer()		{ return player1; } // Both getters return a Player object  for clarity
	public Player	getAIPlayer()	{ return player2; } // polymorphism
	public void		setPlayer(Player p) {
		player1 = p;
		propagateChanges();
	}

	public boolean isCheatModeActivated() { return cheatMode; }
	public void setCheatModeActive(boolean mode) {
		cheatMode = mode;
		propagateChanges();
	}
	
	public String getGameLevel() 	{ return gameLevel; }
	public void setGameLevel(String level) {
		gameLevel = level;
		propagateChanges();
	}
	
	public void setPlayerName(String name) {
		player1.setName(name);
		propagateChanges();
	}
	
	private void initialize() {
		System.out.println("GameModel.initialize() : to be implemented.");
	}
	
	private void propagateChanges()
	{
		setChanged();
		notifyObservers();
	}
}
