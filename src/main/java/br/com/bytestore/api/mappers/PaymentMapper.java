package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.PaymentCreateDTO;
import br.com.bytestore.api.dtos.PaymentResponseDTO;
import br.com.bytestore.api.entities.Payment;

public class PaymentMapper {
	
	public static PaymentResponseDTO toDTO(Payment payment) {
		PaymentResponseDTO paymentResponse = new PaymentResponseDTO(payment.getId(),payment.getOrder(),payment.getPaymentMethod(), payment.getPaymentStatus(),payment.getCreated_at(),payment.getAmount(),payment.getUpdated_at());
		return paymentResponse;
	}
	
	public static Payment toEntity(PaymentCreateDTO paymentCreateDTO) {
		Payment payment = new Payment();
		payment.setOrder(paymentCreateDTO.order());
		payment.setPaymentMethod(paymentCreateDTO.paymentMethod());
		payment.setPaymentStatus(paymentCreateDTO.paymentStatus());
		payment.setAmount(paymentCreateDTO.amount());

		return payment;
	}
}

