package com.learning.spring.vo;

import com.learning.spring.Model.Address;
import com.learning.spring.Model.User;

public class UserVo {

	private int userVoId;

	private User user;

	private Address address;

	// private String confirmPassword;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getUserVoId() {
		return userVoId;
	}

	public void setUserVoId(int userVoId) {
		this.userVoId = userVoId;
	}

	// public String getConfirmPassword() {
	// return confirmPassword;
	// }
	//
	// public void setConfirmPassword(String confirmPassword) {
	// this.confirmPassword = confirmPassword;
	// }
}
