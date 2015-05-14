package com.sinkanic.views.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GridSquare extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8319722036980247004L;

	private LineBorder	blackBorder;
	private LineBorder	redBorder;
	private Color		defaultBackgroundColor;
	private int			gridX;
	private int			gridY;

	public GridSquare(int x, int y) {
		gridX = x;
		gridY = y;
		blackBorder = new LineBorder(Color.BLACK);
		redBorder = new LineBorder(Color.RED);
		defaultBackgroundColor = new Color(getBackground().getRGB());

		setPreferredSize(new Dimension(40, 40));
		setBorder(blackBorder);
		setOpaque(true);
	}
	
	public void setHoverBackground() {
		setBackground(Color.DARK_GRAY);
		setBorder(redBorder);
	}
	
	public void resetBackground() {
		setBackground(defaultBackgroundColor);
		setBorder(blackBorder);
	}
	
	public int getGridX() {
		return (gridX);
	}
	
	public int getGridY() {
		return (gridY);
	}	
	
	@Override
	public String toString() {
		String identity = "GridSquare: (" + gridX + "," + gridY + ")";
		return (identity);
	}
}
