package br.com.bytestore.api.dtos;


import java.time.Instant;

import br.com.bytestore.api.entities.User;
import br.com.bytestore.api.enuns.OrderStatus;
import br.com.bytestore.api.enuns.PaymentMethod;

public record OrderResponseDTO(Long id, float totalPrice, String trackingCode,OrderStatus status, User user, Instant created_at, Instant updated_at, PaymentMethod paymentMethod ) {

}
