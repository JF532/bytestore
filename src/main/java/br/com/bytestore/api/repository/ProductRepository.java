package br.com.bytestore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}