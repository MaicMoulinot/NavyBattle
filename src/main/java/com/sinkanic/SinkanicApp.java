package com.sinkanic;

import com.sinkanic.controllers.GameController;
import com.sinkanic.models.GameModel;

public class SinkanicApp {

	private GameModel		gameModel;
	private GameController 	gameController;

	public SinkanicApp() {
		gameModel = new GameModel();
		gameController = new GameController();
		
		gameController.addModel(gameModel);
	}

}
