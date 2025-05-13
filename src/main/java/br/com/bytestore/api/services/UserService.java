package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.dtos.UserUpdateDTO;
import br.com.bytestore.api.entities.Address;
import br.com.bytestore.api.entities.User;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.repository.AddressRepository;
import br.com.bytestore.api.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository adressRepository;
	
	public UserResponseDTO store(UserCreateDTO userCreateDTO) {
		User user = UserMapper.toEntity(userCreateDTO);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User userResponse = userRepository.save(user);
		
		Address adress = new Address();
		adress.setUser(userResponse);
		adressRepository.save(adress);
		
		return UserMapper.toDTO(userResponse);
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
				() -> new RuntimeException("Usuário com o id " + id + "  não encontrado."));
		
		userRepository.delete(user);
	}
	
}
