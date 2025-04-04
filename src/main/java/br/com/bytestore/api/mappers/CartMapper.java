package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.CartCreateDTO;
import br.com.bytestore.api.dtos.CartResponseDTO;
import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.entites.Cart;
import br.com.bytestore.api.entites.User;

public class CartMapper {
	public static CartResponseDTO toDTO(Cart cart) {
		CartResponseDTO cartResponse = new CartResponseDTO(cart.getId(),cart.getUser());
		return cartResponse;
	}
	public static Cart toEntity(CartCreateDTO cartCreateDTO) {
		Cart cart = new Cart();
		cart.setUser(cartCreateDTO.user());
		return cart;
		
	}

}
