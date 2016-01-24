package com.learning.spring.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveAddress(Address address) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().save(address);
		trans.commit();
	}

}
