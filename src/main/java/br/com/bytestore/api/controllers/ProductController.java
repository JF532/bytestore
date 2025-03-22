package br.com.bytestore.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytestore.api.dtos.ProductDTO;
import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.services.ProductService;

@RestController
@RequestMapping("/api/products")

public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {

		return new ResponseEntity<>(productService.store(productDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<ProductDTO> listAll()
	{
		return productService.getAll();
	}
}
