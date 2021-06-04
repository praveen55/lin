package com.springbootweb.webapp.service;

import java.util.List;

import com.springbootweb.webapp.model.Shop;

public interface ShopService {
	List<Shop> getALLStocks();
	void saveShop(Shop shop);
	Shop getShopById(long id);
	void deleteShopById(long id);
}