package br.com.bytestore.api.mappers;



import br.com.bytestore.api.dtos.OrderItemCreateDTO;
import br.com.bytestore.api.dtos.OrderItemResponseDTO;
import br.com.bytestore.api.entites.OrderItem;

public class OrderItemMapper {
	
	public static OrderItemResponseDTO toDTO(OrderItem orderItem) {
		OrderItemResponseDTO orderItemResponse = new OrderItemResponseDTO(orderItem.getId(),orderItem.getQuantity(),orderItem.getSubtotal(),orderItem.getOrder(),orderItem.getProductVariation());
		return orderItemResponse;
	}
	
	public static OrderItem toEntity(OrderItemCreateDTO orderItemCreateDTO) {
		OrderItem orderItem = new OrderItem();
		
		orderItem.setQuantity(orderItemCreateDTO.quantity());
		orderItem.setSubtotal(orderItemCreateDTO.subtotal());
		orderItem.setOrder(orderItemCreateDTO.order());
		orderItem.setProductVariation(orderItemCreateDTO.productVariation());
		
		return orderItem;
		
	}
}
