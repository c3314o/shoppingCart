package com.learning.spring.vo;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.Product;

public class InventoryVO {
	private Inventory inventory;
	private Product product;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
