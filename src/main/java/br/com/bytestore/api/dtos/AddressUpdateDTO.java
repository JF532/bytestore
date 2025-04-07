package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.User;

public record AddressUpdateDTO(long id,String street,String number,String neighborhood,String city,String state,String compliment,long zipcode,User user) {

}
