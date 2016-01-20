package com.learning.spring.Dao;

import java.util.List;

import com.learning.spring.Model.Inventory;

public interface InventoryDao {

	public void addProduct(Inventory item);

	public void updateProduct(Inventory item);

	public Inventory getProduct(int inventoryId);

	public List getAllProducts();

//	public void updateCartField(int inventoryId, String isInCart);
}
