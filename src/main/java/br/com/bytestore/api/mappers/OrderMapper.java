package br.com.bytestore.api.mappers;

import br.com.bytestore.api.dtos.OrderCreateDTO;
import br.com.bytestore.api.dtos.OrderResponseDTO;
import br.com.bytestore.api.entities.Order;

public class OrderMapper {
	public static OrderResponseDTO toDTO(Order order) {
		OrderResponseDTO orderResponse = new OrderResponseDTO(order.getId(), order.getTotalPrice(),order.getTrackingCode(), order.getStatus(),order.getUser(), order.getCreated_at(),order.getUpdated_at(),order.getPaymentMethod());
		return orderResponse;
	}
	public static Order toEntity(OrderCreateDTO orderCreateDTO) {
		Order order = new Order();
		order.setUser(orderCreateDTO.user());
		order.setTotalPrice(orderCreateDTO.totalPrice());

		return order;
	}
}
