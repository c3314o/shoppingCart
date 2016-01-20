package com.learning.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.spring.Model.Inventory;

@Controller("homeController")
@RequestMapping("/shop")
public class HomeController extends InventoryController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService.getAllProducts();
		modelList.addAttribute("listOfProducts", listOfProducts);
		Inventory viewProductForm = new Inventory();
		model.put("viewProductForm", viewProductForm);
		model.put("completeItemList", getAllList());
		return "view_product";
	}

	@RequestMapping(value = "/addToCart/{inventoryId}")
	public String addToCart(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map) {
		inventoryService.updateCartField(id, "YES");
		return "redirect:/viewProduct";
	}

	@RequestMapping(value = "/removeFromCart/{inventoryId}")
	public String removeFromCart(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map) {
		inventoryService.updateCartField(id, "NO");
		return "redirect:/viewProduct";
	}

	/*
	 * @RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
	 * public String getListForAutocomplete(Map<String, Object> model) {
	 * model.put("completeItemList", getAllList()); return
	 * "redirect:/viewProduct"; }
	 */

	@RequestMapping(value = "/searchList", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody List<String> getListForAutocomplete(
			@RequestParam("term") String query) {
		return getAllList();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search-{searchValue}", method = RequestMethod.GET)
	public String searchProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService.getAllProducts();
		modelList.addAttribute("listOfProducts", listOfProducts);
		Inventory viewProductForm = new Inventory();
		model.put("viewProductForm", viewProductForm);
		return "view_product";
	}

}
