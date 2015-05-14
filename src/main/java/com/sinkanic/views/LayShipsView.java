package com.sinkanic.views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sinkanic.controllers.LayShipsController;
import com.sinkanic.views.components.ShipListPanel;
import com.sinkanic.views.components.SquareGridPanel;

public class LayShipsView extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6085017128796603817L;

	private JPanel	rightPanel;
	private JPanel	leftPanel;
	
	private LayShipsController	controller;
	
	public LayShipsView(LayShipsController controller) {
		this("BattleShips Basic Window", controller);
	}
	
	public LayShipsView(String title, LayShipsController controller){
		this(title, 900, 600, controller);
	}
	
	public void bindController(LayShipsController controller) {
		this.controller = controller;
	}
	
	public LayShipsView(String title, int width, int height, LayShipsController controller){
		setWindowProperties(title, width, height);

		this.controller = controller; //bind controller

		rightPanel = new JPanel(new GridBagLayout());
		rightPanel.setBackground(Color.LIGHT_GRAY);
		
		leftPanel = new JPanel(new GridLayout(0,1));
		leftPanel.setBackground(Color.GRAY);
		
		prepareGUI();

		add(leftPanel);
		add(rightPanel);
		
		validate();
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

