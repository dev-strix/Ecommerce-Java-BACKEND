package com.prjct.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prjct.entity.Categories;
import com.prjct.seguridad.entity.Usuario;

public class ProductDto {
	
    private int id;
    private String name;
    private double price;
    private double percentage_discount;
    private String estado;
    private String available;
    private double stock;
    private String unidad_medida;
    private String description;
    private String imagePath;
    private String created_at;
    private String updated_at;

    private CategoriesDto categoriesDto;
    private Usuario usuario;//corregir esto. Es mala practica
	public ProductDto() {
		super();
	}
	//Constructor para crear un nuevo producto
	public ProductDto(String name, double price, double percentage_discount, String estado, String available,
			double stock, String unidad_medida, String description, String imagePath, String created_at,
			String updated_at, CategoriesDto categoriesDto, Usuario usuario) {
		super();
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
		this.categoriesDto = categoriesDto;
		this.usuario = usuario;
	}
	//Constructor para actualizar Productos
	/*
	 * Se excluyen los campos created_at y updated_at y usuario
	 * porque son campos que el sistema es el responsable
	 * al momento de crearlos o actualizarlos
	 * */
	public ProductDto(int id, String name, double price, double percentage_discount, String estado, String available,
			double stock, String unidad_medida, String description, String imagePath, CategoriesDto categoriesDto) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.percentage_discount = percentage_discount;
		this.estado = estado;
		this.available = available;
		this.stock = stock;
		this.unidad_medida = unidad_medida;
		this.description = description;
		this.imagePath = imagePath;
		this.categoriesDto = categoriesDto;
	}
	//Constructor para listar Productos
	public ProductDto(int id, String name, double price, double percentage_discount, String estado, String available,
			double stock, String unidad_medida, String description, String imagePath, String created_at,
			String updated_at, CategoriesDto categoriesDto, Usuario usuario) {
		super();
		this.id = id;
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
		this.categoriesDto = categoriesDto;
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
	public CategoriesDto getCategoriesDto() {
		return categoriesDto;
	}
	public void setCategoriesDto(CategoriesDto categoriesDto) {
		this.categoriesDto = categoriesDto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
