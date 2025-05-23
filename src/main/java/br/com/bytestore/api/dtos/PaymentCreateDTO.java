package br.com.bytestore.api.dtos;

import br.com.bytestore.api.entities.Order;
import br.com.bytestore.api.enuns.PaymentMethod;
import br.com.bytestore.api.enuns.PaymentStatus;

public record PaymentCreateDTO(Order order, PaymentMethod paymentMethod, PaymentStatus paymentStatus,float  amount) {

}
