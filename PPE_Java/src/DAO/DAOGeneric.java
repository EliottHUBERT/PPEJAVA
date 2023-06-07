package DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import Util.HibernateSessionFactory;

public abstract class DAOGeneric<T> {
	protected Session session;
	protected Class<T> entityClass;
	
	
	
	public DAOGeneric(Session session, Class<T> entityClass) {
		super();
		this.session = session;
		this.entityClass = entityClass;
	}
	
	public T find(int id) {
		T c = (T) session.get(entityClass, id);
		return c;
	}
	
	public void save(T entity) {
		session.getTransaction().begin();
		session.save(entity);
		session.getTransaction().commit();
	}
	
	public void update(T entity) {
		session.getTransaction().begin();
		session.update(entity);
		session.getTransaction().commit();
	}
	
	public void delete(T entity) {
		session.getTransaction().begin();
		session.delete(entity);
		session.getTransaction().commit();
	}
	
	public List<T> findAll() {
		Criteria criteria = session.createCriteria(entityClass);
		List<T> l = criteria.list();
		return l;
	}
	
	public int Count() {
		Criteria criteria = session.createCriteria(entityClass);
		criteria.setProjection(Projections.rowCount());
		Long ligne = (Long) criteria.uniqueResult();
		
		return (int)( (long) ligne);
	}
}
