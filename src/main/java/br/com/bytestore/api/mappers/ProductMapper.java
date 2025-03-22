package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.ProductDTO;
import br.com.bytestore.api.entites.Product;

public class ProductMapper {
	public static ProductDTO toDTO(Product product) {
		
		return new ProductDTO(product.getName(), product.getPrice(),product.getStock());
	}
	
	public static Product toEntinty(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.name());
		product.setPrice(productDTO.price());
		product.setStock(productDTO.stock());
		return product;
	}
}
