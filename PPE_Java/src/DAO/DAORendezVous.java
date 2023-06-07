package DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.Rendezvous;
import entities.User;

public class DAORendezVous extends DAOGeneric<Rendezvous>{

	public DAORendezVous(Session session) {
		super(session, Rendezvous.class);
	}
	
	public List<Rendezvous> findAllWhereUser(User user){
		String HQL = "FROM Rendezvous r WHERE r.user = :user AND r.visited = 0";
		Query query = session.createQuery(HQL);
		query.setParameter("user", user);
		List<Rendezvous> l = query.getResultList();
		return l;
	}
	
	public List<Rendezvous> findAll(){
		String HQL = "FROM Rendezvous r";
		Query query = session.createQuery(HQL);
		List<Rendezvous> l = query.getResultList();
		return l;
	}
	
	public List<Rendezvous> findAllWhereNotVisited(){
		String HQL = "FROM Rendezvous r WHERE r.visited = 0";
		Query query = session.createQuery(HQL);
		List<Rendezvous> l = query.getResultList();
		return l;
	}
	
	public Integer countWhereUser(User user) {
		String HQL = "SELECT COUNT(r) FROM Rendezvous r WHERE r.user = :user AND r.visited = 0";
		Query query = session.createQuery(HQL);
		query.setParameter("user", user);
		
		Long result = (Long) query.uniqueResult();
		
		return (int)( (long) result);
	}
}
