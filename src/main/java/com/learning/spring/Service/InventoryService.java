package com.learning.spring.Service;

import java.util.List;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

public interface InventoryService {

	public void addProduct(Inventory item);

	public void updateProduct(Inventory item);

	public void deleteProduct(Inventory item);

	public Inventory getProduct(int inventoryId);

	public List getAllProducts();

	public List getAllActiveProducts();

	public void saveProductDetails(int inventoryId, User user);

	public void deleteProductDetails(int inventoryId);

	public Product getProductDetails(int inventoryId);
}
