package br.com.bytestore.api.dtos;

import br.com.bytestore.api.enuns.Role;

public record UserCreateDTO(String name, String email, String password, Role role) {

}
