package com.prjct.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prjct.entity.Products;
import com.prjct.persistence.IProductDAO;
import com.prjct.repository.ProductRepository;

@Component
public class ProductDaoImpl implements IProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Products> findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void save(Products product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
