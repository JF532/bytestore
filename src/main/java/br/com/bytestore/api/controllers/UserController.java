package br.com.bytestore.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytestore.api.dtos.ProductDTO;
import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
		UserResponseDTO userResponseDTO = userService.store(userCreateDTO); //Ele já retorna um DTO então n precisa converter
		return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<UserResponseDTO> listAll()
	{
		return userService.getAll();
	}
}
