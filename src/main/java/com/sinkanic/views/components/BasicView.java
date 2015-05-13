package com.sinkanic.views.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		setLayout(new GridBagLayout());
	}
	
	private void initUI() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(new JLabel("Welcome bro !"), gbc);

		gbc.gridwidth = 1;
		JLabel lblName = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblName, gbc);
		

		JTextField tfInputName = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(tfInputName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JButtonDemarrer(), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(new QuitButton(), gbc);
		
		//validate();
		//pack();
	}
}
