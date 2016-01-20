package com.learning.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.User;
import com.learning.spring.Service.LoginService;

@Controller("loginController")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);
		return "signup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userForm") User user, Map<String, Object> map) {

		User userDetail = new User();
		loginService.addUser(user);
		userDetail = user;
		map.put("user", userDetail);
		return "customer_detail";
	}

	/*
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * String registerUser(@ModelAttribute User user, BindingResult result,
	 * 
	 * @RequestParam String action, Map<String, Object> map) {
	 * 
	 * User userDetail = new User(); loginService.addUser(user); userDetail =
	 * user; map.put("user", userDetail); return "signup-success"; }
	 */
}