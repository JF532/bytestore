package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.Cart;
import br.com.bytestore.api.entites.ProductVariation;

public record CartItemUpdateDTO(Long id, int quantity,float subtotal, Cart cart, ProductVariation productVariation) {
}


