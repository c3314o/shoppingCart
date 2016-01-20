package com.learning.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.spring.Model.Inventory;
import com.learning.spring.Service.InventoryService;

@Controller("inventoryController")
@RequestMapping("/inventoryPage")
public class InventoryController {

	@Autowired
	public InventoryService inventoryService;

	@RequestMapping(value = "/saveProduct", method = RequestMethod.GET)
	public String viewProduct(Map<String, Object> model) {
		Inventory productForm = new Inventory();
		model.put("productForm", productForm);
		model.put("listOfCategories", getCategoryList());
		model.put("listOfBrands", getBrandsList("All"));
		return "add_product";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(
			@ModelAttribute("productForm") Inventory inventory,
			BindingResult result, Map<String, Object> model, ModelMap map) {
		Inventory product = new Inventory();
		inventory.setIsInCart("NO");
		inventory.setIsActive("YES");
		inventory.setStatus("STOCK");
		inventoryService.addProduct(inventory);
		product = inventory;
		model.put("inventory", product);
		map.addAttribute("message", "Product has been added successfully!!!");
		return "add_product";
	}

	public List<String> getAllList() {
		List<String> completeItemList = new ArrayList<String>();
		completeItemList.addAll(getCategoryList());
		completeItemList.addAll(getBrandsList("All"));
		return completeItemList;
	}

	private List<String> getCategoryList() {
		List<String> listOfCategories = new ArrayList<String>();
		listOfCategories.add("Handbags");
		listOfCategories.add("Watches");
		listOfCategories.add("Footwear");

		return listOfCategories;
	}

	private List<String> getBrandsList(String selectedCategory) {

		List<String> listOfHandbagBrands = new ArrayList<String>();
		listOfHandbagBrands.add("Butterfly");
		listOfHandbagBrands.add("Lavie");
		listOfHandbagBrands.add("Caprese");
		// model.put("listOfWatchBrands", listOfWatchBrands);

		List<String> listOfWatchBrands = new ArrayList<String>();
		listOfWatchBrands.add("Titan Raga");
		listOfWatchBrands.add("Fastrack");
		listOfWatchBrands.add("Casio");
		// model.put("listOfWatchBrands", listOfWatchBrands);

		List<String> listOfFootwearBrands = new ArrayList<String>();
		listOfFootwearBrands.add("Soles");
		listOfFootwearBrands.add("Metro");
		listOfFootwearBrands.add("Catwalk");
		// model.put("listOfFootwearBrands", listOfFootwearBrands);

		List<String> listOfBrands = new ArrayList<String>();
		listOfBrands.addAll(listOfHandbagBrands);
		listOfBrands.addAll(listOfWatchBrands);
		listOfBrands.addAll(listOfFootwearBrands);

		if (StringUtils.hasText(selectedCategory)) {
			if (selectedCategory.equals("Handbags")) {
				return listOfHandbagBrands;
			} else if (selectedCategory.equals("Watches")) {
				return listOfWatchBrands;
			} else if (selectedCategory.equals("Footwear")) {
				return listOfFootwearBrands;
			} else {
				return listOfBrands;
			}
		}

		// model.put("listOfBrands", listOfBrands);
		return listOfBrands;
	}

}
