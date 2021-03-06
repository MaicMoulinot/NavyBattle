package com.sinkanic.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.sinkanic.business.Cell;
import com.sinkanic.business.Game;
import com.sinkanic.business.PlayerAI;
import com.sinkanic.ships.Ship;
import com.sinkanic.views.components.JButtonGrille;
import com.sinkanic.views.components.JButtonToucheCoule;

public class FenetreToucheCoule {

	private JTextArea txtResultat;
	private JFrame frmGrille;
	private Game partie;

	protected JFrame getFrame() {
		return frmGrille;
	}

	/**
	 * @param game a com.sinkanic.business.Game
	 */
	public FenetreToucheCoule(Game game) {
		partie = game;
		partie.setFleetAI();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrille = null;
		frmGrille = new JFrame();
		frmGrille.setTitle("Joueur " + partie.getPlayer1().getName() + " - Niveau " + partie.getLevel());
		setSize();
		frmGrille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrille.getContentPane().setBackground(new Color(0, 206, 209));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 130, 0, 102, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGrille.getContentPane().setLayout(gridBagLayout);

		JTextArea lblInit = new JTextArea("Bataille navale en mode " + partie.getLevel());
		lblInit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInit.setBackground(new Color(124, 252, 0));
		GridBagConstraints gbc_lblInit = new GridBagConstraints();
		gbc_lblInit.insets = new Insets(0, 0, 5, 5);
		gbc_lblInit.gridwidth = 16;
		gbc_lblInit.gridx = 2;
		gbc_lblInit.gridy = 1;
		frmGrille.getContentPane().add(lblInit, gbc_lblInit);

		JPanel pnlTriche = new JPanel();
		pnlTriche.setBackground(new Color(124, 252, 0));
		GridLayout grdTriche = new GridLayout();
		grdTriche.setColumns(1);
		grdTriche.setRows(partie.afficheTriche().size());
		pnlTriche.setLayout(grdTriche);
		for (String triche : partie.afficheTriche()) {
			pnlTriche.add(addLabel(triche));
		}
		GridBagConstraints gbc_pnlTriche = new GridBagConstraints();
		gbc_pnlTriche.gridwidth = 16;
		gbc_pnlTriche.gridy = 2;
		gbc_pnlTriche.gridx = 2;
		frmGrille.getContentPane().add(pnlTriche, gbc_pnlTriche);

		JPanel pnlGrilleJoueur = new JPanel();
		GridLayout grdGrille = new GridLayout();
		grdGrille.setColumns(partie.getTailleGrilleHorizontal());
		grdGrille.setRows(partie.getTailleGrilleVertical());
		pnlGrilleJoueur.setLayout(grdGrille);
		for (int y = 0; y < partie.getTailleGrilleVertical(); y++) {
			for (int i = 0; i < partie.getTailleGrilleHorizontal(); i++) {
				pnlGrilleJoueur.add(addJButton(i, y));
			}
		}
		GridBagConstraints gbc_pnlGrilleJoueur = new GridBagConstraints();
		gbc_pnlGrilleJoueur.gridwidth = 16;
		gbc_pnlGrilleJoueur.gridheight = 7;
		gbc_pnlGrilleJoueur.gridy = 3;
		gbc_pnlGrilleJoueur.gridx = 1;
		frmGrille.getContentPane().add(pnlGrilleJoueur, gbc_pnlGrilleJoueur);

		txtResultat = new JTextArea();
		txtResultat.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultat.setEditable(false);
		GridBagConstraints gbc_txtResultat = new GridBagConstraints();
		gbc_txtResultat.gridwidth = 16;
		gbc_txtResultat.gridx = 2;
		gbc_txtResultat.gridy = 5;
		frmGrille.getContentPane().add(txtResultat, gbc_txtResultat);

		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setSize(100, 100);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 16;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 7;
		frmGrille.getContentPane().add(separator, gbc_separator);

		JButton btnNouvelle = new JButton();
		btnNouvelle.setToolTipText("Démarrer une nouvelle partie");
		btnNouvelle.setText("Nouvelle partie");
		btnNouvelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGrille.setVisible(false);
				frmGrille.dispose();
				FenetreChoixBateau newPartie = new FenetreChoixBateau(partie.getPlayer1().getName(), partie.getLevel());
				newPartie.getFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNouvelle = new GridBagConstraints();
		gbc_btnNouvelle.insets = new Insets(0, 0, 5, 5);
		gbc_btnNouvelle.gridx = 2;
		gbc_btnNouvelle.gridy = 8;
		frmGrille.getContentPane().add(btnNouvelle, gbc_btnNouvelle);

		JButton btnQuitter = new JButton();
		btnQuitter.setToolTipText("Revenir au menu principal");
		btnQuitter.setText("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGrille.dispose();
			}
		});
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitter.gridx = 4;
		gbc_btnQuitter.gridy = 8;
		frmGrille.getContentPane().add(btnQuitter, gbc_btnQuitter);

		JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		separator2.setSize(100, 100);
		GridBagConstraints gbc_separator2 = new GridBagConstraints();
		gbc_separator2.gridwidth = 16;
		gbc_separator2.insets = new Insets(0, 0, 5, 0);
		gbc_separator2.gridx = 0;
		gbc_separator2.gridy = 9;
		frmGrille.getContentPane().add(separator2, gbc_separator2);
	}

	/**
	 * @param x la position horizontale
	 * @param y la position verticale
	 */
	private JButtonGrille addJButton(int x, int y) {
		JButtonToucheCoule btnBouton = new JButtonToucheCoule(x, y);
		btnBouton.setName("Btn"+x+y);
		btnBouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isGameFinished = false;
				if (!partie.getPlayer1().isDead() && !partie.getPlayer2().isDead()) {
					StringBuilder resultat = new StringBuilder();
					btnBouton.setPlayed();
					// player1 plays
					switch (partie.checkGuess(partie.getPlayer1(), partie.getPlayer2(), x, y)) {
					case Ship.MISSED:
						resultat.append("Coup de " + partie.getPlayer1().getName() + ": loupé, essaye encore !!");
						btnBouton.setColorMissed();
						break;
					case Ship.DESTROYED:
						btnBouton.setColorHit();
						if (partie.getPlayer2().isDead()) {
							isGameFinished = true;
							resultat.append("Victoire en " + partie.getPlayer1().getNbEssais() + " coups "+ partie.getPlayer1().getName() + ", la classe !! Tu veux rejouer?");
							txtResultat.setBackground(new Color(255, 127, 80));
						} else {
							resultat.append("Coup de " + partie.getPlayer1().getName() + ": bravo t'as coulé un bateau, continue !!");
						}
						break;
					case Ship.HIT:
						btnBouton.setColorHit();
						resultat.append("Coup de " + partie.getPlayer1().getName() + ": t'as touché, continue !!");
						break;
					}
					// player2 plays
					if (!isGameFinished) {
						Cell randomCell = ((PlayerAI) partie.getPlayer2()).getRandomCell(partie.getTailleGrilleHorizontal(), partie.getTailleGrilleVertical());
						switch (partie.checkGuess(partie.getPlayer2(), partie.getPlayer1(), randomCell.x, randomCell.y)) {
						case Ship.MISSED:
							resultat.append("\nCoup de " + partie.getPlayer2().getName() + ": aucun de tes bateaux n'a été touché, yeah !!");
							break;
						case Ship.DESTROYED:
							if (partie.getPlayer1().isDead()) {
								resultat.append("\nCoup de " + partie.getPlayer2().getName() + ": Tu as perdu en " + partie.getPlayer2().getNbEssais() + " coups "+ partie.getPlayer1().getName() + ", t'es mauvais. Tu veux rejouer?");
								txtResultat.setBackground(new Color(255, 127, 80));
							} else {
								resultat.append("\nCoup de " + partie.getPlayer2().getName() + ": Un de tes bateaux vient de couler, " + partie.getPlayer1().getName());
							}
							break;
						case Ship.HIT:
							resultat.append("\nCoup de " + partie.getPlayer2().getName() + ": Un de tes bateaux vient d'être touché, " + partie.getPlayer1().getName());
							break;
						}
					}
					txtResultat.setText(resultat.toString());
				}
			}
		});
		return btnBouton;
	}

	private JLabel addLabel(String label) {
		JLabel retour = new JLabel(label);
		retour.setFont(new Font("Tahoma", Font.ITALIC, 10));
		retour.setHorizontalAlignment(SwingConstants.LEFT);
		return retour;
	}

	private void setSize() {
		switch (partie.getLevel()) {
		case Game.BIDON:
			frmGrille.setBounds(50, 50, 500, 250);
			break;
		default:
			frmGrille.setBounds(50, 50, 700, 600);
			break;
		}
	}
}
