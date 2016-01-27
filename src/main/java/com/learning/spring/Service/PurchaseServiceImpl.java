package com.learning.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.Dao.InventoryDao;
import com.learning.spring.Dao.PurchaseDao;
import com.learning.spring.Model.PurchaseDetails;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public void saveOrderDetails(PurchaseDetails purchaseDetails) {
		purchaseDao.saveOrderDetails(purchaseDetails);
	}

	@Override
	public void updateOrderDetails(PurchaseDetails purchaseDetails) {
		purchaseDao.updateOrderDetails(purchaseDetails);

	}

}
