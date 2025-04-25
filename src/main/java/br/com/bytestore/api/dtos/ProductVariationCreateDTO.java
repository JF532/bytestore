package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Product;

public record ProductVariationCreateDTO(String color, int stock, Product product) {

}
