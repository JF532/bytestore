package br.com.bytestore.api.dtos;

import br.com.bytestore.api.enuns.Role;

public record UserResponseDTO(Long id, String name, String email, Role role ) {

}
