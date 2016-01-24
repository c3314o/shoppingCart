package com.learning.spring.Service;

import java.util.List;

import com.learning.spring.Model.Role;
import com.learning.spring.Model.User;

public interface UserService {

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int userId);

	public User getUser(int userId);

	public List getAllUser(int userId);

	// public Boolean isLoggedInUserAdmin(String username);

	public void saveRole(Role role);
}
