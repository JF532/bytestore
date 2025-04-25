package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Order;
import br.com.bytestore.api.entities.ProductVariation;

public record OrderItemCreateDTO(int quantity,float subtotal, Order order, ProductVariation productVariation) {

}
