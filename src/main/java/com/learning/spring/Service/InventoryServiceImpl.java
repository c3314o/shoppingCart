package com.learning.spring.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring.Dao.InventoryDao;
import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private InventoryDao inventoryDao;

	@Transactional
	public void addProduct(Inventory item) {
		inventoryDao.addProduct(item);
		inventoryDao.saveProductHistory(item);
	}

	@Transactional
	public void updateProduct(Inventory item) {
		inventoryDao.updateProduct(item);
		inventoryDao.saveProductHistory(item);
	}

	@Override
	public void deleteProduct(Inventory item) {
		inventoryDao.deleteProduct(item);
		// inventoryDao.saveProductHistory(item);
	}

	@Transactional
	public Inventory getProduct(int inventoryId) {
		return inventoryDao.getProduct(inventoryId);
	}

	@Transactional
	public List getAllProducts() {
		return inventoryDao.getAllProducts();
	}

	@Transactional
	public List getAllActiveProducts() {
		return inventoryDao.getAllActiveProducts();
	}

	@Override
	public void saveProductDetails(int inventoryId, User user) {
		inventoryDao.saveProductDetails(inventoryId, user);
	}

	@Override
	public void deleteProductDetails(int inventoryId) {
		inventoryDao.deleteProductDetails(inventoryId);
	}

	@Override
	public Product getProductDetails(int inventoryId) {
		return inventoryDao.getProductDetails(inventoryId);
	}

	// @Override
	// @Transactional
	// public void updateCartField(int inventoryId, String isInCart) {
	// Transaction trans = sessionFactory.getCurrentSession()
	// .beginTransaction();
	// session = sessionFactory.openSession();
	// int query = session
	// .createQuery(
	// "UPDATE Inventory set isInCart = :isInCart"
	// + " where inventoryId = :inventoryId")
	// .setParameter("inventoryId", inventoryId)
	// .setParameter("isInCart", isInCart).executeUpdate();
	// trans.commit();
	// }

	// @Override
	// public List getAllProductsInCart() {
	// Transaction trans = sessionFactory.getCurrentSession()
	// .beginTransaction();
	// session = sessionFactory.openSession();
	// return session.createCriteria(Inventory.class)
	// .add(Restrictions.eq("isInCart", "YES"))
	// .add(Restrictions.ne("status", "RETAIL"))
	// .addOrder(Order.asc("productName").ignoreCase()).list();
	// }

	// @Override
	// public void purchaseProduct(int inventoryId, String status) {
	// int query = session
	// .createQuery(
	// "UPDATE Inventory set status = :status"
	// + " where inventoryId = :inventoryId")
	// .setParameter("inventoryId", inventoryId)
	// .setParameter("status", status).executeUpdate();
	// }
}
