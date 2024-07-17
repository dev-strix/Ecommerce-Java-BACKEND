package com.prjct.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prjct.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	//Query Methods
	Optional<Products> findByName(String nombre);
	boolean existsByName(String nombre);
	// deberia Retornar una lista ordenada por nombre--para busquedas
	@Query("SELECT p FROM Products p WHERE p.name LIKE %:subString% ORDER BY p.name")
	List<Products> findByNombreContainingOrderBy(String subString);
}
