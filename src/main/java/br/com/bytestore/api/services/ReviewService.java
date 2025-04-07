package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.ReviewCreateDTO;
import br.com.bytestore.api.dtos.ReviewResponseDTO;
import br.com.bytestore.api.dtos.ReviewUpdateDTO;
import br.com.bytestore.api.dtos.UserCreateDTO;
import br.com.bytestore.api.dtos.UserResponseDTO;
import br.com.bytestore.api.dtos.UserUpdateDTO;
import br.com.bytestore.api.entites.Address;
import br.com.bytestore.api.entites.Review;
import br.com.bytestore.api.entites.User;
import br.com.bytestore.api.mappers.ReviewMapper;
import br.com.bytestore.api.mappers.UserMapper;
import br.com.bytestore.api.repository.AddressRepository;
import br.com.bytestore.api.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	public ReviewResponseDTO store(ReviewCreateDTO reviewCreateDTO) {
		Review review = ReviewMapper.toEntity(reviewCreateDTO);
		Review reviewResponse = reviewRepository.save(review);
		return ReviewMapper.toDTO(reviewResponse);
	}
	
	public List<ReviewResponseDTO> list() {
		return reviewRepository.findAll().stream().map(ReviewMapper::toDTO).toList();
	}
	
	public ReviewResponseDTO show(long id) {
		Review review = reviewRepository.findById(id).orElseThrow(()->new RuntimeException("Review com id" + id + "não encontrada"));
		return ReviewMapper.toDTO(review);
	}
	
	public ReviewResponseDTO update(ReviewUpdateDTO reviewUpdateDTO) {
		Review review = reviewRepository.findById(reviewUpdateDTO.id()).orElseThrow(()-> new RuntimeException("Review não encontrada"));
		review.setRating(reviewUpdateDTO.rating());
		review.setComment(reviewUpdateDTO.comment());
		review.setUser(reviewUpdateDTO.user());
		review.setProduct(reviewUpdateDTO.product());
		
		return ReviewMapper.toDTO(reviewRepository.save(review));
	}
	
	public ReviewResponseDTO destroy(long id) {
		Review review = reviewRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Review com o id " + id + "  não encontrado."));
		return ReviewMapper.toDTO(review);
	}
}
