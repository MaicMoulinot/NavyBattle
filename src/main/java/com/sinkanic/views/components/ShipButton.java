package com.sinkanic.views.components;

import java.awt.Color;

import javax.swing.JButton;

public class ShipButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1097918600107774202L;

	public ShipButton(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		//addMouseListener(this);
	}
}
