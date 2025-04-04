package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.mappers.ProductMapper;
import br.com.bytestore.api.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Save new product
	 * @param product
	 */
	public Product store(ProductCreateDTO productDTO)
	{
		Product product = ProductMapper.toEntity(productDTO);
		return productRepository.save(product);
	}
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}

}