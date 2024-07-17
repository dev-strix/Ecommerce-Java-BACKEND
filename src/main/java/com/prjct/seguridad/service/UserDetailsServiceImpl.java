package com.prjct.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prjct.seguridad.entity.Usuario;
import com.prjct.seguridad.entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UsuarioService usuarioService;
	
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		// TODO Auto-generated method stub
		return UsuarioPrincipal.build(usuario);
	}
	
}
