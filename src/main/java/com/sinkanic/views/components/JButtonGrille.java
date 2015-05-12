/**
 * 
 */
package com.sinkanic.views.components;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author humanbooster
 *
 */
@SuppressWarnings("serial")
public abstract class JButtonGrille extends JButton {

	protected int positionX;
	protected int positionY;
	protected boolean isPlaced;
	protected boolean isPlayed;
	protected boolean isHit;
	protected static Color COULEUR_MISSED = new Color(176, 224, 230);
	protected static Color COULEUR_UNPLAYED = new Color(95, 158, 160);
	protected static Color COULEUR_ONMOUSEOVER = new Color(230, 230, 250);
	protected static Color COULEUR_ONMOUSEOVER_KO = new Color(220, 20, 60); //crimson
	protected static Color COULEUR_HIT = new Color(255, 127, 80); //coral
	protected static Color COULEUR_PLACED = new Color(189, 183, 107); //dark khaki

	/**
	 * Constructeur.
	 */
	public JButtonGrille(int positionHorizontale, int positionVerticale) {
		positionX = positionHorizontale;
		positionY = positionVerticale;
		isPlaced = false;
		isPlayed = false;
		isHit = false;
		setSize(50, 50);
		setText(positionX + "," + positionY);
		setColorUnplayed();
		setOpaque(true);
	}
	
	public void setPlayed() {
		isPlayed = true;
	}
	
	public void setColorMissed() {
		setPlayed();
		setBackground(COULEUR_MISSED);
	}
	
	public void setColorHit() {
		setPlayed();
		isHit = true;
		setBackground(COULEUR_HIT);
	}
	
	public void setColorUnplayed() {
		setBackground(COULEUR_UNPLAYED);
	}
	
	public void setColorOnMouseOver() {
		setBackground(COULEUR_ONMOUSEOVER);
	}
	
	public void setColorOnMouseOverBateauKo() {
		setBackground(COULEUR_ONMOUSEOVER_KO);
	}
	
	public void setColorPlaced() {
		isPlaced = true;
		setBackground(COULEUR_PLACED);
	}

	public boolean isPlayed() {
		return isPlayed;
	}
	
	public boolean isPlaced() {
		return isPlaced;
	}
	
	public boolean isHit() {
		return isHit;
	}
}
