package com.prjct.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.prjct.entity.Products;
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

    // Relación con Products (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Products> products;

}
/*JSON para esta entidad
 * {
    "name": "Deporte",
    "description": "Articulos para el deporte",
    "image": "http://imagen_de_Deporte",
    "created_at": "31-3-2021",
    "updated_at": "33-3-2021"
	}
 * */