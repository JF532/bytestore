package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.CartCreateDTO;
import br.com.bytestore.api.dtos.CartResponseDTO;
import br.com.bytestore.api.dtos.CartUpdateDTO;
import br.com.bytestore.api.entites.Cart;
import br.com.bytestore.api.mappers.CartMapper;
import br.com.bytestore.api.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	public CartResponseDTO store(CartCreateDTO cartCreateDTO) {
		Cart cart = CartMapper.toEntity(cartCreateDTO);
		
		
		CartResponseDTO cartResponse = CartMapper.toDTO(cartRepository.save(cart));
		
		return cartResponse;
		}
	
	public List<CartResponseDTO> list(){
		return cartRepository.findAll().stream().map(CartMapper::toDTO).toList();
	}
	
	
	public CartResponseDTO show(long id) {
		Cart cart = cartRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Cart com o id " + id + " não encontrado."));
		
		return CartMapper.toDTO(cart);
	}
	
	public CartResponseDTO update(CartUpdateDTO cartUpdateDTO) { //N sei
		
		Cart cart = cartRepository.findById(cartUpdateDTO.id()).orElseThrow(
				() -> new RuntimeException("Cart não encontrado."));
		
		//cart.setName(userUpdateDTO.name());
		//user.setEmail(userUpdateDTO.email());
		//user.setRole(userUpdateDTO.role());
		//user.setPassword(userUpdateDTO.password());
		
		return null;
	}
	
	
	public void destroy(long id) {
		Cart cart = cartRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Cart com o id " + id + " deletado."));
		
		cartRepository.delete(cart);
	}
	

}
