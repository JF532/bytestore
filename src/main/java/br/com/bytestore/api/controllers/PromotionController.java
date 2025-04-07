package br.com.bytestore.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bytestore.api.dtos.PromotionCreateDTO;
import br.com.bytestore.api.dtos.PromotionResponseDTO;
import br.com.bytestore.api.dtos.PromotionUpdateDTO;
import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.dtos.UserUpdateDTO;
import br.com.bytestore.api.services.PromotionService;
import br.com.bytestore.api.services.UserService;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	@PostMapping
	public ResponseEntity<PromotionResponseDTO> store(@RequestBody PromotionCreateDTO promotionCreateDTO) {
		return  new ResponseEntity<>(promotionService.store(promotionCreateDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PromotionResponseDTO>> list()
	{
		return new ResponseEntity<>(promotionService.list(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_promotion}")
	public ResponseEntity<PromotionResponseDTO> show(@PathVariable long id_promotion){
		try {
			return new ResponseEntity(promotionService.show(id_promotion),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PatchMapping
	public ResponseEntity<PromotionResponseDTO> update(@RequestBody PromotionUpdateDTO promotionUpdateDTO) {
		try {
			return new ResponseEntity(promotionService.update(promotionUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_promotion}")
	public ResponseEntity<PromotionResponseDTO> destroy(@PathVariable long id_promotion){
		try {
			promotionService.destroy(id_promotion);
			return new ResponseEntity("Promotion deletada com sucesso",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
