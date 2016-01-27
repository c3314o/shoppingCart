package com.learning.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.Role;
import com.learning.spring.Service.AddressService;
import com.learning.spring.Service.UserService;
import com.learning.spring.vo.UserVo;

@Controller("loginController")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> model) {
		UserVo userForm = new UserVo();
		model.put("userForm", userForm);
		return "signup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userForm") UserVo userVo,
			BindingResult result, Map<String, Object> map) {
		Role role = new Role();

		boolean error = false;
		if (!StringUtils.hasText(userVo.getUser().getFirstname())) {
			result.rejectValue("user.firstname", "error.firstname");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getUser().getLastname())) {
			result.rejectValue("user.lastname", "error.lastname");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getUser().getUsername())) {
			result.rejectValue("user.username", "error.username");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getUser().getPassword())) {
			result.rejectValue("user.password", "error.password");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getAddress().getAddressLine1())) {
			result.rejectValue("address.addressLine1", "error.addressLine1");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getAddress().getCity())) {
			result.rejectValue("address.city", "error.city");
			error = true;
		}

		if (!StringUtils.hasText(userVo.getAddress().getStateCode())) {
			result.rejectValue("address.stateCode", "error.state");
			error = true;
		}

		if (userVo.getAddress().getZipCode() < 1) {
			result.rejectValue("address.zipCode", "error.zip");
			error = true;
		}

		if (error) {
			return "signup";
		}

		userVo.getUser().setEnabled(1);
		userService.addUser(userVo.getUser());

		role.setRole("USER");
		role.setUserId(userVo.getUser());
		role.setUsername(userVo.getUser().getUsername());
		userService.saveRole(role);

		userVo.getAddress().setUser(userVo.getUser());
		addressService.saveAddress(userVo.getAddress());

		map.put("user", userVo.getUser());
		return "customer_detail";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		// model.addAttribute("message", "true");
		return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage(Map<String, Object> model, ModelMap modelList) {
		/*
		 * User user = (User) SecurityContextHolder.getContext()
		 * .getAuthentication().getPrincipal(); String name =
		 * user.getFirstname();
		 */
		return "index";
	}
}