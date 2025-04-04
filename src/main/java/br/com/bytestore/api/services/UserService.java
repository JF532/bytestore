package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.dtos.UserUpdateDTO;
import br.com.bytestore.api.entites.User;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO store(UserCreateDTO userCreateDTO) {
		User user = UserMapper.toEntity(userCreateDTO);
		
		
		UserResponseDTO userResponse = UserMapper.toDTO(userRepository.save(user));
		
		return userResponse;
		}
	
	public List<UserResponseDTO> list(){
		return userRepository.findAll().stream().map(UserMapper::toDTO).toList();
	}
	
	public UserResponseDTO show(long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Usuário com o id " + id + " não encontrado."));
		
		return UserMapper.toDTO(user);
	}
	
	public UserResponseDTO update(UserUpdateDTO userUpdateDTO) {
		
		User user = userRepository.findById(userUpdateDTO.id()).orElseThrow(
				() -> new RuntimeException("Usuário não encontrado."));
		
		user.setName(userUpdateDTO.name());
		user.setEmail(userUpdateDTO.email());
		user.setRole(userUpdateDTO.role());
		user.setPassword(userUpdateDTO.password());
		
		return null;
	}
	
	
	public void destroy(long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Usuário com o id " + id + " deletado."));
		
		userRepository.delete(user);
	}
	
}
