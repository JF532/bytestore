package br.com.bytestore.api.dtos;


import java.time.Instant;

public record ProductResponseDTO(Long id, String name, String descripton, double price, String category, String brand, String imageUrl, float rating, Instant created_at, Instant updated_at) {

}
