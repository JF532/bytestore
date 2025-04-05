package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.dtos.ProductResponseDTO;
import br.com.bytestore.api.entites.Product;

public class ProductMapper {
	
	public static ProductResponseDTO toDTO(Product product) {
		ProductResponseDTO productResponse = new ProductResponseDTO(product.getId(),product.getName(),product.getDescripton(),product.getPrice(),product.getCategory(),product.getBrand(),product.getImageUrl(),product.getRating(),product.getCreated_at(),product.getUpdated_at());
		return productResponse;
	}
	public static Product toEntity(ProductCreateDTO productCreateDTO) {
		Product product = new Product();
		product.setName(productCreateDTO.name());
		product.setDescripton(productCreateDTO.descripton());
		product.setPrice(productCreateDTO.price());
		product.setCategory(productCreateDTO.category());
		product.setBrand(productCreateDTO.brand());
		product.setImageUrl(productCreateDTO.imageUrl());
		product.setRating(productCreateDTO.rating());

		return product;
	}
	
}
