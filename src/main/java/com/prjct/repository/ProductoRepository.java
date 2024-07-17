package com.prjct.repository;

import com.prjct.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	//Query Methods
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    //deberia Retornar una lista ordenada por nombre--para busquedas
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:subString% ORDER BY p.nombre")
    List<Producto> findByNombreContainingOrderBy(@Param("subString") String subString);

}
