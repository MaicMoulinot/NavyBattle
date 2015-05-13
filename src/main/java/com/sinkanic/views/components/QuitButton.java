/**
 * 
 */
package com.sinkanic.views.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author humanbooster
 *
 */
@SuppressWarnings("serial")
public class QuitButton extends JButton {
	
	public QuitButton() {
		setToolTipText("Quit app");
		setText("Quit");
		addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Quit button pressed");
                System.exit(0);
            }
        });
	}

}
