package com.prjct.seguridad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjct.seguridad.entity.Rol;
import com.prjct.seguridad.enums.RolNombre;

public interface RolRepository extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
