package interfacegraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import logic.Boat;
import logic.Cellule;
import logic.Game;
import logic.NetBattle;

public class FenetreChoixBateau {

	private String txtName; //
	private String txtDifficulte;
	private JTextArea txtResultat;
	private JPanel pnlGrilleJoueur;
	private JComboBox<String> cbbTaille;
	private JRadioButton rdbtnVertical;
	private JFrame frmGrille;
	private Game partie;

	/**
	 * @return the frmPartie
	 */
	protected JFrame getFrame() {
		return frmGrille;
	}

	public FenetreChoixBateau(String name, String niveau) {
		txtName = name;
		txtDifficulte = niveau;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrille = null;
		frmGrille = new JFrame();
		frmGrille.setTitle("Joueur " + txtName + " - Niveau " + txtDifficulte);
		setSizeFrame();
		frmGrille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrille.getContentPane().setBackground(new Color(0, 206, 209));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 130, 0, 102, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGrille.getContentPane().setLayout(gridBagLayout);

		partie = NetBattle.startGame(txtDifficulte);

		// Titre
		JTextArea txtTitre = new JTextArea("Début de la partie : place ta flotte !!");
		txtTitre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitre.setBackground(new Color(124, 252, 0));
		GridBagConstraints gbc_Titre = new GridBagConstraints();
		gbc_Titre.insets = new Insets(0, 0, 5, 0);
		gbc_Titre.gridwidth = 14;
		gbc_Titre.gridx = 1;
		gbc_Titre.gridy = 1;
		frmGrille.getContentPane().add(txtTitre, gbc_Titre);

		// Options		
		JPanel pnlOptions = new JPanel();
		pnlOptions.setBackground(new Color(255, 127, 80));
		GridLayout grdOptions = new GridLayout();
		grdOptions.setColumns(3);
		grdOptions.setRows(5);
		pnlOptions.setLayout(grdOptions);
		pnlOptions.add(new JLabel());
		pnlOptions.add(new JLabel());
		pnlOptions.add(new JLabel());

		GridBagConstraints gbc_Options = new GridBagConstraints();
		gbc_Options.insets = new Insets(0, 0, 5, 5);
		gbc_Options.gridwidth = 16;
		gbc_Options.gridheight = 2;
		gbc_Options.gridy = 2;
		gbc_Options.gridx = 0;
		
		// Radiobouton orientation
		JLabel lblOrientation = new JLabel("Orientation :  ");
		lblOrientation.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlOptions.add(lblOrientation);

		JRadioButton rdbtnHorizontal = new JRadioButton("Horizontal");
		rdbtnHorizontal.setSelected(true);
		rdbtnVertical = new JRadioButton("Vertical");

		ButtonGroup btgOrientation = new ButtonGroup();
		btgOrientation.add(rdbtnHorizontal);
		btgOrientation.add(rdbtnVertical);

		JPanel pnlOrientation = new JPanel();
		GridLayout grdOrientation = new GridLayout();
		grdOrientation.setColumns(2);
		grdOrientation.setRows(1);
		pnlOrientation.setLayout(grdOrientation);
		pnlOrientation.add(rdbtnHorizontal);
		pnlOrientation.add(rdbtnVertical);
		pnlOptions.add(pnlOrientation);
		pnlOptions.add(new JLabel());
		pnlOptions.add(new JLabel());
		pnlOptions.add(new JLabel());
		pnlOptions.add(new JLabel());

		// Choix type bateau
		JLabel lblTaille = new JLabel("Type de bateau :  ");
		lblTaille.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlOptions.add(lblTaille);
		frmGrille.getContentPane().add(pnlOptions, gbc_Options);

		cbbTaille = new JComboBox<String>();
		pnlOptions.add(cbbTaille);
		cbbTaille.setModel(new DefaultComboBoxModel<String>(new String[] {Boat.PORTE_AVION, Boat.CROISEUR, Boat.TORPILLEUR, Boat.PLANCHE_A_VOILE}));
		pnlOptions.add(new JLabel());
		
		//grille		
		pnlGrilleJoueur = new JPanel();
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
		gbc_pnlGrilleJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_pnlGrilleJoueur.gridwidth = 14;
		gbc_pnlGrilleJoueur.gridheight = 6;
		gbc_pnlGrilleJoueur.gridy = 4;
		gbc_pnlGrilleJoueur.gridx = 1;
		frmGrille.getContentPane().add(pnlGrilleJoueur, gbc_pnlGrilleJoueur);

		// Résultats
		txtResultat = new JTextArea();
		txtResultat.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultat.setEditable(false);
		GridBagConstraints gbc_txtResultat = new GridBagConstraints();
		gbc_txtResultat.insets = new Insets(0, 0, 5, 0);
		gbc_txtResultat.gridwidth = 14;
		gbc_txtResultat.gridx = 1;
		gbc_txtResultat.gridy = 9;
		frmGrille.getContentPane().add(txtResultat, gbc_txtResultat);

		// Boutons
		JButton btnValider = new JButton();
		btnValider.setToolTipText("Valider la flotte");
		btnValider.setText("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGrille.setVisible(false);
				frmGrille.dispose();
				FenetreToucheCoule partieGrille = new FenetreToucheCoule(txtName, txtDifficulte, partie);
				partieGrille.getFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_Valider = new GridBagConstraints();
		gbc_Valider.gridwidth = 3;
		gbc_Valider.insets = new Insets(0, 0, 5, 5);
		gbc_Valider.gridx = 2;
		gbc_Valider.gridy = 10;
		frmGrille.getContentPane().add(btnValider, gbc_Valider);

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
		gbc_btnQuitter.gridwidth = 3;
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitter.gridx = 10;
		gbc_btnQuitter.gridy = 10;
		frmGrille.getContentPane().add(btnQuitter, gbc_btnQuitter);

		JButton btnEffacer = new JButton();
		btnEffacer.setToolTipText("Effacer la flotte");
		btnEffacer.setText("Recommencer");
		btnEffacer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGrille.setVisible(false);
				frmGrille.dispose();
				FenetreChoixBateau nouveauChoix = new FenetreChoixBateau(txtName, txtDifficulte);
				nouveauChoix.getFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_Effacer = new GridBagConstraints();
		gbc_Effacer.gridwidth = 3;
		gbc_Effacer.insets = new Insets(0, 0, 5, 5);
		gbc_Effacer.gridx = 6;
		gbc_Effacer.gridy = 10;
		frmGrille.getContentPane().add(btnEffacer, gbc_Effacer);
	}

	/**
	 * @param x la position horizontale
	 * @param y la position verticale
	 */
	private JButtonGrille addJButton(int x, int y) {
		JButtonChoixBateau btnBouton = new JButtonChoixBateau(x, y);
		btnBouton.setName("Btn"+x+y);
		btnBouton.addMouseListener(new MouseListener() {
			private Boat bateau = null;

			@Override
			public void mouseClicked(MouseEvent e) {
				Boat bateaucree = partie.getPlayer1().addBoat(partie.getTailleGrilleHorizontal(), partie.getTailleGrilleVertical(), Boat.getTailleBateau(cbbTaille.getSelectedItem().toString()), rdbtnVertical.isSelected(), x, y);
				if (bateaucree != null) {
					txtResultat.setText("Ton bateau est placé");
					setColorBateauChosen(bateaucree);
				} else {
					txtResultat.setText("");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				bateau = tryBoat();
				if (bateau != null) {
					setColorBateauOnMouseOver(bateau);
				} else {
					btnBouton.setColorOnMouseOverBateauKo();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bateau = tryBoat();
				if (btnBouton.isPlaced()) {
					btnBouton.setColorPlaced();
				} else {
					if (bateau != null) {
						setColorUnplaced(bateau);
					} else {
						btnBouton.setColorUnplayed();
					}
				}
			}
			
			private Boat tryBoat() {
				return bateau = partie.getPlayer1().tryBoat(partie.getTailleGrilleHorizontal(), partie.getTailleGrilleVertical(), Boat.getTailleBateau(cbbTaille.getSelectedItem().toString()), rdbtnVertical.isSelected(), x, y);
			}
			
		});
		return btnBouton;
	}

	private void setSizeFrame() {
		switch (txtDifficulte) {
		case Game.BIDON:
			frmGrille.setBounds(50, 50, 500, 250);
			break;
		default:
			frmGrille.setBounds(50, 50, 700, 600);
			break;
		}
	}
	
	private void setColorBateauChosen(Boat bateau) {
		for (Cellule cellule : bateau.getPositions()) {
			JButtonGrille bouton = (JButtonGrille) pnlGrilleJoueur.getComponent(findPosition(cellule.getPositionHorizontal(), cellule.getPositionVertical()));
			bouton.setColorPlaced();
		}
	}
	
	private void setColorBateauOnMouseOver(Boat bateau) {
		for (Cellule cellule : bateau.getPositions()) {
			JButtonGrille bouton = (JButtonGrille) pnlGrilleJoueur.getComponent(findPosition(cellule.getPositionHorizontal(), cellule.getPositionVertical()));
			bouton.setColorOnMouseOver();
		}
	}
	
	private void setColorUnplaced(Boat bateau) {
		for (Cellule cellule : bateau.getPositions()) {
			JButtonGrille bouton = (JButtonGrille) pnlGrilleJoueur.getComponent(findPosition(cellule.getPositionHorizontal(), cellule.getPositionVertical()));
			if (!bouton.isPlaced()) {
				bouton.setColorUnplayed();
			}
		}
	}
	
	private int findPosition(int positionX, int positionY) {
		int resultat = 0;
		for (int j = 0; j < partie.getTailleGrilleVertical(); j++) {
			for (int i = 0; i < partie.getTailleGrilleHorizontal(); i++) {
				if (i == positionX && j == positionY) {
					return resultat;
				} else {
					resultat++;
				}
			}
		}
		return resultat;
	}
}
