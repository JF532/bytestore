package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Cart;
import br.com.bytestore.api.entities.ProductVariation;

public record CartItemResponseDTO(Long id, int quantity,float subtotal, Cart cart, ProductVariation productVariation) {

}
