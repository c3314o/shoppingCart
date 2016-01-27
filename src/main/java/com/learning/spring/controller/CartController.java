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
import com.learning.spring.Service.ProductService;
import com.learning.spring.Service.UserService;

@Controller("catController")
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	public UserService userService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model, ModelMap modelList,
			Principal principal) {
		User user = userService.getLoggedInUser(principal.getName());
		List<Inventory> listOfProducts = productService
				.getAllProductsInCart(user);
		modelList.addAttribute("listOfProducts", listOfProducts);

		Inventory cartForm = new Inventory();
		model.put("cartForm", cartForm);
		return "cart";
	}

	@RequestMapping(value = "/remove/{productId}")
	public String removeFromCart(@PathVariable("productId") int id,
			Map<String, Object> model, ModelMap map) {
		productService.deleteProductDetails(id);
		return "redirect:/cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/purchase")
	public String purchaseProduct(Map<String, Object> model, ModelMap modelList) {
		

		// List<Inventory> listOfProducts = inventoryService
		// .getAllProductsInCart();
		// for (Inventory inventory : listOfProducts) {
		// inventoryService.purchaseProduct(inventory.getInventoryId(),
		// "RETAIL");
		// }
		// modelList.addAttribute("listOfProducts", listOfProducts);
		// Inventory cartForm = new Inventory();
//		model.put("cartForm", cartForm);
		return "redirect:/cart";
	}

}
