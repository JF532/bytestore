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

import br.com.bytestore.api.dtos.PaymentCreateDTO;
import br.com.bytestore.api.dtos.PaymentResponseDTO;
import br.com.bytestore.api.dtos.PaymentUpdateDTO;
import br.com.bytestore.api.services.PaymentService;
import br.com.bytestore.api.services.ProductService;

@RestController
@RequestMapping("/api/payments")
public class PaymenrtController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<PaymentResponseDTO> store(@RequestBody PaymentCreateDTO paymentCreateDTO) {
		return  new ResponseEntity<>(paymentService.store(paymentCreateDTO),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PaymentResponseDTO>> list()
	{
		return new ResponseEntity<>(paymentService.list(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id_payment}")
	public ResponseEntity<PaymentResponseDTO> show(@PathVariable long id_payment){
		try {
			return new ResponseEntity(paymentService.show(id_payment),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PatchMapping
	public ResponseEntity<PaymentResponseDTO> update(@RequestBody PaymentUpdateDTO paymentUpdateDTO) {
		try {
			return new ResponseEntity(paymentService.update(paymentUpdateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id_payment}")
	public ResponseEntity<PaymentResponseDTO> destroy(@PathVariable long id_payment){
		try {
			paymentService.destroy(id_payment);
			return new ResponseEntity("Pagamento deletado com sucesso",HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
