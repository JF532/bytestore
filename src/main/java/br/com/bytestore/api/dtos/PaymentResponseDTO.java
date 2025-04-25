package br.com.bytestore.api.dtos;


import java.time.Instant;

import br.com.bytestore.api.entities.Order;
import br.com.bytestore.api.enuns.PaymentMethod;
import br.com.bytestore.api.enuns.PaymentStatus;

public record PaymentResponseDTO(Long id, Order order, PaymentMethod paymentMethod, PaymentStatus paymentStatus, Instant created_at,float  amount, Instant updated_at) {

}
