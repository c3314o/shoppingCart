package com.learning.spring.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_DETAILS")
public class Product {

	@Id
	@SequenceGenerator(name = "PRODUCT_DETAILS_SEQ", sequenceName = "PRODUCT_DETAILS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_DETAILS_SEQ")
	@Column(name = "PRODUCT_ID")
	private int productId;

	@Column(name = "IS_IN_CART")
	private String isInCart;

	@Column(name = "QUANTITY")
	private int quantity;

	@OneToOne(cascade = CascadeType.ALL)
	private Inventory inventory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PURCHASE_ID")
	private PurchaseDetails purchaseDetails;

	public Product() {

	}

	public Product(int productId, String isInCart, int quantity) {
		super();
		this.productId = productId;
		this.isInCart = isInCart;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getIsInCart() {
		return isInCart;
	}

	public void setIsInCart(String isInCart) {
		this.isInCart = isInCart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
