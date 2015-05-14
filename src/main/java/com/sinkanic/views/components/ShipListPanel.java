package com.sinkanic.views.components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.sinkanic.controllers.LayShipsController;

public class ShipListPanel extends JPanel {

	private static final long serialVersionUID = 4268222755205269861L;
	
	private LayShipsController	controller;
	
	public ShipListPanel(LayShipsController controller) {
		this.controller = controller;
		setLayout(new GridLayout(0, 1));
		populatePanel();
	}

	private void populatePanel(){
		ShipButton aircraftCarrier = new ShipButton("Aircraft Carrier");
		aircraftCarrier.addMouseListener(controller);
		add(aircraftCarrier);

		ShipButton destroyer = new ShipButton("Destroyer");
		destroyer.addMouseListener(controller);
		add(destroyer);
		
		ShipButton submarine = new ShipButton("Submarine");
		submarine.addMouseListener(controller);
		add(submarine);
		
		ShipButton patrolShip = new ShipButton("Patrol Ship");
		patrolShip.addMouseListener(controller);
		add(patrolShip);
		
		ShipButton ship = new ShipButton("Ship");
		ship.addMouseListener(controller);
		add(ship);
	}

}
