package com.learning.spring.Service;

import java.util.List;

import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

public interface ProductService {

	public void saveProductDetails(int inventoryId, User user);

	public List getAllProductsInCart(User user);

	public void deleteProductDetails(int productId);

	public int getTotalCostOnPurchase(User user);

}
