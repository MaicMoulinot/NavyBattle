package com.sinkanic.views.components;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class BasicView extends JFrame {

	private static final long serialVersionUID = 5782287033396317471L;

	public BasicView() throws HeadlessException {
		this("Sinkanic Basic View");
	}
	
	public BasicView(String title) throws HeadlessException {
		setViewProperties(title, 300, 200);
		initUI();
	}

	private void setViewProperties(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(0, 2));
	}
	
	private void initUI() {
		add(new JLabel("Welcome aboard bro !"));
		JLabel lblName = new JLabel("Name:");
		add(lblName);
		
		
		
	}
}
