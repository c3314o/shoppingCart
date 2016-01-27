package com.learning.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Service.InventoryService;

@Controller("inventoryController")
public class InventoryController extends BaseController {

	@Autowired
	public InventoryService inventoryService;

	@RequestMapping(value = "/saveProduct", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model) {
		Inventory productForm = new Inventory();
		model.put("productForm", productForm);
		model.put("listOfCategories", getCategoryList());
		model.put("listOfBrands", getBrandsList("All"));
		model.put("listOfColors", getColorList());
		return "add_product";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveUpdateProduct(
			@ModelAttribute("productForm") Inventory inventory,
			BindingResult result, Map<String, Object> model, ModelMap map) {

		boolean error = false;
		if (!StringUtils.hasText(inventory.getProductName())) {
			result.rejectValue("productName", "error.productName");
			error = true;
		}

		if (!StringUtils.hasText(inventory.getCategory())) {
			result.rejectValue("category", "error.category");
			error = true;
		}

		if (!StringUtils.hasText(inventory.getBrand())) {
			result.rejectValue("brand", "error.brand");
			error = true;
		}

		if (!StringUtils.hasText(inventory.getColor())) {
			result.rejectValue("color", "error.color");
			error = true;
		}

		if (!StringUtils.hasText(inventory.getModelNumber())) {
			result.rejectValue("modelNumber", "error.modelNumber");
			error = true;
		}

		if (null == inventory.getPrice() || inventory.getPrice() < 1) {
			result.rejectValue("price", "error.price");
			error = true;
		}

		if (error) {
			return "add_product";
		}

		if (inventory.getInventoryId() < 1) {
			inventory.setIsActive("YES");
			inventory.setStatus("STOCK");
			inventoryService.addProduct(inventory);
			map.addAttribute("message", "Product is added successfully!!!");
		} else {
			inventoryService.updateProduct(inventory);
			map.addAttribute("message", "Product is updated successfully!!!");
		}

		model.put("listOfCategories", getCategoryList());
		model.put("listOfBrands", getBrandsList("All"));
		model.put("listOfColors", getColorList());
		return "add_product";
	}

	@RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model, ModelMap modelList) {
		List<Inventory> listOfProducts = inventoryService.getAllProducts();
		modelList.addAttribute("listOfProducts", listOfProducts);
		model.put("completeItemList", getAllList());
		return "view_product";
	}

	@RequestMapping(value = "/{inventoryId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("inventoryId") int id,
			Map<String, Object> model, ModelMap map) {

		Inventory inventory = new Inventory();
		inventory = inventoryService.getProduct(id);
		map.addAttribute("productForm", inventory);
		model.put("listOfCategories", getCategoryList());
		model.put("listOfBrands", getBrandsList("All"));
		model.put("listOfColors", getColorList());
		map.addAttribute("edit", true);

		return "add_product";
	}

	@RequestMapping(value = "/delete/{inventoryId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("inventoryId") int id,
			ModelMap map) {

		Inventory inventory = new Inventory();
		inventory = inventoryService.getProduct(id);
		inventoryService.deleteProduct(inventory);
		map.addAttribute("message", "Product is deleted successfully!!!");
		return "redirect:/viewProduct";
	}
}
