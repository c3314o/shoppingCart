package com.learning.spring.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_DETAILS")
public class PurchaseDetails {

	@Id
	@SequenceGenerator(name = "PURCHASE_SEQ", sequenceName = "PURCHASE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_SEQ")
	@Column(name = "PURCHASE_ID")
	private int purchaseId;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseDetails")
	private Set<Product> product = new HashSet<Product>();

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
