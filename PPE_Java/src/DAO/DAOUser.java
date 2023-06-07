package DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entities.User;

public class DAOUser extends DAOGeneric<User>{

		public DAOUser(Session session) {
			super(session, User.class);
		}
		
		public User VerifyLogin(String login, String password){
			String HQL = "FROM User u WHERE u.login = :login AND u.password = :password";
			Query query = session.createQuery(HQL);
			query.setParameter("login", login);
			query.setParameter("password", password);
			query.setMaxResults(1);
			User user = (User) query.uniqueResult();
			return user;
		}

}
