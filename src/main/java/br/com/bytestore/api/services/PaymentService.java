package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.PaymentCreateDTO;
import br.com.bytestore.api.dtos.PaymentResponseDTO;
import br.com.bytestore.api.dtos.PaymentUpdateDTO;
import br.com.bytestore.api.entites.Payment;
import br.com.bytestore.api.mappers.PaymentMapper;
import br.com.bytestore.api.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	public PaymentResponseDTO store(PaymentCreateDTO paymentCreateDTO) {
		Payment payment = PaymentMapper.toEntity(paymentCreateDTO);
		Payment paymentResponse = paymentRepository.save(payment);
		return PaymentMapper.toDTO(paymentResponse);
	}
	
	public List<PaymentResponseDTO> list() {
		return paymentRepository.findAll().stream().map(PaymentMapper::toDTO).toList();
	}
	
	public PaymentResponseDTO show (long id) {
		Payment payment = paymentRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Pagamento com id " + id + " não encontrado"));
		return PaymentMapper.toDTO(payment);
	}
	
	public PaymentResponseDTO update(PaymentUpdateDTO paymentUpdateDTO) {
		Payment payment = paymentRepository.findById(paymentUpdateDTO.id())
				.orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
		payment.setOrder(paymentUpdateDTO.order());
		payment.setAmount(paymentUpdateDTO.amount());;
		payment.setPaymentMethod(paymentUpdateDTO.paymentMethod());
		payment.setPaymentStatus(paymentUpdateDTO.paymentStatus());
		
		return PaymentMapper.toDTO(paymentRepository.save(payment));
	}
	
	public void destroy(long id) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pagamentp com o id " + id + "  não encontrado."));
		paymentRepository.delete(payment);
	}
}
