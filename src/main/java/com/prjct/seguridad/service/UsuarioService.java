package com.prjct.seguridad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prjct.seguridad.entity.Usuario;
import com.prjct.seguridad.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public boolean existsByPhotoPath(String photoPath) {
		return usuarioRepository.existsByPhotoPath(photoPath);
	}
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}