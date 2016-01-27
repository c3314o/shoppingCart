package com.learning.spring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY_HISTORY")
public class InventoryHistory {

	@Id
	@SequenceGenerator(name = "INVENTORY_HISTORY_SEQ", sequenceName = "INVENTORY_HISTORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_HISTORY_SEQ")
	@Column(name = "INVENTORY_HISTORY_ID")
	private int inventoryHistoryId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "CATAGORY")
	private String category;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "ACTIVE")
	private String isActive;

	@Column(name = "MODEL_NUMBER")
	private String modelNumber;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVENTORY_ID", nullable = false)
	private Inventory inventory;

	public InventoryHistory() {
	}

	public InventoryHistory(int inventoryHistoryId, String productName,
			String category, String color, String brand, String status,
			Double price, String isActive, String modelNumber, int quantity,
			Inventory inventory) {
		super();
		this.inventoryHistoryId = inventoryHistoryId;
		this.productName = productName;
		this.category = category;
		this.color = color;
		this.brand = brand;
		this.status = status;
		this.price = price;
		this.isActive = isActive;
		this.modelNumber = modelNumber;
		this.quantity = quantity;
		this.inventory = inventory;
	}

	public int getInventoryHistoryId() {
		return inventoryHistoryId;
	}

	public void setInventoryHistoryId(int inventoryHistoryId) {
		this.inventoryHistoryId = inventoryHistoryId;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
