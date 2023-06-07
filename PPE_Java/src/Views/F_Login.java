package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class F_Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField textFieldPassword;
	private JTextField textFieldLogin;
	private JButton btnConnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Login frame = new F_Login();
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
	public F_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(30, 50, 59, 17);
		contentPane.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(30, 100, 95, 17);
		contentPane.add(lblMotDePasse);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setToolTipText("Mot de passe");
		textFieldPassword.setBounds(150, 100, 200, 21);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setToolTipText("login");
		textFieldLogin.setBounds(150, 50, 200, 21);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(159, 191, 127, 41);
		contentPane.add(btnConnexion);
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}
	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}
}
