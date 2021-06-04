package com.springbootweb.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootweb.webapp.model.Shop;
import com.springbootweb.webapp.repository.ShopRespository;
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private  ShopRespository shopRespository;

	@Override
	public List<Shop> getALLStocks() {
		// TODO Auto-generated method stub
		return shopRespository.findAll();
	}
	@Override
	public void saveShop(Shop shop) {
		// TODO Auto-generated method stub
		this.shopRespository.save(shop);	
	}
	@Override
	public Shop getShopById(long id) {
		Optional<Shop> optional = shopRespository.findById(id);
		Shop shop = null;
		if(optional.isPresent()) {
			shop = optional.get();
		}else {
			throw new RuntimeException("Stock not Found "+id);
		}
		return shop;
	}
	@Override
	public void deleteShopById(long id) {
		// TODO Auto-generated method stub
		this.shopRespository.deleteById(id);
	}
}
