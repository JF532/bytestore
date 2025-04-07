package br.com.bytestore.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.com.bytestore.api.entites.Cart;
import br.com.bytestore.api.entites.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	@NativeQuery("SELECT cart_items.* FROM cart_items JOIN carts ON carts.id = cart.items.cart_id WHERE carts.id = :id")
	public List<CartItem> listCartItems(Long id);

}
