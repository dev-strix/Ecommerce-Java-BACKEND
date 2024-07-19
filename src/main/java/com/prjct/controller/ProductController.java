package com.prjct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjct.controller.dto.ProductDTO;
//import com.prjct.dto.ProductDto;
import com.prjct.entity.Products;
//import com.prjct.service.ProductService;
import com.prjct.service.IProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		
		Optional<Products> productOptional = productService.findById(id);
		if(productOptional.isPresent()) {
			Products product = productOptional.get();
			//convertimos DTO a un entity
			ProductDTO productDTO = new ProductDTO().builder()
					.id(product.getId())
					.name(product.getName())
					.price(product.getPrice())
					.percentage_discount(product.getPercentage_discount())
					.estado(product.getEstado())
					.available(product.getAvailable())
					.stock(product.getStock())
					.unidad_medida(product.getUnidad_medida())
					.description(product.getDescription())
					.imagePath(product.getImagePath())
					.created_at(product.getCreated_at())
					.updated_at(product.getUpdated_at())
					.name_category(product.getCategories().getName())//Name de Entidad categories
					.nameOfUser(product.getUsuario().getNombre())//Name de Entidad usuario
					.imagesList(product.getImages())//obtenemos Array[] de imagenes
					.build();

			return ResponseEntity.ok(productDTO);
		}
		return ResponseEntity.notFound().build();
	}
}
