package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.entites.User;

public class UserMapper {
	
	public static UserResponseDTO toDTO(User user) {
		return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(),user.isAdmin());
	}
	
	public static User toEntity(UserCreateDTO userCreateDTO) {
		User user = new User();
		user.setName(userCreateDTO.name());
		user.setEmail(userCreateDTO.email());
		user.setPassword(userCreateDTO.password());
		
		return user;
	}
}
