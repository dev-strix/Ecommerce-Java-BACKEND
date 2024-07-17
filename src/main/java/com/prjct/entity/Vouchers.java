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

@Entity
@Table(name = "vouchers")
public class Vouchers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idvouchers;

    private String image_path;
    private String method;
    private String operation_code;
    private String operation_date;
    private double monto;
    private String created_at;
    private String updated_at;

    // Relación con Órdenes (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_orders", nullable = false)
    private Orders orders;

    
	public Vouchers() {
		super();
	}

	public Vouchers(int idvouchers, String image_path, String method, String operation_code, String operation_date,
			double monto, String created_at, String updated_at, Orders orders) {
		super();
		this.idvouchers = idvouchers;
		this.image_path = image_path;
		this.method = method;
		this.operation_code = operation_code;
		this.operation_date = operation_date;
		this.monto = monto;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.orders = orders;
	}

	public int getIdvouchers() {
		return idvouchers;
	}

	public void setIdvouchers(int idvouchers) {
		this.idvouchers = idvouchers;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOperation_code() {
		return operation_code;
	}

	public void setOperation_code(String operation_code) {
		this.operation_code = operation_code;
	}

	public String getOperation_date() {
		return operation_date;
	}

	public void setOperation_date(String operation_date) {
		this.operation_date = operation_date;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
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

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

    // Getters y Setters para la relación
    
}