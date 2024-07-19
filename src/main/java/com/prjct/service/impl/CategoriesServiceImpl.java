package com.prjct.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjct.entity.Categories;
import com.prjct.persistence.ICategoriesDAO;
import com.prjct.service.ICategoriesService;

@Service
public class CategoriesServiceImpl implements ICategoriesService {
	
	@Autowired
	private ICategoriesDAO categoriesDAO;
	
	@Override
	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return categoriesDAO.findAll();
	}

	@Override
	public Optional<Categories> findById(int id) {
		// TODO Auto-generated method stub
		return categoriesDAO.findById(id);
	}

	@Override
	public void save(Categories categories) {
		// TODO Auto-generated method stub
		categoriesDAO.save(categories);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		categoriesDAO.deleteById(id);
	}

}
