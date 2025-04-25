package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Product;

public record ProductVariationResponseDTO(Long id, String color, int stock, Product product) {

}
