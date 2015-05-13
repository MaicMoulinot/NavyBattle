package com.sinkanic;

import com.sinkanic.controllers.SController;
import com.sinkanic.controllers.StartupController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.StartupView;
import com.sinkanic.views.components.SView;

public class SinkanicApp {

	private GameModel		gameModel;
	private SController 	startController;
	private SView			startView;

	public SinkanicApp() {
		gameModel = new GameModel();
		startController = new StartupController();
		startView = new StartupView((StartupController) startController);
		
		startController.addModel(gameModel);
		startController.addView(startView);
		
		
		startView.bindController(startController);
		startView.setVisible(true);
	
		
	}

}
