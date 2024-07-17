package com.prjct.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prjct.entity.Products;

public class CategoriesDto {
	private int id_categories;
    private String name;
    private String description;
    private String image;
    private String created_at;
    private String updated_at;
    
    private List<ProductDto> productDto;

}
