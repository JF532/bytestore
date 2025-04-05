package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entites.Order;
import br.com.bytestore.api.enuns.PaymentMethod;
import br.com.bytestore.api.enuns.PaymentStatus;

public record PaymentUpdateDTO(Long id, Order order, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {

}
