package com.prjct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.prjct.entity.Products;

@Entity
@Table(name = "images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_images;

    private String image_path;
    private String name;

    // Relación con Productos (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_products", nullable = false)
    private Products products;

    
	public Images() {
		super();
	}

	public Images(int id_images, String image_path, String name, Products products) {
		super();
		this.id_images = id_images;
		this.image_path = image_path;
		this.name = name;
		this.products = products;
	}

	public int getId_images() {
		return id_images;
	}

	public void setId_images(int id_images) {
		this.id_images = id_images;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

    // Getters y Setters para la relación
    
}
