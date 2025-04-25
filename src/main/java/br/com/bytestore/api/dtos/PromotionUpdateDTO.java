package br.com.bytestore.api.dtos;

import java.time.Instant;

import br.com.bytestore.api.entities.ProductVariation;

public record PromotionUpdateDTO(Long id, String name, float discountPercentage, boolean isActive, ProductVariation productVariation, Instant startDate, Instant endDate) {

}
