package br.com.bytestore.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bytestore.api.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
