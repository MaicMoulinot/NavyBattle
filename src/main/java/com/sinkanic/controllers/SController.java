package com.sinkanic.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import com.sinkanic.models.SModel;
import com.sinkanic.views.components.SView;

public abstract class SController implements ActionListener {

	// protected Attributes
	protected SModel	modelRef;
	protected SView		view;
	

	public SController(SModel model, SView view) {
		this.modelRef = model;
		this.view = view;
		//threadingDelay(1500);
	}
	
	private void threadingDelay(int delay) {
		try {
			Thread.currentThread();
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addModel(SModel model) {
		System.out.println("SModel.addModel() : " + model);	
		this.modelRef = model;
		return true;
	}
	
	public void addView(SView view) {
		this.view = view;
		System.out.println("SController.addView() model = " + modelRef);
		modelRef.addObserver((Observer) view);
		System.out.println("SController.addView() countObservers=" + modelRef.countObservers());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
