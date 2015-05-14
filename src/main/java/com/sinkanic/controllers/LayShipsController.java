package com.sinkanic.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.sinkanic.business.Player;
import com.sinkanic.models.GameModel;
import com.sinkanic.views.LayShipsView;
import com.sinkanic.views.components.GridSquare;

public class LayShipsController extends SController implements MouseListener{

	GameModel		model;
	LayShipsView	view;
	
	public LayShipsController() {
	}

	public void addModel(GameModel model) {
		this.model = model;
	}
	
	public void addView(LayShipsView view) {
		this.view = view;
	}
	
	public void setPlayerName(String n)
	{
		Player newPlayer = new Player(n);
		((GameModel)this.model).setPlayer(newPlayer);
		System.out.println("Start button pressed !! PlayerName=" + ((GameModel)this.model).getPlayer().getName());
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
