package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.Product;
import br.com.bytestore.api.entites.User;

public record ReviewCreateDTO(int rating, String comment, User user, Product product) {

}
