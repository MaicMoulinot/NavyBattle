package com.sinkanic;

import com.sinkanic.controllers.LayShipsController;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.LayShipsView;

public class SinkanicApp {

	private GameModel			gameModel;
	private LayShipsView		view;
	private LayShipsController	controller;

	public SinkanicApp() {
		run();
	}
	
	private void run() {
		gameModel = GameModel.getInstance();
		
		
		System.out.println("SinkanicApp.run()  model=" + gameModel);
		controller = new LayShipsController(gameModel, view);
		view = new LayShipsView(controller);

		
		
		//layShipsController.addView(new LayShipsView(layShipsController));
		
	}

}
