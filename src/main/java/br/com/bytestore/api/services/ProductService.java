package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.dtos.ProductResponseDTO;
import br.com.bytestore.api.dtos.ProductUpdateDTO;
import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.mappers.ProductMapper;
import br.com.bytestore.api.repository.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	ProductRepository productRepository;

	public ProductResponseDTO store(ProductCreateDTO ProductCreateDTO) {
		Product product = ProductMapper.toEntity(ProductCreateDTO);
		Product productResponse = productRepository.save(product);
		return ProductMapper.toDTO(productResponse);
	}

	public List<ProductResponseDTO> list() {
		return productRepository.findAll().stream().map(ProductMapper::toDTO).toList();
	}

	public ProductResponseDTO update(ProductUpdateDTO productUpdateDTO) {
		Product product = productRepository.findById(productUpdateDTO.id())
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

		product.setName(productUpdateDTO.name());
		product.setDescripton(productUpdateDTO.descripton());;
		product.setPrice(productUpdateDTO.price());
		product.setCategory(productUpdateDTO.category());
		product.setBrand(productUpdateDTO.brand());
		product.setImageUrl(productUpdateDTO.imageUrl());
		product.setRating(productUpdateDTO.rating());

		productRepository.save(product);
		return ProductMapper.toDTO(product);
	}

	public ProductResponseDTO show(long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto com id " + id + " não foi encontrado"));
		return ProductMapper.toDTO(product);
	}

	public void destroy(long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto com o id " + id + "  não encontrado."));
		productRepository.delete(product);
	}

}