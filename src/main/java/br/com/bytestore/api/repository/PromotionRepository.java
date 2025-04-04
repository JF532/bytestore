package br.com.bytestore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entites.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{

}
