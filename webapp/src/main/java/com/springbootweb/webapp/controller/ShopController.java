package com.springbootweb.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootweb.webapp.model.Shop;
import com.springbootweb.webapp.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listStocks", shopService.getALLStocks());
		return "index";
	}
	@GetMapping("/showNewShopForm")
	public String showNewShopForm(Model model) {
		Shop shop = new Shop();
		model.addAttribute("shop",shop);
		return "new_shop";
	}
	@PostMapping("/saveShop")
	public String saveShop(@ModelAttribute("shop")Shop shop) {
		shopService.saveShop(shop);
		return "redirect:/indexs";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		Shop shop = shopService.getShopById(id);
		model.addAttribute("shop",shop);
		return "update_shop";
	}
	@GetMapping("/deleteShop/{id}")
	public String deleteShop(@PathVariable (value = "id") long id, Model model) {
		this.shopService.deleteShopById(id);
		return "redirect:/";
	}
}