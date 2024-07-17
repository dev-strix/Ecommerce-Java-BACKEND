package com.prjct.seguridad.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjct.dto.Mensaje;
import com.prjct.seguridad.dto.JwtDTO;
import com.prjct.seguridad.dto.LoginUsuario;
import com.prjct.seguridad.dto.NuevoUsuario;
import com.prjct.seguridad.entity.Rol;
import com.prjct.seguridad.entity.Usuario;
import com.prjct.seguridad.enums.RolNombre;
import com.prjct.seguridad.jwt.JwtProvider;
import com.prjct.seguridad.service.RolService;
import com.prjct.seguridad.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	//JSON para crear Admins: {"nombre": "admin", "nombreUsuario": "admin", "email":"admin@mail.com", "password":"admin", "roles":["admin"]}
	//Json para crear Usuarios: {"nombre": "user", "nombreUsuario": "user", "email":"user@mail.com", "password":"user"}
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
		
		if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
		if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
		//esto siempre devuelve TRUE xq aun no implementamos la URL de imagen y reconoce que existe--->(null = null)
		if(usuarioService.existsByPhotoPath(nuevoUsuario.getPhotoPath()) && nuevoUsuario.getPhotoPath()!=null) {
			return new ResponseEntity(new Mensaje("Esa imagen ya existe"), HttpStatus.BAD_REQUEST);}
		
		Usuario usuario = new Usuario(
				nuevoUsuario.getNombre(),
				nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(),
				"verificado",
				passwordEncoder.encode(nuevoUsuario.getPassword()),
				nuevoUsuario.getPhotoPath()+"URL DE IMAGEN...",
				"activo",
				"FechaCreacion por implementar.",
				"FechaUpdate por implementar."
				);
		//Aqui es donde Se define Los Roles al crear un nuevo usuario
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		
		if(nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Nuevo Creado"), HttpStatus.CREATED);
	}
	
	
	//JSON para Login USUARIO: {"nombreUsuario": "user", "password":"user"}
	//JSON para Login ADMIN: {"nombreUsuario": "admin", "password":"admin"}
	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos incorrectos"), HttpStatus.BAD_REQUEST);
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		//Este DTO es el que se le va a mandar al front-end, datos del - session storage
		JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDTO, HttpStatus.OK);
	}
}
