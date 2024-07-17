package com.prjct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.prjct.entity.Orders;
import com.prjct.seguridad.entity.Usuario;

@Entity
@Table(name = "assignments")
public class Assignments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_assignments;

    private String status;
    private String created_at;
    private String updated_at;

    // Relación con Usuario (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    private Usuario usuario;

    // Relación con Órdenes (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_orders", nullable = false)
    private Orders orders;

	public Assignments() {
		super();
	}

	public Assignments(int id_assignments, String status, String created_at, String updated_at, Usuario usuario,
			Orders orders) {
		super();
		this.id_assignments = id_assignments;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.usuario = usuario;
		this.orders = orders;
	}

	public int getId_assignments() {
		return id_assignments;
	}

	public void setId_assignments(int id_assignments) {
		this.id_assignments = id_assignments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

    // Getters y Setters para las relaciones
    
}