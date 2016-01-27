package com.learning.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring.Dao.ProductDao;
import com.learning.spring.Model.Product;
import com.learning.spring.Model.User;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public void saveProductDetails(int inventoryId, User user) {
		productDao.saveProductDetails(inventoryId, user);
	}

	@Override
	public List getAllProductsInCart(User user) {
		return productDao.getAllProductsInCart(user);
	}

	@Override
	public void deleteProductDetails(int productId) {
		productDao.deleteProductDetails(productId);
	}

	@Override
	public int getTotalCostOnPurchase(User user) {
		return productDao.getTotalCostOnPurchase(user);
	}
}
