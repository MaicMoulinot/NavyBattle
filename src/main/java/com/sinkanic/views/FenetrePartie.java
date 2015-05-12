package com.sinkanic.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.sinkanic.business.Game;
import com.sinkanic.views.components.JButtonDemarrer;
import com.sinkanic.views.components.JButtonQuitter;

public class FenetrePartie {

	private String txtName;
	private String txtDifficulte;
	private JFrame frmPartie;
	
	protected JFrame getFrame() {
		return frmPartie;
	}
	
	/**
	 * @param name a String the player's name
	 * @param niveau a String the level
	 */
	public FenetrePartie(String name, String niveau) {
		txtName = name;
		txtDifficulte = niveau;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPartie = null;
		frmPartie = new JFrame();
		frmPartie.setTitle("Joueur " + txtName + " - Niveau " + txtDifficulte);
		frmPartie.setBounds(50, 50, 450, 300);
		frmPartie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 130, 0, 102, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmPartie.getContentPane().setLayout(gridBagLayout);

		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setSize(100, 100);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 7;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 0;
		frmPartie.getContentPane().add(separator, gbc_separator);

		Game partie = new Game(txtDifficulte);
		JLabel lblInit = new JLabel("Démarrage d'une partie de niveau " + txtDifficulte);
		lblInit.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblInit = new GridBagConstraints();
		gbc_lblInit.insets = new Insets(0, 0, 5, 5);
		gbc_lblInit.gridwidth = 4;
		gbc_lblInit.gridx = 2;
		gbc_lblInit.gridy = 1;
		frmPartie.getContentPane().add(lblInit, gbc_lblInit);
		
		TextArea textTriche = new TextArea();
		textTriche.setFont(new Font("Tahoma", Font.ITALIC, 11));
		for (String essai : partie.play()) {
			textTriche.append(essai + "\n");
		}
		textTriche.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 2;
		frmPartie.getContentPane().add(textTriche, gbc_textArea);

		JSeparator sepSeparation = new JSeparator(SwingConstants.VERTICAL);
		sepSeparation.setSize(100, 100);
		GridBagConstraints gbc_btnSeparation = new GridBagConstraints();
		gbc_btnSeparation.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeparation.gridwidth = 3;
		gbc_btnSeparation.gridx = 2;
		gbc_btnSeparation.gridy = 3;
		frmPartie.getContentPane().add(sepSeparation, gbc_btnSeparation);

		JButton btnNouvelle = new JButtonDemarrer();
		btnNouvelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmPartie.setVisible(false);
				frmPartie.dispose();
				FenetrePartie partie = new FenetrePartie(txtName, txtDifficulte);
				partie.getFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNouvelle = new GridBagConstraints();
		gbc_btnNouvelle.insets = new Insets(0, 0, 5, 5);
		gbc_btnNouvelle.gridx = 2;
		gbc_btnNouvelle.gridy = 5;
		frmPartie.getContentPane().add(btnNouvelle, gbc_btnNouvelle);

		JButton btnQuitter = new JButtonQuitter();
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmPartie.dispose();
			}
		});
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitter.gridx = 4;
		gbc_btnQuitter.gridy = 5;
		frmPartie.getContentPane().add(btnQuitter, gbc_btnQuitter);
		
		JSeparator sepSeparation2 = new JSeparator(SwingConstants.VERTICAL);
		sepSeparation2.setSize(100, 100);
		GridBagConstraints gbc_btnSeparation2 = new GridBagConstraints();
		gbc_btnSeparation2.insets = new Insets(0, 0, 0, 5);
		gbc_btnSeparation2.gridwidth = 3;
		gbc_btnSeparation2.gridx = 2;
		gbc_btnSeparation2.gridy = 6;
		frmPartie.getContentPane().add(sepSeparation2, gbc_btnSeparation2);
	}
}
