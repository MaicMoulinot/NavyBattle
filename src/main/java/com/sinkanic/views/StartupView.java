package com.sinkanic.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sinkanic.views.components.BasicView;
import com.sinkanic.views.components.JButtonDemarrer;
import com.sinkanic.views.components.QuitButton;

public class StartupView extends BasicView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9218826288861126393L;

	public StartupView() throws HeadlessException {
		this("Sinkanic Startup View");
	}

	public StartupView(String title) throws HeadlessException {
		super(title);		
		initUI();
	}
	private void initUI() {
		setLayout(new GridBagLayout());
		
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
		
		validate();
	}

}
