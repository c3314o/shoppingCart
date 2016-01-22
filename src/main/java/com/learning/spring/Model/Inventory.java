package com.learning.spring.Model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.learning.spring.vo.SearchVO;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@SequenceGenerator(name = "INVENTORY_SEQ", sequenceName = "INVENTORY_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTORY_SEQ")
	@Column(name = "INVENTORY_ID")
	private int inventoryId;

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

	@Column(name = "IS_IN_CART")
	private String isInCart;

	@Column(name = "ACTIVE")
	private String isActive;

	@Column(name = "MODEL_NUMBER")
	private String modelNumber;

	/*
	 * @Transient private SearchVO searchVO;
	 */

	/*
	 * @Column(name = "FILENAME") private String filename;
	 * 
	 * @Column(name = "CONTENT") private Blob content;
	 * 
	 * @Column(name = "CONTENT_TYPE") private String contentType;
	 */

	public Inventory() {
	}

	public Inventory(int inventoryId, String productName, String category,
			String color, String brand, String status, Double price,
			String isInCart, String isActive, String modelNumber) {
		super();
		this.inventoryId = inventoryId;
		this.productName = productName;
		this.category = category;
		this.color = color;
		this.brand = brand;
		this.status = status;
		this.price = price;
		this.isInCart = isInCart;
		this.isActive = isActive;
		this.modelNumber = modelNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
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

	public String getIsInCart() {
		return isInCart;
	}

	public void setIsInCart(String isInCart) {
		this.isInCart = isInCart;
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

	/*
	 * public SearchVO getSearchVO() { return searchVO; }
	 * 
	 * public void setSearchVO(SearchVO searchVO) { this.searchVO = searchVO; }
	 */
}
