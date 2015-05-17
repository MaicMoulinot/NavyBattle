package com.sinkanic.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import com.sinkanic.models.SModel;
import com.sinkanic.views.components.SView;

public abstract class SController implements ActionListener {

	protected SModel	model;
	protected SView		view;
	
	@Deprecated
	public SController() {}
	
	public SController(SModel model) {
		System.out.println("SController(SModel) model = " + model);
		this.model = model;
	}
	
	public boolean addModel(SModel model) {
		System.out.println("SModel.addModel() : " + model);	
		this.model = model;
		return true;
	}
	
	public void addView(SView view) {
		this.view = view;
		System.out.println(model);
		model.addObserver((Observer) view);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
