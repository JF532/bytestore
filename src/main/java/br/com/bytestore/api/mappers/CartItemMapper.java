package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.CartItemCreateDTO;
import br.com.bytestore.api.dtos.CartItemResponseDTO;
import br.com.bytestore.api.entities.CartItem;

public class CartItemMapper {
	public static CartItemResponseDTO toDTO(CartItem cartItem) {
		CartItemResponseDTO cartItemResponse = new CartItemResponseDTO(cartItem.getId(),cartItem.getQuantity(),cartItem.getSubtotal(),cartItem.getCart(),cartItem.getProductVariation());
		return cartItemResponse;
	}
	
	public static CartItem toEntity(CartItemCreateDTO cartItemCreateDTO) {
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(cartItemCreateDTO.quantity());
		cartItem.setSubtotal(cartItemCreateDTO.subtotal());
		cartItem.setCart(cartItemCreateDTO.cart());
		cartItem.setProductVariation(cartItemCreateDTO.productVariation());
		
		return cartItem;
		
	}
}
