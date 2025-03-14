package br.com.bytestore.api.controllers;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.services.ProductService;

@RestController
@RequestMapping("/api/products")

public class ProductController {

	@Autowired
	ProductService productService;

	public void createProduct(Product product) {

		productService.store(product);
	}

}
