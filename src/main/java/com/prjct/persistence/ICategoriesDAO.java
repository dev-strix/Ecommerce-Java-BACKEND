package com.prjct.persistence;

import java.util.List;
import java.util.Optional;

import com.prjct.entity.Categories;

public interface ICategoriesDAO {
	List<Categories> findAll();
	
	Optional<Categories> findById(int id);
	//Products findByName(String name);
	
	void save(Categories categories);
	
	void deleteById(int id);
}
