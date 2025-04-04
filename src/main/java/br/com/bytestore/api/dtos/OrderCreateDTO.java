package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.User;
import br.com.bytestore.api.enuns.OrderStatus;
import br.com.bytestore.api.enuns.PaymentMethod;

public record OrderCreateDTO(float totalPrice, String trackingCode,OrderStatus status, User user, PaymentMethod paymentMethod) {

}
