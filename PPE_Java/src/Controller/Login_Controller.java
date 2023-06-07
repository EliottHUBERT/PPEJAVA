package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

import org.hibernate.Session;

import DAO.DAOUser;
import Util.HibernateSessionFactory;
import Views.F_Login;
import Views.F_Main;
import entities.User;


public class Login_Controller {
	F_Login f_login;
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	
	public Login_Controller(F_Login f_login) {
		super();
		this.f_login = f_login;
		
		f_login.getBtnConnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do_verify();
			}
		});
	}
	
	public void init() {
		f_login.setVisible(true);
	}
	
	public void do_verify() {
		String login = f_login.getTextFieldLogin().getText();
		String password = String.valueOf(f_login.getTextFieldPassword().getPassword());
		
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
	        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
	       
	        Session session = HibernateSessionFactory.getSessionFactory().openSession();
			DAOUser daouser = new DAOUser(session);
			User user = daouser.VerifyLogin(login, sha256);
			if (user != null) {
				f_login.setVisible(false);
				F_Main f_main = new F_Main();
				new Main_Controller(f_main, user).init();
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
		
	}
}
