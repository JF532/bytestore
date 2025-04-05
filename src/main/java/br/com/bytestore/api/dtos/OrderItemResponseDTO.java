package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.Order;
import br.com.bytestore.api.entites.ProductVariation;

public record OrderItemResponseDTO(Long id, int quantity,float subtotal, Order order, ProductVariation productVariation) {

}
