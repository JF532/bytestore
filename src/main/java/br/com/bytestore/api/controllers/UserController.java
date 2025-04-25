package br.com.bytestore.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytestore.api.auth.JwtService;
import br.com.bytestore.api.dtos.AuthDTO;
import br.com.bytestore.api.dtos.ProductCreateDTO;
import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.dtos.UserUpdateDTO;
import br.com.bytestore.api.entities.User;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	
	public UserController(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		
	}
	

	
	
	@PostMapping("auth")
	public ResponseEntity<?> auth(@RequestBody AuthDTO authDTO){
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDTO.email(),authDTO.password()));
				
				
			User user = (User) auth.getPrincipal();
			String token = jwtService.generateToken(user);
			
			return new ResponseEntity<>(Map.of("token",token),HttpStatus.OK);
	}
	
	@PostMapping("register")
	public ResponseEntity<UserResponseDTO> store(@RequestBody UserCreateDTO userCreateDTO) {
		return  new ResponseEntity<>(userService.store(userCreateDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> list()
	{
		return new ResponseEntity<>(userService.list(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_user}")
	public ResponseEntity<UserResponseDTO> show(@PathVariable long id_user){
		try {
			return new ResponseEntity(userService.show(id_user),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PatchMapping
	public ResponseEntity<UserResponseDTO> update(@RequestBody UserUpdateDTO userUpdateDTO) {
		try {
			return new ResponseEntity(userService.update(userUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_user}")
	public ResponseEntity<UserResponseDTO> destroy(@PathVariable long id_user){
		try {
			userService.destroy(id_user);
			return new ResponseEntity("Usuario deletado com sucesso",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
}
