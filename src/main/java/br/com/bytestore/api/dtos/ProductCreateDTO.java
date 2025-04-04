package br.com.bytestore.api.dtos;

public record ProductCreateDTO(String name, 
		double price, 
		int stock) {}
