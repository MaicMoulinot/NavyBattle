package com.sinkanic.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.sinkanic.business.Player;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.LayShipsView;
import com.sinkanic.views.components.GridSquare;

public class LayShipsController extends SController implements MouseListener{
	

	public LayShipsController(GameModel model) {
		super(model);
		System.out.println("LayShipsController(GameModel) param = " + model);
		System.out.println("LayShipsController(GameModel) attribute = " + this.modelRef);
	}
	
	public void updatePlayer(String n)
	{
		System.out.println("updatePlayer() attr = " + this.modelRef);
		System.out.println("updatePlayer() singleton = " + GameModel.getInstance());
		Player newPlayer = new Player(n);
		((GameModel)modelRef).setPlayer(newPlayer);
	}
	
	public void setGameLevel(String n) {
		((GameModel)modelRef).setGameLevel(n);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println( ((JButton) e.getSource()).getClass().getSimpleName());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("GridSquare")) {
			((GridSquare) e.getSource()).setHoverBackground();
		}
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("GridSquare")) {
			((GridSquare) e.getSource()).resetBackground();
		}		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
