package br.com.bytestore.api.dtos;

import br.com.bytestore.api.enuns.OrderStatus;
import br.com.bytestore.api.enuns.PaymentMethod;

public record OrderUpdateDTO(Long id, float totalPrice, OrderStatus status, PaymentMethod paymentMethod) {

}
