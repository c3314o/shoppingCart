package com.learning.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.Dao.AddressDao;
import com.learning.spring.Model.Address;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Override
	public void saveAddress(Address address) {
		addressDao.saveAddress(address);
	}

}
