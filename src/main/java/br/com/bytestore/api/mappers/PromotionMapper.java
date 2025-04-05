package br.com.bytestore.api.mappers;


import br.com.bytestore.api.dtos.PromotionCreateDTO;
import br.com.bytestore.api.dtos.PromotionResponseDTO;
import br.com.bytestore.api.entites.Promotion;

public class PromotionMapper {
	public static PromotionResponseDTO toDTO(Promotion promotion) {
		PromotionResponseDTO promotionResponse = new PromotionResponseDTO(promotion.getId(),promotion.getName(),promotion.getDiscountPercentage(),promotion.getStartDate(),promotion.getEndDate(),promotion.isActive(),promotion.getProductVariation());
		return promotionResponse;
	}
	
	public static Promotion toEntity(PromotionCreateDTO promotionCreateDTO) {
		Promotion promotion = new Promotion();
		promotion.setName(promotionCreateDTO.name());
		promotion.setDiscountPercentage(promotionCreateDTO.discountPercentage());
		promotion.setActive(promotionCreateDTO.isActive());
		promotion.setProductVariation(promotionCreateDTO.productVariation());

		return promotion;
	}
}
