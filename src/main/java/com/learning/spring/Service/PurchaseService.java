package com.learning.spring.Service;

import com.learning.spring.Model.PurchaseDetails;

public interface PurchaseService {

	public void saveOrderDetails(PurchaseDetails purchaseDetails);
	
	public void updateOrderDetails(PurchaseDetails purchaseDetails);

}
