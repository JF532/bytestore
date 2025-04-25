package br.com.bytestore.api.entities;


import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="promotions")
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private float discountPercentage;
	
	@CreatedDate
	private Instant startDate;
	
	@LastModifiedBy
	private Instant endDate;
	
	private boolean active;

	
	//Só pegou o de variation
	@ManyToOne
	@JoinColumn(name="product_variation_id")
	private ProductVariation productVariation;
	
	public Promotion() {
		
	}
	public Promotion(long id, String name, float discountPercentage, Instant startDate, Instant endDate, boolean active, ProductVariation productVariation) {
		this.id = id;
		this.name = name;
		this.discountPercentage = discountPercentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
		this.productVariation = productVariation;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}


	public Instant getStartDate() {
		return startDate;
	}


	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}


	public Instant getEndDate() {
		return endDate;
	}


	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public ProductVariation getProductVariation() {
		return productVariation;
	}


	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}
	
	
	
	
}
