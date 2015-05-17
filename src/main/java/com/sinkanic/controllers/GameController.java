package com.sinkanic.controllers;

import com.sinkanic.models.GameModel;
import com.sinkanic.models.SModel;
import com.sinkanic.views.components.SView;

public class GameController extends SController{

	GameModel	model;
	SView		view;
	
	public GameController(SModel model, SView view) {
		super(model, view);
	}
	
}
