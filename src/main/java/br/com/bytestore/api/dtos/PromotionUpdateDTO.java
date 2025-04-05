package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.ProductVariation;

public record PromotionUpdateDTO(Long id, String name, float discountPercentage, boolean isActive, ProductVariation productVariation) {

}
