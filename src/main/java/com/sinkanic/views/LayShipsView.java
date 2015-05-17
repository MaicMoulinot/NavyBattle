package com.sinkanic.views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sinkanic.controllers.LayShipsController;
import com.sinkanic.models.GameModel;
import com.sinkanic.models.SModel;
import com.sinkanic.views.components.SView;
import com.sinkanic.views.components.ShipListPanel;
import com.sinkanic.views.components.SquareGridPanel;

public class LayShipsView extends SView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6085017128796603817L;

	private JPanel	rightPanel;
	private JPanel	leftPanel;
	
	private LayShipsController	controller;

	public LayShipsView(LayShipsController controller, SModel model) {
		this("Sinkanic - Lay Ships ", 900, 600, controller, model);
	}

	public LayShipsView(String title, int width, int height, LayShipsController controller, SModel model) {
		
		super(title, model);
		
		setWindowProperties(title, width, height);

		this.controller = controller; //bind controller
		GameModel.getInstance().addObserver(this);

		rightPanel = new JPanel(new GridBagLayout());
		rightPanel.setBackground(Color.LIGHT_GRAY);
		
		leftPanel = new JPanel(new GridLayout(0,1));
		leftPanel.setBackground(Color.GRAY);
		
		prepareGUI();

		add(leftPanel);
		add(rightPanel);
		
		validate();
		
		promptGameSettings();
}
	
	private void promptGameSettings() {
		 String name = JOptionPane.showInputDialog(this, "What's your name?");
		 controller.updatePlayer(name);
		 
		 Object[] props = {"Noob", "Medium", "YOLO"};
		 String s = (String)JOptionPane.showInputDialog(
                 this,
                 "Select game level:\n",
                 "Game Level Selection",
                 JOptionPane.QUESTION_MESSAGE,
                 null,
                 props,
                 props[2]);
		 controller.setGameLevel(s);
	}

	private void setWindowProperties(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,2));
	}

	
	private void prepareGUI() {
		rightPanel.add(new SquareGridPanel(controller));
		leftPanel.add(new ShipListPanel(controller));
	}

}

