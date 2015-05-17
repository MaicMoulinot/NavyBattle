package com.sinkanic.views.components;

import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import com.sinkanic.controllers.SController;
import com.sinkanic.models.SModel;

public abstract class SView extends JFrame implements Observer {

	private static final long serialVersionUID = 5782287033396317471L;
	protected SController	controller;
	
	public SView(SModel model) throws HeadlessException {
		this("Sinkanic Basic View", model);
	}
	
	public SView(String title, SModel model) throws HeadlessException {
		setViewProperties(title, 300, 200);
		model.addObserver(this);
	}
	
	private void setViewProperties(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("LayShipsView.update()");
	}

}
