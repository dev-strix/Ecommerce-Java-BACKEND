package com.prjct.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prjct.entity.Categories;
import com.prjct.persistence.ICategoriesDAO;
import com.prjct.repository.CategoriesRepository;

@Component
public class CategoriesDaoImpl implements ICategoriesDAO {
	
	@Autowired
	private CategoriesRepository categoriesRepository;

	@Override
	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}

	@Override
	public Optional<Categories> findById(int id) {
		// TODO Auto-generated method stub
		return categoriesRepository.findById(id);
	}

	@Override
	public void save(Categories categories) {
		// TODO Auto-generated method stub
		categoriesRepository.save(categories);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		categoriesRepository.deleteById(id);
	}

}
