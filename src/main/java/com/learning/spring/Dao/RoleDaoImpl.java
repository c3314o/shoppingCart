package com.learning.spring.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveRole(Role role) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().save(role);
		trans.commit();
	}

}
