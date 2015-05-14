package com.sinkanic;

import com.sinkanic.controllers.GameController;
import com.sinkanic.controllers.StartupController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.StartupView;
import com.sinkanic.views.components.SView;

public class SinkanicApp {

	private GameModel			gameModel;
	private GameController		gameController;
	private StartupController	startController;
	private SView				startView;

	public SinkanicApp() {
		gameModel = new GameModel();
		run();
	}
	
	private void run() {
		gameController = new GameController();

		startController = new StartupController();
		startView = new StartupView(startController);
		
		startController.addModel(gameModel);
		startController.addView(startView);	
	}

}
