package DAO;

import org.hibernate.Session;

import entities.Medecin;

public class DAOMedecin extends DAOGeneric<Medecin>{

	public DAOMedecin(Session session) {
		super(session, Medecin.class);
	}
	

}
