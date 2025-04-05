package br.com.bytestore.api.dtos;

import java.time.Instant;

import br.com.bytestore.api.enuns.Role;

public record UserResponseDTO(Long id, String name, String email, Role role, Instant created_at, Instant updated_at ) {

}
