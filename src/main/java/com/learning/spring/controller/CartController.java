package com.learning.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.Inventory;

@Controller("catController")
public class CartController extends BaseController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService
				.getAllProductsInCart();
		modelList.addAttribute("listOfProducts", listOfProducts);
		Inventory cartForm = new Inventory();
		model.put("cartForm", cartForm);
		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/purchase")
	public String purchaseProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService
				.getAllProductsInCart();
		for (Inventory inventory : listOfProducts) {
			inventoryService.purchaseProduct(inventory.getInventoryId(),
					"RETAIL");
		}
		modelList.addAttribute("listOfProducts", listOfProducts);
		Inventory cartForm = new Inventory();
		model.put("cartForm", cartForm);
		return "redirect:/cart";
	}

	@RequestMapping(value = "/remove/{inventoryId}")
	public String removeFromCart(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map) {
		inventoryService.updateCartField(id, "NO");
		return "redirect:/cart";
	}
}
