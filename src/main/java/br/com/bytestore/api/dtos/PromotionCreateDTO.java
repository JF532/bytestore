package br.com.bytestore.api.dtos;


import br.com.bytestore.api.entities.ProductVariation;

public record PromotionCreateDTO(String name, float discountPercentage, boolean isActive, ProductVariation productVariation) {

}
