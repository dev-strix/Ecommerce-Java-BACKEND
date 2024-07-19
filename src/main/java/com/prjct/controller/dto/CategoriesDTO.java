package com.prjct.controller.dto;

import java.util.List;
import com.prjct.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriesDTO {
	
	private int id;

    private String name;
    private String description;
    private String image;
    private String created_at;
    private String updated_at;
    
    private List<Products> products;
}
