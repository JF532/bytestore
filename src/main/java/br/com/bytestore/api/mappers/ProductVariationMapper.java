package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.ProductVariationCreateDTO;
import br.com.bytestore.api.dtos.ProductVariationResponseDTO;
import br.com.bytestore.api.entities.ProductVariation;

public class ProductVariationMapper {
	public static ProductVariationResponseDTO toDTO(ProductVariation productVariation) {
		ProductVariationResponseDTO productVariationResponse = new ProductVariationResponseDTO(productVariation.getId(),productVariation.getColor(),productVariation.getStock(),productVariation.getProduct());
		return productVariationResponse;
	}
	public static ProductVariation toEntity(ProductVariationCreateDTO productVariationCreateDTO) {
		ProductVariation productVariation = new ProductVariation();
		productVariation.setColor(productVariationCreateDTO.color());
		productVariation.setStock(productVariationCreateDTO.stock());
		productVariation.setProduct(productVariationCreateDTO.product());

		return productVariation;
	}
}
