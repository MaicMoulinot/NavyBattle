package com.sinkanic.controllers;

import com.sinkanic.models.GameModel;
import com.sinkanic.views.components.SView;

public class GameController {

	GameModel	model;
	SView	view;
	
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
	
	public void addView(SView view) {
		this.view = view;
	}

}
