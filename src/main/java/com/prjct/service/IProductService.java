package com.prjct.service;

import java.util.List;
import java.util.Optional;

import com.prjct.entity.Products;

public interface IProductService {
	List<Products> findAll();
	
	Optional<Products> findById(int id);
	//Products findByName(String name);
	
	void save(Products product);
	
	void deleteById(int id);
}
