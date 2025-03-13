package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.repository.ProductRepository;

public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Save new product
	 * @param product
	 */
	public void store(Product product)
	{
		productRepository.save(product);
	}

}