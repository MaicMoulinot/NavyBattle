package com.sinkanic.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

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
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton source = (JButton) e.getSource();
		System.out.println(source.getClass().getSimpleName());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton source = (JButton) e.getSource();
		System.out.println(source.getClass().getSimpleName());
		if (e.getSource().getClass().getSimpleName().equals("GridSquare")) {
			GridSquare src = (GridSquare) e.getSource();
			src.setHoverBackground();
		}
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("GridSquare")) {
			GridSquare src = (GridSquare) e.getSource();
			src.resetBackground();
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
