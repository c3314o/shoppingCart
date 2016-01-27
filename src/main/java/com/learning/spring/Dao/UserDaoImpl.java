package com.learning.spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().save(user);
		trans.commit();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(int userId) {
		sessionFactory.getCurrentSession().delete(getUser(userId));
	}

	@Override
	public User getUser(int userId) {
		return (User) sessionFactory.getCurrentSession()
				.get(User.class, userId);
	}

	@Override
	public List getAllUser(int userId) {
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	@Override
	public User getUser(String username) {
		sessionFactory.getCurrentSession().beginTransaction();
		return (User) sessionFactory.getCurrentSession().get(User.class,
				username);
	}

	@Override
	public User getLoggedInUser(String username) {
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			return (User) session
					.createQuery("from User where username = :username")
					.setParameter("username", username).list().get(0);
		} catch (RuntimeException e) {
			try {
				trans.rollback();
			} catch (RuntimeException rbe) {
				e.printStackTrace();
			}
			throw e;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
