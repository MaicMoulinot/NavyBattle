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
		
		controller = new LayShipsController(gameModel);
		view = new LayShipsView(controller, gameModel);
		
		controller.addView(view); // useless, but for now still keeping reference to view.


		
	}

}
