package br.com.bytestore.api.dtos;

public record ProductCreateDTO(String name, String descripton, 
		double price, String category, String brand, String imageUrl, 
		float rating) {}
