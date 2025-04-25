package br.com.bytestore.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	Optional<User>findByEmail(String email);
}
