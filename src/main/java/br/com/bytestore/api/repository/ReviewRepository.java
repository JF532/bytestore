package br.com.bytestore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entities.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
//JPA...
	
	
}
