package com.learning.spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.InventoryHistory;
import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

@Repository("inventoryDao")
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

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
	public void deleteProduct(Inventory item) {
		// Transaction trans = sessionFactory.getCurrentSession()
		// .beginTransaction();
		// session = sessionFactory.openSession();
		int query = session
				.createQuery(
						"UPDATE Inventory set isActive = :isActive"
								+ " where inventoryId = :inventoryId")
				.setParameter("inventoryId", item.getInventoryId())
				.setParameter("isActive", "NO").executeUpdate();
		// trans.commit();
	}

	@Override
	public Inventory getProduct(int inventoryId) {
		Transaction trans = null;
		try {
			trans = sessionFactory.getCurrentSession().beginTransaction();
			return (Inventory) sessionFactory.getCurrentSession().get(
					Inventory.class, inventoryId);
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

	@Override
	public List getAllProducts() {
		sessionFactory.getCurrentSession().beginTransaction();
		session = sessionFactory.openSession();

		return session.createCriteria(Inventory.class)
				.addOrder(Order.asc("productName")).list();
	}

	@Override
	public List getAllActiveProducts() {
		sessionFactory.getCurrentSession().beginTransaction();
		session = sessionFactory.openSession();

		return session.createCriteria(Inventory.class)
				.add(Restrictions.eq("isActive", "YES"))
				.addOrder(Order.asc("productName")).list();
	}

	@Override
	public void saveProductHistory(Inventory item) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		InventoryHistory history = new InventoryHistory();
		history.setBrand(item.getBrand());
		history.setCategory(item.getCategory());
		history.setColor(item.getColor());
		history.setInventory(item);
		history.setModelNumber(item.getModelNumber());
		history.setPrice(item.getPrice());
		history.setProductName(item.getProductName());
		history.setStatus(item.getStatus());
		history.setQuantity(item.getQuantity());
		history.setIsActive("YES");
		sessionFactory.getCurrentSession().save(history);
	}

	@Override
	public void saveProductDetails(int inventoryId, User user) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		Inventory inventory = (Inventory) sessionFactory.getCurrentSession()
				.get(Inventory.class, inventoryId);
		Product product = new Product();
		product.setIsInCart("YES");
		product.setQuantity(1);
		product.setInventory(inventory);
		product.setUser(user);
		sessionFactory.getCurrentSession().save(product);
		trans.commit();
	}

	public Product getProductDetails(int inventoryId) {
		return (Product) session
				.createQuery("from Product where inventory = :inventory")
				.setParameter("inventory", inventoryId).list().get(0);
	}

	@Override
	public void deleteProductDetails(int inventoryId) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		// Inventory inventory = (Inventory) sessionFactory.getCurrentSession()
		// .get(Inventory.class, inventoryId);
		session.createSQLQuery(
				"DELETE FROM PRODUCT_DETAILS "
						+ "WHERE INVENTORY_INVENTORY_ID = :inventory")
				.setParameter("inventory", inventoryId).executeUpdate();
		trans.commit();
	}

}
