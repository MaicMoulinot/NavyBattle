package com.sinkanic.views.components;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.sinkanic.controllers.SController;

public abstract class SView extends JFrame {

	private static final long serialVersionUID = 5782287033396317471L;
	protected SController	controller;
	
	public SView() throws HeadlessException {
		this("Sinkanic Basic View");
	}
	
	public SView(String title) throws HeadlessException {
		setViewProperties(title, 300, 200);
	}
	
	private void setViewProperties(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	

}
