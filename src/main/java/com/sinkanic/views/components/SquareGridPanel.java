package com.sinkanic.views.components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.sinkanic.controllers.LayShipsController;

public class SquareGridPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5757260606081498040L;

	public SquareGridPanel(LayShipsController controller) {
		setLayout(new GridBagLayout());
		populatePanel(controller);
	}
	
	private void populatePanel(LayShipsController controller){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;

		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				GridSquare square = new GridSquare(i, j);
				square.addMouseListener(controller);
				gbc.gridx = i + 1;
				gbc.gridy = j + 1;
				
				add(square, gbc);
			}
		}
	}

}
