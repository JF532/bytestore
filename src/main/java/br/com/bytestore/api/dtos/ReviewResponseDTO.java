package br.com.bytestore.api.dtos;

import java.time.Instant;

import br.com.bytestore.api.entities.Product;
import br.com.bytestore.api.entities.User;

public record ReviewResponseDTO(Long id, int rating, String comment, User user, Product product, Instant created_at, Instant updated_at) {

}
