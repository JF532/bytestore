package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.entities.User;

public class UserMapper {
	
		public static UserResponseDTO toDTO(User user) {
			UserResponseDTO userResponse = new UserResponseDTO(user.getId(),user.getName(),user.getEmail(),user.getRole(),user.getCreated_at(),user.getUpdated_at());
			return userResponse;
		}
		
		public static User toEntity(UserCreateDTO userCreateDTO) {
			User user = new User();
			user.setName(userCreateDTO.name());
			user.setEmail(userCreateDTO.email());
			user.setPassword(userCreateDTO.email());
			user.setRole(userCreateDTO.role());
			return user;
			
		}
	
}
