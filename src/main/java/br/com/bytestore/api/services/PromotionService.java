package br.com.bytestore.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bytestore.api.dtos.PromotionCreateDTO;
import br.com.bytestore.api.dtos.PromotionResponseDTO;
import br.com.bytestore.api.dtos.PromotionUpdateDTO;
import br.com.bytestore.api.entities.Promotion;
import br.com.bytestore.api.mappers.PromotionMapper;
import br.com.bytestore.api.repository.PromotionRepository;

@Service
public class PromotionService {
	
	@Autowired
	PromotionRepository promotionRepository;
	
	public PromotionResponseDTO store(PromotionCreateDTO promotionCreateDTO) {
		Promotion promotion = PromotionMapper.toEntity(promotionCreateDTO);
		Promotion promotionResponse = promotionRepository.save(promotion);
		return PromotionMapper.toDTO(promotionResponse);
	}
	
	public List<PromotionResponseDTO> list() {
		return promotionRepository.findAll().stream().map(PromotionMapper::toDTO).toList();
	}
	
	public PromotionResponseDTO show(long id) {
		Promotion promotion = promotionRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Promoção com id " + id + " não encontrada")
						);
		return PromotionMapper.toDTO(promotion);
	}
	
	public PromotionResponseDTO update(PromotionUpdateDTO promotionUpdateDTO) {
		Promotion promotion = promotionRepository
				.findById(promotionUpdateDTO.id())
				.orElseThrow(()->new RuntimeException("Promoção não encontrada"));
		promotion.setName(promotionUpdateDTO.name());
		promotion.setDiscountPercentage(promotionUpdateDTO.discountPercentage());
		promotion.setStartDate(promotionUpdateDTO.startDate());
		promotion.setEndDate(promotionUpdateDTO.endDate());
		promotion.setActive(promotionUpdateDTO.isActive());
		promotion.setProductVariation(promotionUpdateDTO.productVariation());
		
		return PromotionMapper.toDTO(promotionRepository.save(promotion));
	}
	
	public void destroy(long id) {
		Promotion promotion = promotionRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Promoção com o id " + id + "  não encontrado."));
		promotionRepository.delete(promotion);
	}
}
