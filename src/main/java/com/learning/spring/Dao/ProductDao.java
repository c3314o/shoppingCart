package com.learning.spring.Dao;

import java.util.List;

import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

public interface ProductDao {

	public void saveProductDetails(int inventoryId, User user);

	// public Product getProductDetails(int inventoryId);

	public List getAllProductsInCart(User user);

	public void deleteProductDetails(int productId);
	
	public int getTotalCostOnPurchase(User user);
}
