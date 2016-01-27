package com.learning.spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	@Override
	public List getAllProductsInCart(User user) {
		sessionFactory.getCurrentSession().beginTransaction();
		session = sessionFactory.openSession();

		return session.createCriteria(Product.class)
				.add(Restrictions.eq("isInCart", "YES"))
				.add(Restrictions.eq("user", user)).list();
	}

	@Override
	public void deleteProductDetails(int productId) {
		Transaction trans = sessionFactory.getCurrentSession()
				.beginTransaction();
		session = sessionFactory.openSession();
		session.createQuery("DELETE FROM Product WHERE productId = :productId")
				.setParameter("productId", productId).executeUpdate();
		trans.commit();
	}

	@Override
	public int getTotalCostOnPurchase(User user) {
		sessionFactory.getCurrentSession().beginTransaction();
		session = sessionFactory.openSession();
		return (Integer) session.createQuery(
				"select sum(pd.quantity) from inventory i ").uniqueResult();
	}
}
