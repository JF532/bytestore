package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.User;

public record CartUpdateDTO(Long id, User user) {

}
