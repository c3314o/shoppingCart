package com.learning.spring.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Model.User;
import com.learning.spring.Service.InventoryService;
import com.learning.spring.Service.ProductService;
import com.learning.spring.Service.UserService;
import com.learning.spring.vo.InventoryVO;

@Controller("homeController")
public class HomeController extends BaseController {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	public UserService userService;

	@Autowired
	public ProductService productService;

	// @Autowired
	// PurchaseService purchaseService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService
				.getAllActiveProducts();
		modelList.addAttribute("listOfProducts", listOfProducts);
		InventoryVO viewProductForm = new InventoryVO();
		model.put("viewProductForm", viewProductForm);
		model.put("completeItemList", getAllList());
		return "home";
	}

	@RequestMapping(value = "/addToCart/{inventoryId}")
	public String addToCart(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map, Principal principal) {

		User user = userService.getLoggedInUser(principal.getName());
		productService.saveProductDetails(id, user);
		return "redirect:/home";
	}

	@RequestMapping(value = "/removeFromCart/{inventoryId}")
	public String removeFromCart(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map) {
		inventoryService.deleteProductDetails(id);
		return "redirect:/home";
	}
}
