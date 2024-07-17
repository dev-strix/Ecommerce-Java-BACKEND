package com.prjct.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prjct.seguridad.entity.Rol;
import com.prjct.seguridad.enums.RolNombre;
import com.prjct.seguridad.service.RolService;


@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		// ESTO ES SOLO UNA PRUEBA DE CREAR ROL
		/*Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		rolService.save(rolAdmin);
		rolService.save(rolUser);
		
		Rol rolSupport = new Rol(RolNombre.ROLE_SUPPORT);
		rolService.save(rolSupport);
		
		Rol rolViewer = new Rol(RolNombre.ROLE_VIEWER);
		rolService.save(rolViewer);
		
		Rol rolContributor = new Rol(RolNombre.ROLE_CONTRIBUTOR);
		rolService.save(rolContributor);
		
		Rol rolManager = new Rol(RolNombre.ROLE_MANAGER);
		rolService.save(rolManager);
		
		Rol rolOperations = new Rol(RolNombre.ROLE_OPERATIONS);
		rolService.save(rolOperations);
		
		Rol rolFinance = new Rol(RolNombre.ROLE_FINANCE);
		rolService.save(rolFinance);*/
	}
}
