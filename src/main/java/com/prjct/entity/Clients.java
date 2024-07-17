package com.prjct.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.prjct.entity.Orders;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clients;

    private String username;
    private String name;
    private String last_name;
    private String email;
    private String profile_photo;
    private String password;
    private String departamento;
    private String provincia;
    private String distrito;
    private String telefono;
    private String direccion;
    private String referencia;
    private String email_verified_at;
    private String created_at;
    private String updated_at;

    // Getters y Setters

    // Relación con Órdenes (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "clients")
    private List<Orders> orders;

    
	public Clients() {
		super();
	}

	public Clients(int id_clients, String username, String name, String last_name, String email, String profile_photo,
			String password, String departamento, String provincia, String distrito, String telefono, String direccion,
			String referencia, String email_verified_at, String created_at, String updated_at, List<Orders> orders) {
		super();
		this.id_clients = id_clients;
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.profile_photo = profile_photo;
		this.password = password;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.telefono = telefono;
		this.direccion = direccion;
		this.referencia = referencia;
		this.email_verified_at = email_verified_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.orders = orders;
	}

	public int getId_clients() {
		return id_clients;
	}

	public void setId_clients(int id_clients) {
		this.id_clients = id_clients;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

    // Getters y Setters para la relación
    
}