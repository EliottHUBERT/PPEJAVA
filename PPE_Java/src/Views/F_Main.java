package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JMenu;
import com.toedter.calendar.JCalendar;
import com.toedter.plaf.JCalendarTheme;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class F_Main extends JFrame {

	private JPanel contentPane;
	private JTable TableRDV;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneRDV;
	private JLabel lblNomUtilisateur;
	private JLabel lblNbRDV;
	private JLabel lblNbCR;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnIllisible;
	private JRadioButton rdbtnPeuLisible;
	private JRadioButton rdbtnLisible;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnConfiant;
	private JRadioButton rdbtnRticent;
	private JRadioButton rdbtnPeuConfiant;
	private JComboBox comboBoxCR_RDV;
	private JComboBox comboBoxCR_Visiteur;
	private JComboBox comboBoxCR_Medecin;
	private JButton btnValider;
	private JTabbedPane tabbedPane_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNouvelUtilisateur;
	private JLabel lblUtilisateurExistant;
	private JComboBox comboBoxOldUser;
	private JLabel lblLogin;
	private JLabel lblMotDePasse;
	private JLabel lblRle;
	private JTextField textFieldOldUserLogin;
	private JPasswordField passwordFieldOldUserPassword;
	private JPasswordField passwordFieldNewUserPassword;
	private JTextField textFieldNewUserLogin;
	private JPanel panel_8;
	private JLabel lblNouveauxRendezvous;
	private JLabel lblLogin_2;
	private JLabel lblMotDePasse_2;
	private JTextField textFieldNomNvxRDV;
	private JButton btnValiderNvxRDV;
	private JPanel panel_9;
	private JLabel lblEndezvousExistant;
	private JComboBox comboBoxOldRDV;
	private JLabel nomOldRDV;
	private JTextField NewNomOldRDV;
	private JButton btnValiderOldRDV;
	private JLabel lblVisiteur_1;
	private JLabel lblMdecin_1;
	private JComboBox comboBoxVisiteurNvxRDV;
	private JComboBox comboBoxMedecinNvxRDV;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JRadioButton rdbtnNewUserAdmin;
	private JRadioButton rdbtnNewUserVisiteur;
	private JButton btnNewUserValidate;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JRadioButton rdbtnOldUserVisiteur;
	private JRadioButton rdbtnOldUserAdmin;
	private JButton btnOldUserValidate;
	private JLabel lblId;
	private JTextField textFieldOldUserId;
	private JCalendar calendarNvxRDV;
	private JTextArea textAreaProbleme;
	private JTable tableCR;
	private JPanel panel_1;
	private JButton btnValidCRMod;
	private JButton btnCancelCRMod;
	private JLabel lblModText;
	private JComboBox comboBoxVisiteurOldRDV;
	private JComboBox comboBoxMedecinOldRDV;
	private JCalendar calendarOldRDV;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JLabel lblModText_1;
	private JTable tableAllRDV;
	private JTable tableAllCR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Main frame = new F_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public F_Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Header = new JPanel();
		contentPane.add(Header, BorderLayout.NORTH);
		Header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		Header.add(lblUtilisateur);
		lblUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblNomUtilisateur = new JLabel("");
		lblNomUtilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
		Header.add(lblNomUtilisateur);
		
		Component verticalGlue = Box.createVerticalGlue();
		Header.add(verticalGlue);
		
		JLabel lblNombreDeRendezvous = new JLabel("Nombre de rendez-vous:");
		Header.add(lblNombreDeRendezvous);
		
		lblNbRDV = new JLabel("");
		Header.add(lblNbRDV);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		Header.add(verticalGlue_1);
		
		JLabel lblNombreDeCompterendu = new JLabel("Nombre de compte-rendu:");
		Header.add(lblNombreDeCompterendu);
		
		lblNbCR = new JLabel("");
		Header.add(lblNbCR);
		
		JPanel Body = new JPanel();
		contentPane.add(Body, BorderLayout.CENTER);
		Body.setLayout(new CardLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Body.add(tabbedPane, "name_245224634474");
		
		scrollPaneRDV = new JScrollPane();
		tabbedPane.addTab("Rendez-vous", null, scrollPaneRDV, null);
		
		TableRDV = new JTable();
		TableRDV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null}
			},
			new String[] {
				"ID", "Nom", "Date", "M\u00E9decin", "Adresse"
			}
		));
		TableRDV.getColumnModel().getColumn(0).setPreferredWidth(15);
		scrollPaneRDV.setViewportView(TableRDV);
		
		JPanel CompteRendu = new JPanel();
		tabbedPane.addTab("Compte-rendu", null, CompteRendu, null);
		CompteRendu.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		CompteRendu.add(tabbedPane_2, "name_3788211434298");
		
		JPanel panel = new JPanel();
		tabbedPane_2.addTab("Nouveau compte-rendu", null, panel, null);
		panel.setLayout(null);
		
		comboBoxCR_RDV = new JComboBox();
		comboBoxCR_RDV.setBounds(238, 59, 140, 26);
		panel.add(comboBoxCR_RDV);
		comboBoxCR_RDV.setModel(new DefaultComboBoxModel(new String[] {" Default"}));
		
		JLabel lblRendezvous = new JLabel("Rendez-vous :");
		lblRendezvous.setBounds(236, 30, 90, 17);
		panel.add(lblRendezvous);
		
		comboBoxCR_Visiteur = new JComboBox();
		comboBoxCR_Visiteur.setBounds(407, 59, 140, 26);
		panel.add(comboBoxCR_Visiteur);
		
		JLabel lblVisiteur = new JLabel("Visiteur :");
		lblVisiteur.setBounds(410, 30, 59, 17);
		panel.add(lblVisiteur);
		
		comboBoxCR_Medecin = new JComboBox();
		comboBoxCR_Medecin.setBounds(575, 59, 140, 26);
		panel.add(comboBoxCR_Medecin);
		comboBoxCR_Medecin.setModel(new DefaultComboBoxModel(new String[] {"Default"}));
		
		JLabel lblMdecin = new JLabel("Médecin :");
		lblMdecin.setBounds(575, 30, 59, 17);
		panel.add(lblMdecin);
		
		textAreaProbleme = new JTextArea();
		textAreaProbleme.setBounds(251, 297, 383, 104);
		panel.add(textAreaProbleme);
		
		JLabel lblConfiance = new JLabel("Confiance :");
		lblConfiance.setBounds(236, 121, 90, 17);
		panel.add(lblConfiance);
		
		JLabel lblLisibilit = new JLabel("Lisibilité :");
		lblLisibilit.setBounds(410, 121, 84, 17);
		panel.add(lblLisibilit);
		
		rdbtnConfiant = new JRadioButton("Confiant");
		rdbtnConfiant.setBounds(236, 146, 130, 25);
		panel.add(rdbtnConfiant);
		buttonGroup_1.add(rdbtnConfiant);
		
		rdbtnPeuConfiant = new JRadioButton("Peu Confiant");
		rdbtnPeuConfiant.setBounds(238, 175, 130, 25);
		panel.add(rdbtnPeuConfiant);
		buttonGroup_1.add(rdbtnPeuConfiant);
		
		rdbtnRticent = new JRadioButton("Réticent");
		rdbtnRticent.setBounds(238, 204, 130, 25);
		panel.add(rdbtnRticent);
		buttonGroup_1.add(rdbtnRticent);
		
		rdbtnLisible = new JRadioButton("Lisible");
		rdbtnLisible.setBounds(407, 146, 130, 25);
		panel.add(rdbtnLisible);
		buttonGroup.add(rdbtnLisible);
		
		rdbtnPeuLisible = new JRadioButton("Peu Lisible");
		rdbtnPeuLisible.setBounds(407, 175, 130, 25);
		panel.add(rdbtnPeuLisible);
		buttonGroup.add(rdbtnPeuLisible);
		
		rdbtnIllisible = new JRadioButton("Illisible");
		rdbtnIllisible.setBounds(407, 204, 130, 25);
		panel.add(rdbtnIllisible);
		buttonGroup.add(rdbtnIllisible);
		
		JLabel lblProblme = new JLabel("Problème :");
		lblProblme.setBounds(251, 268, 90, 17);
		panel.add(lblProblme);
		
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValider.setBounds(769, 310, 103, 27);
		panel.add(btnValider);
		
		panel_1 = new JPanel();
		tabbedPane_2.addTab("Mes compte-rendus", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1074, 358);
		panel_1.add(scrollPane);
		
		tableCR = new JTable();
		tableCR.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID Compte-rendu", "Visiteur", "M\u00E9decin", "Confiance", "Lisibilit\u00E9", "Probl\u00E8mes"
			}
		));
		tableCR.getColumnModel().getColumn(0).setPreferredWidth(98);
		scrollPane.setViewportView(tableCR);
		
		btnValidCRMod = new JButton("Modifier");
		btnValidCRMod.setBounds(590, 403, 103, 27);
		panel_1.add(btnValidCRMod);
		
		btnCancelCRMod = new JButton("Annuler");
		btnCancelCRMod.setBounds(415, 403, 103, 27);
		panel_1.add(btnCancelCRMod);
		
		lblModText = new JLabel("");
		lblModText.setBounds(182, 370, 757, 17);
		panel_1.add(lblModText);
		
		Panel Admin = new Panel();
		tabbedPane.addTab("Administrateur", null, Admin, null);
		Admin.setLayout(new CardLayout(0, 0));
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		Admin.add(tabbedPane_1, "name_795027889946");
		
		panel_4 = new JPanel();
		tabbedPane_1.addTab("Gestion de rendez-vous", null, panel_4, null);
		panel_4.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_8.setLayout(null);
		panel_8.setBounds(0, 0, 532, 442);
		panel_4.add(panel_8);
		
		lblNouveauxRendezvous = new JLabel("Nouveaux rendez-vous:");
		lblNouveauxRendezvous.setBounds(203, 12, 163, 17);
		panel_8.add(lblNouveauxRendezvous);
		
		lblLogin_2 = new JLabel("Nom:");
		lblLogin_2.setBounds(12, 49, 59, 17);
		panel_8.add(lblLogin_2);
		
		lblMotDePasse_2 = new JLabel("Date:");
		lblMotDePasse_2.setBounds(12, 111, 107, 17);
		panel_8.add(lblMotDePasse_2);
		
		textFieldNomNvxRDV = new JTextField();
		textFieldNomNvxRDV.setColumns(10);
		textFieldNomNvxRDV.setBounds(12, 78, 233, 21);
		panel_8.add(textFieldNomNvxRDV);
		
		btnValiderNvxRDV = new JButton("Valider");
		btnValiderNvxRDV.setBounds(203, 403, 103, 27);
		panel_8.add(btnValiderNvxRDV);
		
		lblVisiteur_1 = new JLabel("Visiteur:");
		lblVisiteur_1.setBounds(12, 312, 59, 17);
		panel_8.add(lblVisiteur_1);
		
		lblMdecin_1 = new JLabel("Médecin:");
		lblMdecin_1.setBounds(356, 312, 59, 17);
		panel_8.add(lblMdecin_1);
		
		comboBoxVisiteurNvxRDV = new JComboBox();
		comboBoxVisiteurNvxRDV.setBounds(12, 341, 163, 27);
		panel_8.add(comboBoxVisiteurNvxRDV);
		
		comboBoxMedecinNvxRDV = new JComboBox();
		comboBoxMedecinNvxRDV.setBounds(310, 341, 163, 27);
		panel_8.add(comboBoxMedecinNvxRDV);
		
		calendarNvxRDV = new JCalendar();
		calendarNvxRDV.getDayChooser().getDayPanel().setBorder(new EmptyBorder(1, 1, 1, 1));
		calendarNvxRDV.setBorder(new EmptyBorder(1, 1, 1, 1));
		calendarNvxRDV.setTodayButtonVisible(true);
		calendarNvxRDV.setTodayButtonText("Aujourd'hui");
		calendarNvxRDV.setBounds(12, 129, 228, 175);
		panel_8.add(calendarNvxRDV);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(532, 0, 542, 442);
		panel_4.add(panel_9);
		
		lblEndezvousExistant = new JLabel("Rendez-vous existant:");
		lblEndezvousExistant.setBounds(203, 12, 138, 17);
		panel_9.add(lblEndezvousExistant);
		
		comboBoxOldRDV = new JComboBox();
		comboBoxOldRDV.setBounds(181, 41, 191, 26);
		panel_9.add(comboBoxOldRDV);
		
		nomOldRDV = new JLabel("Nom:");
		nomOldRDV.setBounds(12, 79, 59, 17);
		panel_9.add(nomOldRDV);
		
		NewNomOldRDV = new JTextField();
		NewNomOldRDV.setColumns(10);
		NewNomOldRDV.setBounds(12, 100, 233, 21);
		panel_9.add(NewNomOldRDV);
		
		btnValiderOldRDV = new JButton("Valider");
		btnValiderOldRDV.setBounds(198, 403, 103, 27);
		panel_9.add(btnValiderOldRDV);
		
		calendarOldRDV = new JCalendar();
		calendarOldRDV.getDayChooser().getDayPanel().setBorder(new EmptyBorder(1, 1, 1, 1));
		calendarOldRDV.setTodayButtonVisible(true);
		calendarOldRDV.setTodayButtonText("Aujourd'hui");
		calendarOldRDV.setBorder(new EmptyBorder(1, 1, 1, 1));
		calendarOldRDV.setBounds(12, 151, 228, 175);
		panel_9.add(calendarOldRDV);
		
		JLabel lblDAteOldRDV = new JLabel("Date:");
		lblDAteOldRDV.setBounds(12, 133, 107, 17);
		panel_9.add(lblDAteOldRDV);
		
		JLabel lblVisiteurOldRDV = new JLabel("Visiteur:");
		lblVisiteurOldRDV.setBounds(12, 338, 59, 17);
		panel_9.add(lblVisiteurOldRDV);
		
		comboBoxVisiteurOldRDV = new JComboBox();
		comboBoxVisiteurOldRDV.setBounds(12, 367, 163, 27);
		panel_9.add(comboBoxVisiteurOldRDV);
		
		comboBoxMedecinOldRDV = new JComboBox();
		comboBoxMedecinOldRDV.setBounds(310, 367, 163, 27);
		panel_9.add(comboBoxMedecinOldRDV);
		
		JLabel lblMdecinOldRDV = new JLabel("Médecin:");
		lblMdecinOldRDV.setBounds(356, 338, 59, 17);
		panel_9.add(lblMdecinOldRDV);
		
		panel_5 = new JPanel();
		tabbedPane_1.addTab("Gestion d'utilisateur", null, panel_5, null);
		panel_5.setLayout(null);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		panel_6.setBounds(0, 0, 532, 442);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		lblNouvelUtilisateur = new JLabel("Nouvel utilisateur:");
		lblNouvelUtilisateur.setBounds(203, 12, 163, 17);
		panel_6.add(lblNouvelUtilisateur);
		
		JLabel lblLogin_1 = new JLabel("Login:");
		lblLogin_1.setBounds(12, 74, 59, 17);
		panel_6.add(lblLogin_1);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe:");
		lblMotDePasse_1.setBounds(12, 135, 107, 17);
		panel_6.add(lblMotDePasse_1);
		
		rdbtnNewUserAdmin = new JRadioButton("Admin");
		buttonGroup_2.add(rdbtnNewUserAdmin);
		rdbtnNewUserAdmin.setBounds(12, 256, 130, 25);
		panel_6.add(rdbtnNewUserAdmin);
		
		rdbtnNewUserVisiteur = new JRadioButton("Visiteur");
		rdbtnNewUserVisiteur.setSelected(true);
		buttonGroup_2.add(rdbtnNewUserVisiteur);
		rdbtnNewUserVisiteur.setBounds(12, 227, 130, 25);
		panel_6.add(rdbtnNewUserVisiteur);
		
		JLabel lblRle_1 = new JLabel("Rôle:");
		lblRle_1.setBounds(12, 193, 59, 17);
		panel_6.add(lblRle_1);
		
		passwordFieldNewUserPassword = new JPasswordField();
		passwordFieldNewUserPassword.setBounds(12, 164, 233, 21);
		panel_6.add(passwordFieldNewUserPassword);
		
		textFieldNewUserLogin = new JTextField();
		textFieldNewUserLogin.setColumns(10);
		textFieldNewUserLogin.setBounds(12, 103, 233, 21);
		panel_6.add(textFieldNewUserLogin);
		
		btnNewUserValidate = new JButton("Valider");
		btnNewUserValidate.setBounds(203, 341, 103, 27);
		panel_6.add(btnNewUserValidate);
		
		panel_7 = new JPanel();
		panel_7.setBounds(532, 0, 542, 442);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		lblUtilisateurExistant = new JLabel("Utilisateur existant:");
		lblUtilisateurExistant.setBounds(203, 12, 138, 17);
		panel_7.add(lblUtilisateurExistant);
		
		comboBoxOldUser = new JComboBox();
		comboBoxOldUser.setBounds(181, 41, 191, 26);
		panel_7.add(comboBoxOldUser);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(12, 97, 59, 17);
		panel_7.add(lblLogin);
		
		lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setBounds(12, 151, 96, 17);
		panel_7.add(lblMotDePasse);
		
		lblRle = new JLabel("Rôle:");
		lblRle.setBounds(12, 212, 59, 17);
		panel_7.add(lblRle);
		
		textFieldOldUserLogin = new JTextField();
		textFieldOldUserLogin.setBounds(12, 118, 233, 21);
		panel_7.add(textFieldOldUserLogin);
		textFieldOldUserLogin.setColumns(10);
		
		passwordFieldOldUserPassword = new JPasswordField();
		passwordFieldOldUserPassword.setBounds(12, 179, 233, 21);
		panel_7.add(passwordFieldOldUserPassword);
		
		rdbtnOldUserVisiteur = new JRadioButton("Visiteur");
		buttonGroup_3.add(rdbtnOldUserVisiteur);
		rdbtnOldUserVisiteur.setBounds(12, 246, 130, 25);
		panel_7.add(rdbtnOldUserVisiteur);
		
		rdbtnOldUserAdmin = new JRadioButton("Admin");
		buttonGroup_3.add(rdbtnOldUserAdmin);
		rdbtnOldUserAdmin.setBounds(12, 275, 130, 25);
		panel_7.add(rdbtnOldUserAdmin);
		
		btnOldUserValidate = new JButton("Valider");
		btnOldUserValidate.setBounds(235, 341, 103, 27);
		panel_7.add(btnOldUserValidate);
		
		lblId = new JLabel("Id:");
		lblId.setBounds(356, 97, 59, 17);
		panel_7.add(lblId);
		
		textFieldOldUserId = new JTextField();
		textFieldOldUserId.setEditable(false);
		textFieldOldUserId.setBounds(356, 118, 75, 21);
		panel_7.add(textFieldOldUserId);
		textFieldOldUserId.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane_1.addTab("Rendez-vous", null, panel_2, null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1074, 358);
		panel_2.add(scrollPane_1);
		
		tableAllRDV = new JTable();
		tableAllRDV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(tableAllRDV);
		
		lblModText_1 = new JLabel("");
		lblModText_1.setBounds(182, 370, 757, 17);
		panel_2.add(lblModText_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		tabbedPane_1.addTab("Compte Rendus", null, panel_1_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 1074, 358);
		panel_1_1.add(scrollPane_2);
		
		tableAllCR = new JTable();
		tableAllCR.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_2.setViewportView(tableAllCR);
		
		JLabel lblModText_2 = new JLabel("");
		lblModText_2.setBounds(182, 370, 757, 17);
		panel_1_1.add(lblModText_2);
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public JScrollPane getScrollPaneRDV() {
		return scrollPaneRDV;
	}
	public JTable getTableRDV() {
		return TableRDV;
	}
	public JLabel getLblNomUtilisateur() {
		return lblNomUtilisateur;
	}
	public JLabel getLblNbRDV() {
		return lblNbRDV;
	}
	public JLabel getLblNbCR() {
		return lblNbCR;
	}
	public JRadioButton getRdbtnIllisible() {
		return rdbtnIllisible;
	}
	public JRadioButton getRdbtnPeuLisible() {
		return rdbtnPeuLisible;
	}
	public JRadioButton getRdbtnLisible() {
		return rdbtnLisible;
	}
	public JRadioButton getRdbtnConfiant() {
		return rdbtnConfiant;
	}
	public JRadioButton getRdbtnRticent() {
		return rdbtnRticent;
	}
	public JRadioButton getRdbtnPeuConfiant() {
		return rdbtnPeuConfiant;
	}
	public JComboBox getComboBoxCR_RDV() {
		return comboBoxCR_RDV;
	}
	public JComboBox getComboBoxCR_Visiteur() {
		return comboBoxCR_Visiteur;
	}
	public JComboBox getComboBoxCR_Medecin() {
		return comboBoxCR_Medecin;
	}
	public JButton getBtnValider() {
		return btnValider;
	}
	public JTextField getTextFieldNewUserLogin() {
		return textFieldNewUserLogin;
	}
	public JPasswordField getPasswordFieldNewUserPassword() {
		return passwordFieldNewUserPassword;
	}
	public JRadioButton getRdbtnNewUserAdmin() {
		return rdbtnNewUserAdmin;
	}
	public JRadioButton getRdbtnNewUserVisiteur() {
		return rdbtnNewUserVisiteur;
	}
	public JButton getBtnNewUserValidate() {
		return btnNewUserValidate;
	}
	public JRadioButton getRdbtnOldUserVisiteur() {
		return rdbtnOldUserVisiteur;
	}
	public JRadioButton getRdbtnOldUserAdmin() {
		return rdbtnOldUserAdmin;
	}
	public JButton getBtnOldUserValidate() {
		return btnOldUserValidate;
	}
	public JPasswordField getPasswordFieldOldUserPassword() {
		return passwordFieldOldUserPassword;
	}
	public JTextField getTextFieldOldUserLogin() {
		return textFieldOldUserLogin;
	}
	public JComboBox getComboBoxOldUser() {
		return comboBoxOldUser;
	}
	public JTextField getTextFieldOldUserId() {
		return textFieldOldUserId;
	}
	public JTextField getTextFieldNomNvxRDV() {
		return textFieldNomNvxRDV;
	}
	public JComboBox getComboBoxVisiteurNvxRDV() {
		return comboBoxVisiteurNvxRDV;
	}
	public JButton getBtnValiderNvxRDV() {
		return btnValiderNvxRDV;
	}
	public JComboBox getComboBoxMedecinNvxRDV() {
		return comboBoxMedecinNvxRDV;
	}
	public JCalendar getCalendarNvxRDV() {
		return calendarNvxRDV;
	}
	public JComboBox getComboBoxOldRDV() {
		return comboBoxOldRDV;
	}
	public JTextArea getTextAreaProbleme() {
		return textAreaProbleme;
	}
	public JTable getTableCR() {
		return tableCR;
	}
	public JButton getBtnValidCRMod() {
		return btnValidCRMod;
	}
	public JButton getBtnCancelCRMod() {
		return btnCancelCRMod;
	}
	public JLabel getLblModText() {
		return lblModText;
	}
	public JTextField getNewNomOldRDV() {
		return NewNomOldRDV;
	}
	public JComboBox getComboBoxVisiteurOldRDV() {
		return comboBoxVisiteurOldRDV;
	}
	public JComboBox getComboBoxMedecinOldRDV() {
		return comboBoxMedecinOldRDV;
	}
	public JCalendar getCalendarOldRDV() {
		return calendarOldRDV;
	}
	public JButton getBtnValiderOldRDV() {
		return btnValiderOldRDV;
	}
	public JTable getTableAllRDV() {
		return tableAllRDV;
	}
	public JTable getTableAllCR() {
		return tableAllCR;
	}
}
