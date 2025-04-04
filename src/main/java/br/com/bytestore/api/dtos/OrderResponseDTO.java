package br.com.bytestore.api.dtos;

import java.sql.Date;

import br.com.bytestore.api.entites.User;
import br.com.bytestore.api.enuns.OrderStatus;
import br.com.bytestore.api.enuns.PaymentMethod;

public record OrderResponseDTO(Long id, float totalPrice, String trackingCode,OrderStatus status, User user, Date created_at, Date updated_at, PaymentMethod paymentMethod ) {

}
