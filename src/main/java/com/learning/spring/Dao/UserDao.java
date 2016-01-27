package com.learning.spring.Dao;

import java.util.List;

import com.learning.spring.Model.User;

public interface UserDao {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);

	public User getUser(int userId);

	public User getUser(String username);

	public List getAllUser(int userId);
	
	User getLoggedInUser(String username);
}
