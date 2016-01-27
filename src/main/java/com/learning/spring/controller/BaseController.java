package com.learning.spring.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.StringUtils;

public class BaseController {

	public List<String> searchList(String name) {
		String inputText = "";
		List<String> matchedList = new ArrayList<String>();

		for (int i = 0; i < getAllList().size(); i++) {
			inputText = getAllList().get(i).toLowerCase();
			if (inputText.startsWith(name.toLowerCase())) {
				matchedList.add(getAllList().get(i));
			}
		}

		return matchedList;
	}

	public List<String> getAllList() {
		List<String> completeItemList = new ArrayList<String>();
		completeItemList.addAll(getCategoryList());
		completeItemList.addAll(getColorList());
		completeItemList.addAll(getBrandsList("All"));

		Collections.sort(completeItemList);
		return completeItemList;
	}

	public List<String> getColorList() {
		List<String> listOfColors = new ArrayList<String>();
		listOfColors.add("Red");
		listOfColors.add("Green");
		listOfColors.add("White");
		listOfColors.add("Black");
		listOfColors.add("Blue");
		listOfColors.add("Yellow");
		listOfColors.add("Pink");

		Collections.sort(listOfColors);
		return listOfColors;
	}

	public List<String> getCategoryList() {
		List<String> listOfCategories = new ArrayList<String>();
		listOfCategories.add("Handbags");
		listOfCategories.add("Watches");
		listOfCategories.add("Footwear");

		Collections.sort(listOfCategories);
		return listOfCategories;
	}

	public List<String> getBrandsList(String selectedCategory) {

		List<String> listOfHandbagBrands = new ArrayList<String>();
		listOfHandbagBrands.add("Butterfly");
		listOfHandbagBrands.add("Lavie");
		listOfHandbagBrands.add("Caprese");

		List<String> listOfWatchBrands = new ArrayList<String>();
		listOfWatchBrands.add("Titan Raga");
		listOfWatchBrands.add("Fastrack");
		listOfWatchBrands.add("Casio");

		List<String> listOfFootwearBrands = new ArrayList<String>();
		listOfFootwearBrands.add("Soles");
		listOfFootwearBrands.add("Metro");
		listOfFootwearBrands.add("Catwalk");

		List<String> listOfBrands = new ArrayList<String>();

		if (StringUtils.hasText(selectedCategory)) {
			if (selectedCategory.equals("Handbags")) {
				listOfBrands.addAll(listOfHandbagBrands);
			} else if (selectedCategory.equals("Watches")) {
				listOfBrands.addAll(listOfWatchBrands);
			} else if (selectedCategory.equals("Footwear")) {
				listOfBrands.addAll(listOfFootwearBrands);
			} else {
				listOfBrands.addAll(listOfHandbagBrands);
				listOfBrands.addAll(listOfWatchBrands);
				listOfBrands.addAll(listOfFootwearBrands);
			}
		}

		Collections.sort(listOfBrands);
		return listOfBrands;
	}
}
