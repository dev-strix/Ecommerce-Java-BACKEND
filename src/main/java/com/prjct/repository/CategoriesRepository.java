package com.prjct.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prjct.entity.Categories;
import com.prjct.entity.Producto;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

	//Query Methods
    Optional<Categories> findByName(String name);
    boolean existsByName(String name);
    //deberia Retornar una lista ordenada por nombre--para busquedas
    /*@Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:subString% ORDER BY p.nombre")
    List<Producto> findByNombreContainingOrderBy(@Param("subString") String subString);*/
}
