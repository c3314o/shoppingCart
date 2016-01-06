package com.learning.spring.Service;

import java.util.List;

import com.learning.spring.Model.User;

public interface LoginService {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);

	public User getUser(int userId);

	public List getAllUser(int userId);
}
