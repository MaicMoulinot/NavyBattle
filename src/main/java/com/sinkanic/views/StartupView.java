package com.sinkanic.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sinkanic.controllers.SController;
import com.sinkanic.controllers.StartupController;
import com.sinkanic.views.components.QuitButton;
import com.sinkanic.views.components.SView;

public class StartupView extends SView implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9218826288861126393L;

	public StartupView(StartupController ctrl) throws HeadlessException {
		this("Sinkanic Startup View", ctrl);
	}

	public StartupView(String title, StartupController ctrl) throws HeadlessException {
		super(title);
		this.controller = ctrl;
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
		tfInputName.setText("player1name");
		add(tfInputName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton btStart = new JButton("Start");
		btStart.addActionListener(
				new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	((StartupController)controller).startButtonPressed(tfInputName.getText()); //cast generic SController to view-specific controller
            }});
		add(btStart, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(new QuitButton(), gbc);
		

		validate();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("StartupView.update()");
		
	}

	@Override
	public void bindController(SController controller) {
		// TODO Auto-generated method stub
		
	}

}
