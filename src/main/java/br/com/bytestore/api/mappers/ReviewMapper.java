package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.ReviewCreateDTO;
import br.com.bytestore.api.dtos.ReviewResponseDTO;
import br.com.bytestore.api.entities.Review;

public class ReviewMapper {
	public static ReviewResponseDTO toDTO(Review review) {
		ReviewResponseDTO reviewResponse = new ReviewResponseDTO(review.getId(),review.getRating(),review.getComment(),review.getUser(),review.getProduct(),review.getCreated_at(),review.getUpdated_at());
		return reviewResponse;
	}
	public static Review toEntity(ReviewCreateDTO reviewCreateDTO) {
		Review review = new Review();
		review.setRating(reviewCreateDTO.rating());
		review.setComment(reviewCreateDTO.comment());
		review.setUser(reviewCreateDTO.user());
		review.setProduct(reviewCreateDTO.product());

		return review;
	}
}
