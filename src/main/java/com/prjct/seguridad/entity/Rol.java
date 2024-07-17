package com.prjct.seguridad.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.prjct.seguridad.enums.RolNombre;

@Entity
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;
	
	
	public Rol() {
		super();
	}
	public Rol(@NotNull RolNombre rolNombre) {
		super();
		this.rolNombre = rolNombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RolNombre getRolNombre() {
		return rolNombre;
	}
	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
}
