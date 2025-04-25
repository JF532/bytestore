package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.OrderCreateDTO;
import br.com.bytestore.api.dtos.OrderResponseDTO;
import br.com.bytestore.api.dtos.OrderUpdateDTO;
import br.com.bytestore.api.entities.Order;
import br.com.bytestore.api.entities.User;
import br.com.bytestore.api.mappers.OrderMapper;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.repository.OrderRepository;
import br.com.bytestore.api.repository.UserRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderResponseDTO store(OrderCreateDTO orderCreateDTO) {
		Order order = OrderMapper.toEntity(orderCreateDTO);
		
		
		OrderResponseDTO orderResponse = OrderMapper.toDTO(orderRepository.save(order));
		
		return orderResponse;
		}
	
	
	public List<OrderResponseDTO> list(){
		return orderRepository.findAll().stream().map(OrderMapper::toDTO).toList();
	}
	
	
	public OrderResponseDTO show(long id) {
		Order order = orderRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Ordem com o id " + id + " não encontrado."));
		
		return OrderMapper.toDTO(order);
	}
	
	
	
	public OrderResponseDTO update(OrderUpdateDTO orderUpdateDTO) {
		
		Order order = orderRepository.findById(orderUpdateDTO.id()).orElseThrow(
				() -> new RuntimeException("Order não encontrada."));
		
		order.setTotalPrice(orderUpdateDTO.totalPrice());
		order.setStatus(orderUpdateDTO.status());
		order.setPaymentMethod(orderUpdateDTO.paymentMethod());
		return null;
	}
	
	
	public void destroy(long id) {
		Order order = orderRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Order com o id " + id + " deletado."));
		
		orderRepository.delete(order);
	}

}
