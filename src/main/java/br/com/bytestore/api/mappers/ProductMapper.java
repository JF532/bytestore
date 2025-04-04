package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.dtos.ProductResponseDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.entites.Product;

public class ProductMapper {
	public static ProductResponseDTO toDTO(Product product) {
		ProductResponseDTO productResponse = new ProductResponseDTO(product.getName(), product.getPrice());
		return productResponse;
	}
	
	
	public static Product toEntity(ProductCreateDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.name());
		product.setPrice(productDTO.price());
		return product;
	}
	
}
