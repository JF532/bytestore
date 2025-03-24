package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.entites.User;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.repository.UserRepository;

public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserResponseDTO store(UserCreateDTO userCreateDTO) {
		User user = UserMapper.toEntity(userCreateDTO);
		
		
		UserResponseDTO userResponse = UserMapper.toDTO(userRepository.save(user));
		
		return userResponse;
		}
	
	public List<UserResponseDTO> getAll(){
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}
	
}
