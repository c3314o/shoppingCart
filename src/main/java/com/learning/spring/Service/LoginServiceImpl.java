package com.learning.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring.Dao.UserDao;
import com.learning.spring.Model.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;

	/*
	 * public UserDao getUserDao() { return userDao; }
	 * 
	 * public void setUserDao(UserDao userDao) { this.userDao = userDao; }
	 */

	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public List getAllUser(int userId) {
		return userDao.getAllUser(userId);
	}

}
