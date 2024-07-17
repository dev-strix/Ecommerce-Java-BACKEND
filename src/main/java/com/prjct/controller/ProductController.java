package com.prjct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prjct.dto.ProductDto;
import com.prjct.entity.Products;
import com.prjct.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Products>> list(){
		List<Products> list = productService.list(); //mejorar esto a ProductDTO
		return new ResponseEntity(list,HttpStatus.OK);
	}
	/*@GetMapping("/list")
	public String list(){
		//List<Products> list = productService.list(); //mejorar esto a ProductDTO
		return "[\r\n"
				+ "  {\r\n"
				+ "    \"nombre\": \"Pepito Conejo\",\r\n"
				+ "    \"edad\": 25,\r\n"
				+ "    \"carnet de conducir\": true\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"nombre\": \"Ana Barberá\",\r\n"
				+ "    \"edad\": 90,\r\n"
				+ "    \"carnet de conducir\": false\r\n"
				+ "  }\r\n"
				+ "]";
	}*/
}
