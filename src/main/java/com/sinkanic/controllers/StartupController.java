package com.sinkanic.controllers;

import com.sinkanic.business.Player;
import com.sinkanic.models.GameModel;

public class StartupController extends SController {

	public StartupController() {
		
	}
	
	public void startButtonPressed(Object o) {
		System.out.println(o);
		Player newPlayer = new Player((String)o);
		((GameModel)this.modelRef).setPlayer(newPlayer);
		System.out.println("Start button pressed !! PlayerName=" + ((GameModel)this.modelRef).getPlayer().getName());
	}
	
	public void initializeModel() {
	}

}
