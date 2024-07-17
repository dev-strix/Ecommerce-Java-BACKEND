package com.prjct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.prjct.entity.Categories;
import com.prjct.seguridad.entity.Usuario;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private int id;

    private String name;
    private double price;
    private double percentage_discount;
    private String estado;
    private String available;
    private double stock;
    private String unidad_medida;
    @Column(length = 900)
    private String description;
    @Column(name = "image_path", length = 900)
    private String imagePath;
    private String created_at;
    private String updated_at;

    // Getters y Setters

    // Relación con Categorías (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_categories", nullable = false)
    private Categories categories;

    // Relación con Usuario (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    private Usuario usuario;

    
	public Products() {
		super();
	}



	public Products(int id_products, String name, double price, double percentage_discount, String estado,
			String available, double stock, String unidad_medida, String description, String imagePath,
			String created_at, String updated_at, Categories categories, Usuario usuario) {
		super();
		this.id = id_products;
		this.name = name;
		this.price = price;
		this.percentage_discount = percentage_discount;
		this.estado = estado;
		this.available = available;
		this.stock = stock;
		this.unidad_medida = unidad_medida;
		this.description = description;
		this.imagePath = imagePath;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.categories = categories;
		this.usuario = usuario;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPercentage_discount() {
		return percentage_discount;
	}

	public void setPercentage_discount(double percentage_discount) {
		this.percentage_discount = percentage_discount;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    // Getters y Setters para las relaciones
    
}