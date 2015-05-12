package interfacegraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logic.Game;

public class FenetreDemarrage {

	private JFrame frmBatailleNavale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreDemarrage window = new FenetreDemarrage();
					window.frmBatailleNavale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreDemarrage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatailleNavale = new JFrame();
		frmBatailleNavale.getContentPane().setBackground(new Color(0, 206, 209));
		frmBatailleNavale.setTitle("Bataille navale");
		frmBatailleNavale.setBounds(300, 300, 425, 226);
		frmBatailleNavale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmBatailleNavale.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblBienvenue = new JLabel("Bienvenue sur la meilleure bataille navale au monde !!");
		lblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblBienvenue = new GridBagConstraints();
		gbc_lblBienvenue.gridwidth = 5;
		gbc_lblBienvenue.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenue.anchor = GridBagConstraints.CENTER;
		gbc_lblBienvenue.gridx = 1;
		gbc_lblBienvenue.gridy = 2;
		frmBatailleNavale.getContentPane().add(lblBienvenue, gbc_lblBienvenue);
		
		JSeparator sepSeparation = new JSeparator(SwingConstants.VERTICAL);
		sepSeparation.setSize(100, 100);
		GridBagConstraints gbc_btnSeparation = new GridBagConstraints();
		gbc_btnSeparation.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeparation.gridwidth = 3;
		gbc_btnSeparation.gridx = 2;
		gbc_btnSeparation.gridy = 3;
		frmBatailleNavale.getContentPane().add(sepSeparation, gbc_btnSeparation);
		
		JLabel lblNom = new JLabel("Nom :");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		frmBatailleNavale.getContentPane().add(lblNom, gbc_lblNom);
		
		JTextField txtName = new JTextField();
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 2;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 4;
		frmBatailleNavale.getContentPane().add(txtName, gbc_txtName);
		
		JLabel lblDifficulte = new JLabel("Difficulté :");
		GridBagConstraints gbc_lblDifficulte = new GridBagConstraints();
		gbc_lblDifficulte.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifficulte.anchor = GridBagConstraints.EAST;
		gbc_lblDifficulte.gridx = 1;
		gbc_lblDifficulte.gridy = 5;
		frmBatailleNavale.getContentPane().add(lblDifficulte, gbc_lblDifficulte);
		
		JComboBox<String> cbbDifficulte = new JComboBox<String>();
		DefaultComboBoxModel<String> listeDifficulte = new DefaultComboBoxModel<String>();
		listeDifficulte.addElement(Game.BIDON);
		listeDifficulte.addElement(Game.FACILE);
		listeDifficulte.addElement(Game.TROP_DUR);
		cbbDifficulte.setModel(listeDifficulte);
		cbbDifficulte.setToolTipText("Tu veux galérer ou pas?");
		cbbDifficulte.setMaximumRowCount(3);
		GridBagConstraints gbc_cbbDifficulte = new GridBagConstraints();
		gbc_cbbDifficulte.gridwidth = 2;
		gbc_cbbDifficulte.insets = new Insets(0, 0, 5, 5);
		gbc_cbbDifficulte.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbDifficulte.gridx = 2;
		gbc_cbbDifficulte.gridy = 5;
		frmBatailleNavale.getContentPane().add(cbbDifficulte, gbc_cbbDifficulte);
		
		JSeparator sepSeparation1 = new JSeparator(SwingConstants.VERTICAL);
		sepSeparation1.setSize(100, 100);
		GridBagConstraints gbc_btnSeparation1 = new GridBagConstraints();
		gbc_btnSeparation1.gridheight = 8;
		gbc_btnSeparation1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeparation1.gridx = 0;
		gbc_btnSeparation1.gridy = 0;
		frmBatailleNavale.getContentPane().add(sepSeparation1, gbc_btnSeparation1);
		
		JLabel lblDemarrer = new JLabel("C'est parti?");
		GridBagConstraints gbc_lblDemarrer = new GridBagConstraints();
		gbc_lblDemarrer.insets = new Insets(0, 0, 0, 5);
		gbc_lblDemarrer.gridx = 1;
		gbc_lblDemarrer.gridy = 7;
		frmBatailleNavale.getContentPane().add(lblDemarrer, gbc_lblDemarrer);
		
		JButton btnDemarrer = new JButtonDemarrer();
		btnDemarrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//FenetreToucheCoule partie = new FenetreToucheCoule(txtName.getText(), cbbDifficulte.getSelectedItem().toString());
				FenetreChoixBateau partie = new FenetreChoixBateau(txtName.getText(), cbbDifficulte.getSelectedItem().toString());
				//FenetrePartie partie = new FenetrePartie(txtName.getText(), cbbDifficulte.getSelectedItem().toString());
				partie.getFrame().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnDemarrer = new GridBagConstraints();
		gbc_btnDemarrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnDemarrer.gridx = 2;
		gbc_btnDemarrer.gridy = 7;
		frmBatailleNavale.getContentPane().add(btnDemarrer, gbc_btnDemarrer);
		
		JButton btnQuitterApp = new JButtonQuitter();
		btnQuitterApp.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuitterApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmBatailleNavale.dispose();
			}
		});
		GridBagConstraints gbc_btnQuitterApp = new GridBagConstraints();
		gbc_btnQuitterApp.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitterApp.gridx = 3;
		gbc_btnQuitterApp.gridy = 7;
		frmBatailleNavale.getContentPane().add(btnQuitterApp, gbc_btnQuitterApp);
	}
}
