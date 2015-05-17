package com.sinkanic.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.sinkanic.business.Player;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.components.GridSquare;

public class LayShipsController extends SController implements MouseListener{
	

	public LayShipsController(GameModel model) {
		super(model);
	}
	
	public void updatePlayer(String n)
	{
		Player newPlayer = new Player(n);
		((GameModel)modelRef).setPlayer(newPlayer);
		System.out.println("updatePlayer() countObservers=" + modelRef.countObservers());
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
