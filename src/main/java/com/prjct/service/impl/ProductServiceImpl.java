package com.prjct.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjct.entity.Products;
import com.prjct.persistence.IProductDAO;
import com.prjct.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public Optional<Products> findById(int id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id);
	}

	@Override
	public void save(Products product) {
		// TODO Auto-generated method stub
		productDAO.save(product);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);
	}

}
