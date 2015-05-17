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
		gameModel = GameModel.getInstance();
		//startController = new StartupController();
		//startView = new StartupView(startController);
		
		//startController.addModel(gameModel);
		//startController.addView(startView);
		System.out.println("SinkanicApp.run()  model=" + gameModel);
		LayShipsController layShipsController = new LayShipsController(GameModel.getInstance());
		
		//layShipsController.addModel(gameModel);

		
		LayShipsView layShips = new LayShipsView(layShipsController);
		layShipsController.addView(layShips);
		
	}

}
