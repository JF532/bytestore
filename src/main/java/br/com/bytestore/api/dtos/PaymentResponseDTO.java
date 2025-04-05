package br.com.bytestore.api.dtos;


import java.time.Instant;

import br.com.bytestore.api.entites.Order;
import br.com.bytestore.api.enuns.PaymentMethod;
import br.com.bytestore.api.enuns.PaymentStatus;

public record PaymentResponseDTO(Long id, Order order, PaymentMethod paymentMethod, PaymentStatus paymentStatus, Instant created_at, Instant updated_at) {

}
