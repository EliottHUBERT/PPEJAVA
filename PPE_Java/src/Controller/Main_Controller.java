package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DAO.DAOCompterendu;
import DAO.DAOMedecin;
import DAO.DAORendezVous;
import DAO.DAOUser;
import Util.HibernateSessionFactory;
import Views.F_Main;
import entities.CompteRendu;
import entities.Medecin;
import entities.Rendezvous;
import entities.User;
public class Main_Controller {

	F_Main f_main;
	User user_connected;
	MyDefaultTableModel mDTM;
	MyDefaultTableModelCR mDTMCR;
	MyDefaultTableModelAllCR mDTMAllCR;
	MyDefaultTableModelAllRDV mDTMAllRDV;
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	
	public Main_Controller(F_Main f_main, User user_connected) {
		super();
		this.f_main = f_main;
		this.user_connected = user_connected;
		
		f_main.getComboBoxCR_RDV().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreRemplisage();		
			}
		});
		
		f_main.getComboBoxOldUser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OldUserPreRemplisage();
			}
		});
		f_main.getBtnOldUserValidate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OldUserUpdate();
			}
		});
		f_main.getBtnNewUserValidate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewUserAdd();
			}
		});
		
		f_main.getBtnValiderNvxRDV().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewRDV();
			}
		});
		
		f_main.getBtnValider().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ValiderCompteRendu();
			}
		});
		
		f_main.getBtnValidCRMod().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doUpdate();
			}
		});
		
		f_main.getBtnCancelCRMod().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doCancel();
			}
		});
		
		f_main.getBtnValiderOldRDV().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doUpdateRDV();
			}
		});

		}

	
	public void init() {		
		DAORendezVous daoRDV = new DAORendezVous(session);
		DAOCompterendu daoCR = new DAOCompterendu(session);
		DAOMedecin daoMedecin = new DAOMedecin(session);
		DAOUser daoUser = new DAOUser(session);
		
		
		List<Rendezvous> listRDV = daoRDV.findAllWhereUser(user_connected);
		
		List<Rendezvous>listAllRDVNotVisited = daoRDV.findAllWhereNotVisited();
		List<Medecin> listMedecin = daoMedecin.findAll();
		
		List<CompteRendu>listCR = daoCR.findAllWhereUser(user_connected);
		Integer nbRDV = daoRDV.countWhereUser(user_connected);
		Integer nbCR = daoCR.countWhereUser(user_connected);
		mDTM = new MyDefaultTableModel(listRDV);
		
		mDTMCR = new MyDefaultTableModelCR(listCR);
		
		f_main.getTableRDV().setModel(mDTM);
		f_main.getTableCR().setModel(mDTMCR);
		f_main.getLblNomUtilisateur().setText(user_connected.getLogin());
		f_main.getLblNbRDV().setText(Integer.toString(nbRDV));
		f_main.getLblNbCR().setText(Integer.toString(nbCR));
		
		if (user_connected.getRole().equals("admin")) {
			List<User> listUser = daoUser.findAll();
			List<CompteRendu> listAllCR = daoCR.findAll();
			List<Rendezvous>listAllRDV = daoRDV.findAll();
			
			
			mDTMAllCR = new MyDefaultTableModelAllCR(listAllCR);
			mDTMAllRDV = new MyDefaultTableModelAllRDV(listAllRDV);
			
			f_main.getTabbedPane().setEnabledAt(2, true);
			f_main.getTableAllRDV().setModel(mDTMAllRDV);
			f_main.getTableAllCR().setModel(mDTMAllCR);
			
			for (User user : listUser) {
				f_main.getComboBoxOldUser().addItem(user.getId()+" | "+user.getLogin());
				f_main.getComboBoxVisiteurNvxRDV().addItem(user.getId()+" | "+user.getLogin());
				f_main.getComboBoxVisiteurOldRDV().addItem(user.getId()+" | "+user.getLogin());
			}
			for (Rendezvous rdv : listAllRDVNotVisited) {
				f_main.getComboBoxOldRDV().addItem(rdv.getId()+" | "+rdv.getNom());
			}
			for (Medecin medecin : listMedecin) {
				f_main.getComboBoxMedecinNvxRDV().addItem(medecin.getId()+ " | " +medecin.getNom());
				f_main.getComboBoxMedecinOldRDV().addItem(medecin.getId()+ " | " +medecin.getNom());
			}
		}
		else {
			f_main.getTabbedPane().setEnabledAt(2, false);
		}
		
		f_main.setVisible(true);
		
		
		
		f_main.getComboBoxCR_Visiteur().addItem(user_connected.getId()+" | "+user_connected.getLogin());
		for (Rendezvous rendezvous : listRDV) {
			f_main.getComboBoxCR_RDV().addItem(rendezvous.getId());
		}
		
		for (Medecin medecin : listMedecin) {
			f_main.getComboBoxCR_Medecin().addItem(medecin.getId()+ " | " +medecin.getNom());
		}
		
	}
	
	public void PreRemplisage() { 
		DAORendezVous daoRDV = new DAORendezVous(session);
		DAOMedecin daoMedecin = new DAOMedecin(session);
		
		Rendezvous rdv = daoRDV.find((int)f_main.getComboBoxCR_RDV().getSelectedItem());
		Medecin medecin = rdv.getMedecin();
		
		
		f_main.getComboBoxCR_Medecin().setSelectedItem(medecin.getNom());
		f_main.getComboBoxCR_Visiteur().setSelectedItem(user_connected.getLogin());
	}
	
	public void OldUserPreRemplisage() { 
		DAOUser daoUser = new DAOUser(session);
		
		
		String comboresult = (String) f_main.getComboBoxOldUser().getSelectedItem();
		String[] result = comboresult.split(" ");
		String id = result[0];
		User userSelected = daoUser.find(Integer.parseInt(id));
		
		f_main.getTextFieldOldUserLogin().setText(userSelected.getLogin());
		f_main.getPasswordFieldOldUserPassword().setText(userSelected.getPassword());
		f_main.getTextFieldOldUserId().setText(id);
		if (userSelected.getRole().equals("admin")) {
			f_main.getRdbtnOldUserAdmin().setSelected(true);
			f_main.getRdbtnOldUserVisiteur().setSelected(false);
		}
		else {
			f_main.getRdbtnOldUserAdmin().setSelected(false);
			f_main.getRdbtnOldUserVisiteur().setSelected(true);
		}
	}
	public void OldUserUpdate() {
		DAOUser daoUser = new DAOUser(session);
		
		User user = daoUser.find(Integer.parseInt(f_main.getTextFieldOldUserId().getText()));
		user.setLogin(f_main.getTextFieldOldUserLogin().getText());
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(f_main.getPasswordFieldOldUserPassword().getText().getBytes(StandardCharsets.UTF_8));
	        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
	        user.setPassword(sha256);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (f_main.getRdbtnOldUserAdmin().isSelected()) {
			user.setRole("admin");
		}
		else {
			user.setRole("visiteur");
		}
		
		daoUser.update(user);
		
	}
	public void NewUserAdd() {
		DAOUser daoUser = new DAOUser(session);
		
		User user = new User();
		user.setLogin(f_main.getTextFieldNewUserLogin().getText());
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(f_main.getPasswordFieldNewUserPassword().getText().getBytes(StandardCharsets.UTF_8));
	        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
	        user.setPassword(sha256);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (f_main.getRdbtnOldUserAdmin().isSelected()) {
			user.setRole("admin");
		}
		else {
			user.setRole("visiteur");
		}
		daoUser.save(user);
	}
	
	public void NewRDV() { 
		DAORendezVous daoRDV = new DAORendezVous(session);
		DAOMedecin daoM = new DAOMedecin(session);
		DAOUser daoUser = new DAOUser(session);
		
		Rendezvous rdv = new Rendezvous();
		
		rdv.setNom(f_main.getTextFieldNomNvxRDV().getText());
		rdv.setDate(f_main.getCalendarNvxRDV().getDate());
		
		String SelectedUser = (String) f_main.getComboBoxVisiteurNvxRDV().getSelectedItem();
		String[] splitedvisiteur = SelectedUser.split(" ");
		SelectedUser = splitedvisiteur[0];
		User visiteur = new User();
		visiteur = daoUser.find(Integer.parseInt(SelectedUser));
		rdv.setUser(visiteur);
		
		String SelectedMedecin = (String) f_main.getComboBoxMedecinNvxRDV().getSelectedItem();
		String[] splited = SelectedMedecin.split(" ");
		SelectedMedecin = splited[0];
		Medecin medecin = new Medecin();
		medecin = daoM.find(Integer.parseInt(SelectedMedecin));
		rdv.setMedecin(medecin);
		daoRDV.save(rdv);
		
		init();
	}
	
	public void ValiderCompteRendu() { 
		DAOMedecin daoM = new DAOMedecin(session);
		DAORendezVous daoRDV = new DAORendezVous(session);
		DAOCompterendu daoCR = new DAOCompterendu(session);
		
		CompteRendu CR = new CompteRendu();
		
		CR.setUser(user_connected);
		
		Medecin medecin = new Medecin();
		String SelectedMedecin = (String) f_main.getComboBoxCR_Medecin().getSelectedItem();
		String[] splited = SelectedMedecin.split(" ");
		SelectedMedecin = splited[0];
		medecin = daoM.find(Integer.parseInt(SelectedMedecin));
		
		CR.setMedecin(medecin);
		
		Rendezvous RDV = new Rendezvous();
		Integer RDVId = (Integer) f_main.getComboBoxCR_RDV().getSelectedItem();
		RDV = daoRDV.find(RDVId);
		RDV.setVisited(1);
		daoRDV.save(RDV);
		CR.setRendezvous(RDV);
		
		
		String lisibilite = null;
		if (f_main.getRdbtnLisible().isSelected()) {
			lisibilite = "Lisible";
		}
		if (f_main.getRdbtnPeuLisible().isSelected()) {
			lisibilite = "Peu Lisible";
		}
		if (f_main.getRdbtnIllisible().isSelected()) {
			lisibilite = "Illisible";
		}
		
		CR.setLisibilite(lisibilite);
		
		String confiance = null;
		if (f_main.getRdbtnLisible().isSelected()) {
			confiance = "Confiant";
		}
		if (f_main.getRdbtnPeuLisible().isSelected()) {
			confiance = "Peu Confiant";
		}
		if (f_main.getRdbtnIllisible().isSelected()) {
			confiance = "Réticent";
		}
			
		CR.setConfiance(confiance);
		
		CR.setProbleme(f_main.getTextAreaProbleme().getText());
		 
		daoCR.save(CR);
		System.out.println("Compte rendu saved");
		init();
	}
	
	private void doUpdate() {
		System.out.println("testttt");
		for (CompteRendu CR : mDTMCR.getModified()) {
			System.out.println("testtttqssssssssss");
			DAOCompterendu daoCR = new DAOCompterendu(session);
			daoCR.update(CR);
		}
		f_main.getLblModText().setText("Les modifications ont bien été effectuer");
	}
	
	private void doCancel() {
		init();
	}
	
	private void doUpdateRDV() {
		DAOMedecin daoM = new DAOMedecin(session);
		DAORendezVous daoRDV = new DAORendezVous(session);
		DAOUser daoUser = new DAOUser(session);
		
		Rendezvous rdv = new Rendezvous();
		
		String SelectedRdv = (String) f_main.getComboBoxOldRDV().getSelectedItem();
		String[] splited = SelectedRdv.split(" ");
		SelectedRdv = splited[0];
		rdv = daoRDV.find(Integer.parseInt(SelectedRdv));
		
		Medecin medecin = new Medecin();
		
		String SelectedMedecin = (String) f_main.getComboBoxMedecinOldRDV().getSelectedItem();
		String[] splitedMedecin = SelectedMedecin.split(" ");
		SelectedMedecin = splitedMedecin[0];
		medecin = daoM.find(Integer.parseInt(SelectedMedecin));
		
		
		User visiteur = new User();
		
		String SelectedVisiteur = (String) f_main.getComboBoxVisiteurOldRDV().getSelectedItem();
		String[] splitedVisiteur = SelectedVisiteur.split(" ");
		SelectedVisiteur = splitedVisiteur[0];
		visiteur = daoUser.find(Integer.parseInt(SelectedVisiteur));
		
		rdv.setMedecin(medecin);
		rdv.setUser(visiteur);
		rdv.setNom(f_main.getNewNomOldRDV().getText());
		rdv.setDate(f_main.getCalendarOldRDV().getDate());
		
		daoRDV.save(rdv);
		
		init();
	}
	


}
