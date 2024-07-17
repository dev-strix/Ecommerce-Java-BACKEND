package com.prjct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prjct.entity.Producto;
import com.prjct.entity.Products;
import com.prjct.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Products> list(){
		return productRepository.findAll();
	}
	
	public Optional<Products> getOne(int id) {
		return productRepository.findById(id);
	}
	public Optional<Products> getByName(String name){
        return productRepository.findByName(name);
    }
	public void save(Products product) {
		productRepository.save(product);
	}
	public void delete(int id){
        productRepository.deleteById(id);
    }
 
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public boolean existsById(int id){
        return productRepository.existsById(id);
    }
	public boolean existsByName(String nombre){
        return productRepository.existsByName(nombre);
    }
	//deberia Retornar una lista ordenada por nombre--para busquedas
	public List<Products> findByNombreContainingOrderBy( String nombre){
		return productRepository.findByNombreContainingOrderBy( nombre);
	}
	
}
