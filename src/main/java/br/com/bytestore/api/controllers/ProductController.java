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

import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.mappers.ProductMapper;
import br.com.bytestore.api.services.ProductService;

@RestController
@RequestMapping("/api/products")

public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductCreateDTO> createProduct(@RequestBody ProductCreateDTO productDTO) {
		ProductCreateDTO productResponseDTO = ProductMapper.toDTO(productService.store(productDTO));
		return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> listAll()
	{
		return productService.getAll();
	}
}
