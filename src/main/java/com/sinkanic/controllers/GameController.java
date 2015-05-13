package com.sinkanic.controllers;

import com.sinkanic.models.GameModel;

public class GameController {

	GameModel	model;
	
	public GameController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addModel(GameModel model) {
		if (this.model != null) {
			System.out.println("GameModel.addModel() : already have a bound model.");	
			return false;
		}
		this.model = model;
		return true;
	}

}
