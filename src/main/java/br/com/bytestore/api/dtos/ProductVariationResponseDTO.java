package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.Product;

public record ProductVariationResponseDTO(Long id, String color, int stock, Product product) {

}
