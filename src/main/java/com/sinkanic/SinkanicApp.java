package com.sinkanic;

import com.sinkanic.controllers.GameController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.StartupView;
import com.sinkanic.views.components.SView;

public class SinkanicApp {

	private GameModel		gameModel;
	private GameController 	gameController;
	private SView			startView;

	public SinkanicApp() {
		gameModel = new GameModel();
		gameController = new GameController();
		startView = new StartupView();
		
		gameController.addModel(gameModel);
		gameController.addView(startView);
		
		startView.bindController(gameController);
		
	
		
	}

}
