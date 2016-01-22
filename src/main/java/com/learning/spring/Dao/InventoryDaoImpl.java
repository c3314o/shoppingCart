package com.learning.spring.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.Inventory;

@Repository("inventoryDao")
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Inventory item) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().save(item);
		trans.commit();
	}

	@Override
	public void updateProduct(Inventory item) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		sessionFactory.getCurrentSession().update(item);
		trans.commit();
	}

	@Override
	public Inventory getProduct(int inventoryId) {
		sessionFactory.getCurrentSession().beginTransaction();
		return (Inventory) sessionFactory.getCurrentSession().get(
				Inventory.class, inventoryId);
	}

	@Override
	public List getAllProducts() {
		sessionFactory.getCurrentSession().beginTransaction();
		return sessionFactory.getCurrentSession()
				.createQuery("from Inventory order by productName").list();
	}
}
