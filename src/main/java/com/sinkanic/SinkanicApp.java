package com.sinkanic;

import com.sinkanic.controllers.LayShipsController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.LayShipsView;

public class SinkanicApp {

	private GameModel			gameModel;

	public SinkanicApp() {
		gameModel = new GameModel();
		run();
	}
	
	private void run() {
		gameModel = new GameModel();
		//startController = new StartupController();
		//startView = new StartupView(startController);
		
		//startController.addModel(gameModel);
		//startController.addView(startView);
		
		LayShipsController layShipsController = new LayShipsController();
		
		layShipsController.addModel(gameModel);
		
		
		LayShipsView layShips = new LayShipsView(layShipsController);
		layShipsController.addView(layShips);
		
	}

}
