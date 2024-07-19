package com.prjct.controller.dto;

import java.util.List;

import com.prjct.entity.Categories;
import com.prjct.entity.Images;
import com.prjct.seguridad.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
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

    //private Categories categories;//Necesario para llamar a sus propiedades
    private String name_category; //variable Solo para DTO
    
    //private Usuario usuario;//Necesario para llamar a sus propiedades
    private String nameOfUser;//variable Solo para DTO
    
    private List<Images> imagesList;
}
