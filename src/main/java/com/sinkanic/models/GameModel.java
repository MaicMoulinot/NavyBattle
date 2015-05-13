package com.sinkanic.models;

import java.awt.Dimension;
import java.util.Observable;

import com.sinkanic.business.Player;
import com.sinkanic.business.PlayerAI;

public class GameModel extends Observable {
	
	// Attributs
	public final static String BIDON = "bidon";
	public final static String FACILE = "facile";
	public final static String TROP_DUR = "balaise";

	private Dimension 	gridSize;
	
	private Player		player1;
	private PlayerAI	player2;
	
	private String		gameLevel;
	
	private boolean		cheatMode;

	public GameModel() {
		this(10,10);
	}
	
	public GameModel(int gridRows, int gridCols) {
		
		gridSize = new Dimension(gridRows, gridCols);
		initialize();
		
		setChanged();
		notifyObservers();
	}
	public Dimension getGridSize()	{ return gridSize; }		// returns Dimension object
	public int getGridRows() 		{ return gridSize.height; }	// returns specific dimension.
	public int getGridCols()		{ return gridSize.width; }	// this may be useless. 

	public Player 	getPlayer()		{ return player1; } // Both getters return a Player object  for clarity
	public Player	getAIPlayer()	{ return player2; } // inheritance/polymorphism

	public boolean isCheatModeActivated() { return cheatMode; }
	public void setCheatModeActive(boolean mode) {
		cheatMode = mode;
		setChanged();
		notifyObservers();
	}
	
	public String getGameLevel() 	{ return gameLevel; }
	public void setGameLevel(String level)
	{
		gameLevel = level;
		setChanged();
		notifyObservers();
	}
	
	private void initialize() {
		System.out.println("GameModel.initialize() : to be implemented.");
	}
	
}
