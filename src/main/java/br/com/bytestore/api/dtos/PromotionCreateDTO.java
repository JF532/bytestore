package br.com.bytestore.api.dtos;


import br.com.bytestore.api.entites.ProductVariation;

public record PromotionCreateDTO(String name, float discountPercentage, boolean isActive, ProductVariation productVariation) {

}
