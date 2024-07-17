package com.prjct.seguridad.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	@Column(unique = true)
	private String nombreUsuario;
	@NotNull
	private String email;
	//@NotNull
	private String email_verified_at;
	@NotNull
	private String password;
	//@NotNull
	@Column(name = "photo_path") // Mantén el nombre del campo en la base de datos
    private String photoPath;    // Cambia el nombre de la propiedad en Java
	//@NotNull
	private String estado;
	//@NotNull
    private String created_at;
	//@NotNull
    private String updated_at;
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();
	
	public Usuario() {
		super();
	}
	//constructor inicial Con datos basicos
	/*public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
	}*/
	
	//constructor Actualizado- Usar este
	public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			String email_verified_at, @NotNull String password, String photo_path, String estado, String created_at,
			String updated_at) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.photoPath = photo_path;
		this.estado = estado;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	public String getEmail_verified_at() {
		return email_verified_at;
	}
	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
}
