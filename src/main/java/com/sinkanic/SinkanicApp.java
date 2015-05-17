package com.sinkanic;

import com.sinkanic.controllers.LayShipsController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.LayShipsView;

public class SinkanicApp {

	private GameModel			gameModel;

	public SinkanicApp() {
		run();
	}
	
	private void run() {
		gameModel = new GameModel();
		//startController = new StartupController();
		//startView = new StartupView(startController);
		
		//startController.addModel(gameModel);
		//startController.addView(startView);
		
		LayShipsController layShipsController = new LayShipsController(gameModel);
		
		//layShipsController.addModel(gameModel);

		
		LayShipsView layShips = new LayShipsView(layShipsController);
		layShipsController.addView(layShips);
		
	}

}
