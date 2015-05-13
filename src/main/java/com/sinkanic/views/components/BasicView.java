package com.sinkanic.views.components;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public abstract class BasicView extends JFrame {

	private static final long serialVersionUID = 5782287033396317471L;

	public BasicView() throws HeadlessException {
		this("Sinkanic Basic View");
	}
	
	public BasicView(String title) throws HeadlessException {
		setViewProperties(title, 300, 200);
	}

	private void setViewProperties(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
