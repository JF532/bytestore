package br.com.bytestore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entites.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
