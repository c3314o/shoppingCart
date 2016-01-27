package com.learning.spring.Dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.PurchaseDetails;

@Repository("purchaseDao")
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrderDetails(PurchaseDetails purchaseDetails) {

		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().save(purchaseDetails);
		trans.commit();
	}

	@Override
	public void updateOrderDetails(PurchaseDetails purchaseDetails) {

		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().update(purchaseDetails);
		trans.commit();
	}

}
