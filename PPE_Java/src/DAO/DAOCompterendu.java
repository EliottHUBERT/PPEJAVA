package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.CompteRendu;
import entities.Rendezvous;
import entities.User;

public class DAOCompterendu extends DAOGeneric<CompteRendu>{

	public DAOCompterendu(Session session) {
		super(session, CompteRendu.class);
	}
	
	public Integer countWhereUser(User user) {
		String HQL = "SELECT COUNT(cr) FROM CompteRendu cr WHERE cr.user = :user";
		Query query = session.createQuery(HQL);
		query.setParameter("user", user);
		
		Long result = (Long) query.uniqueResult();
		
		return (int)( (long) result);
	}
	
	public List<CompteRendu> findAllWhereUser(User user){
		String HQL = "FROM CompteRendu r WHERE r.user = :user";
		Query query = session.createQuery(HQL);
		query.setParameter("user", user);
		List<CompteRendu> l = query.getResultList();
		return l;
	}
	
	public List<CompteRendu> findAll(){
		String HQL = "FROM CompteRendu r";
		Query query = session.createQuery(HQL);
		List<CompteRendu> l = query.getResultList();
		return l;
	}
	

}
