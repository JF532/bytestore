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

import br.com.bytestore.api.dtos.CartCreateDTO;
import br.com.bytestore.api.dtos.CartResponseDTO;
import br.com.bytestore.api.dtos.CartUpdateDTO;
import br.com.bytestore.api.dtos.OrderCreateDTO;
import br.com.bytestore.api.dtos.OrderResponseDTO;
import br.com.bytestore.api.dtos.OrderUpdateDTO;
import br.com.bytestore.api.services.CartService;
import br.com.bytestore.api.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponseDTO> store(@RequestBody OrderCreateDTO orderCreateDTO) {
		return  new ResponseEntity<>(orderService.store(orderCreateDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> list()
	{
		return new ResponseEntity<>(orderService.list(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_order}")
	public ResponseEntity<OrderResponseDTO> show(@PathVariable long id_order){
		try {
			return new ResponseEntity(orderService.show(id_order),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PatchMapping
	public ResponseEntity<OrderResponseDTO> update(@RequestBody OrderUpdateDTO orderUpdateDTO) {
		try {
			return new ResponseEntity(orderService.update(orderUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_order}")
	public ResponseEntity<OrderResponseDTO> destroy(@PathVariable long id_order){
		try {
			orderService.destroy(id_order);
			return new ResponseEntity("Order deletada com sucesso",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}
