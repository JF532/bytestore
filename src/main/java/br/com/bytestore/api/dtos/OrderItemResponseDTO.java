package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Order;
import br.com.bytestore.api.entities.ProductVariation;

public record OrderItemResponseDTO(Long id, int quantity,float subtotal, Order order, ProductVariation productVariation) {

}
