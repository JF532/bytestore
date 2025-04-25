package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Product;
import br.com.bytestore.api.entities.User;

public record ReviewUpdateDTO(Long id, int rating, String comment, User user, Product product) {

}
