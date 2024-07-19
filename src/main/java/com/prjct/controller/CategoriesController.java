package com.prjct.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjct.controller.dto.CategoriesDTO;
import com.prjct.entity.Categories;
import com.prjct.service.ICategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private ICategoriesService categoriesService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<Categories> categoriesOptional = categoriesService.findById(id);
		if(categoriesOptional.isPresent()) {
			Categories categories = categoriesOptional.get();
			//Convertimos entity a un DTO
			CategoriesDTO categoriesDTO = new CategoriesDTO().builder()
					.id(categories.getId())
					.name(categories.getName())
					.description(categories.getDescription())
					.image(categories.getImage())
					.created_at(categories.getCreated_at())
					.updated_at(categories.getUpdated_at())
					//Esto muestra el listado de productos
					.products(categories.getProducts())
					.build();
			return ResponseEntity.ok(categoriesDTO);
			}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		List<CategoriesDTO> categoriesList = categoriesService.findAll()
				.stream()
				.map(categories -> new CategoriesDTO().builder()
						.id(categories.getId())
						.name(categories.getName())
						.description(categories.getDescription())
						.image(categories.getImage())
						.created_at(categories.getCreated_at())
						.updated_at(categories.getUpdated_at())
						.products(categories.getProducts())
						.build())
				.toList();
				//.collect(Collectors.toList());
		return ResponseEntity.ok(categoriesList);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody CategoriesDTO categoriesDTO) throws URISyntaxException {
		if(categoriesDTO.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		//convertir Entity a DTO para Guardar
		categoriesService.save(Categories.builder()
				.name(categoriesDTO.getName())
				.description(categoriesDTO.getDescription())
				.image(categoriesDTO.getImage())
				.created_at(categoriesDTO.getCreated_at())
				.updated_at(categoriesDTO.getUpdated_at())
				.build());
		return ResponseEntity.created(new URI("/categories/save")).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategories(@PathVariable int id, @RequestBody CategoriesDTO categoriesDTO) {
		
		Optional<Categories> categoriesOptional = categoriesService.findById(id);
		if(categoriesOptional.isPresent()) {
			Categories categories = categoriesOptional.get();
			categories.setName(categoriesDTO.getName());
			categories.setDescription(categoriesDTO.getDescription());
			categories.setImage(categoriesDTO.getImage());
			categories.setCreated_at(categoriesDTO.getCreated_at());
			categories.setUpdated_at(categoriesDTO.getUpdated_at());
			categoriesService.save(categories);
			return ResponseEntity.ok().build();
			//return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategories(@PathVariable int id) {
		
		if(id != 0) {
			categoriesService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
