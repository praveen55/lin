package com.springbootweb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootweb.webapp.model.Shop;

@Repository
public interface ShopRespository extends JpaRepository<Shop, Long>{

}
