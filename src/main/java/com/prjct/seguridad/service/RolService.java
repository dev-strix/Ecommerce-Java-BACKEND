package com.prjct.seguridad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prjct.seguridad.entity.Rol;
import com.prjct.seguridad.enums.RolNombre;
import com.prjct.seguridad.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}