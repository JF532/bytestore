package br.com.bytestore.api.dtos;


import java.time.Instant;

import br.com.bytestore.api.entites.ProductVariation;

public record PromotionResponseDTO(Long id, String name, float discountPercentage, Instant startDate, Instant endDate, boolean isActive, ProductVariation productVariation) {

}
