package com.learning.spring.Dao;

import com.learning.spring.Model.PurchaseDetails;

public interface PurchaseDao {

	public void saveOrderDetails(PurchaseDetails purchaseDetails);

	public void updateOrderDetails(PurchaseDetails purchaseDetails);
}
