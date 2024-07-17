package com.prjct.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.prjct.entity.Products;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories")
    private int id;

    private String name;
    private String description;
    private String image;
    private String created_at;
    private String updated_at;

    // Getters and Setters

    // Relación con Products (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "categories")
    private List<Products> products;

    
	public Categories() {
		super();
	}


	public Categories(int id, String name, String description, String image, String created_at,
			String updated_at, List<Products> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.products = products;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

    // Getters and Setters para la relación
    
}