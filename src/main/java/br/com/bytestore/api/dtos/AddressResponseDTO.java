package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.User;

public record AddressResponseDTO(long id,String street,String number,String neighborhood,String city,String state,String compliment,long zipcode,User user) {

}
