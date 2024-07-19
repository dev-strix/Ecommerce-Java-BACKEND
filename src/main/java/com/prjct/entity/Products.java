package com.prjct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.prjct.entity.Categories;
import com.prjct.seguridad.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Images> images;
}