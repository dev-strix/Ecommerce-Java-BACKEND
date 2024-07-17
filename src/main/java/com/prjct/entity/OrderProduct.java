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
import com.prjct.entity.Products;

@Entity
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order_product;

    private double quantity;
    private double total_discount_unit;
    private double total_price_unit;
    private String created_at;
    private String updated_at;

    // Relación con Órdenes (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_orders", nullable = false)
    private Orders orders;

    // Relación con Productos (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_products", nullable = false)
    private Products products;

    
	public OrderProduct() {
		super();
	}

	public OrderProduct(int id_order_product, double quantity, double total_discount_unit, double total_price_unit,
			String created_at, String updated_at, Orders orders, Products products) {
		super();
		this.id_order_product = id_order_product;
		this.quantity = quantity;
		this.total_discount_unit = total_discount_unit;
		this.total_price_unit = total_price_unit;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.orders = orders;
		this.products = products;
	}

	public int getId_order_product() {
		return id_order_product;
	}

	public void setId_order_product(int id_order_product) {
		this.id_order_product = id_order_product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotal_discount_unit() {
		return total_discount_unit;
	}

	public void setTotal_discount_unit(double total_discount_unit) {
		this.total_discount_unit = total_discount_unit;
	}

	public double getTotal_price_unit() {
		return total_price_unit;
	}

	public void setTotal_price_unit(double total_price_unit) {
		this.total_price_unit = total_price_unit;
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

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

    // Getters y Setters para las relaciones
    
}