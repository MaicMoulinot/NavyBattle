package com.sinkanic.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import com.sinkanic.models.SModel;
import com.sinkanic.views.components.SView;

public abstract class SController implements ActionListener {

	protected SModel	model;
	protected SView		view;
	
	public SController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addModel(SModel model) {
		if (this.model != null) {
			System.out.println("SModel.addModel() : already have a bound model.");	
			return false;
		}
		this.model = model;
		return true;
	}
	
	public void addView(SView view) {
		this.view = view;
		if (model != null)
			model.addObserver((Observer) view);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
