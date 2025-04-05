package br.com.bytestore.api.entites;


import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descripton;
	private double price;
	private String category;
	private String brand;
	private String imageUrl;
	private float rating;
	@CreatedDate
	private Instant created_at;
	
	@LastModifiedBy
	private Instant updated_at;
	
	//@OneToMany ATENÇÃOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	//@JoinColumn(name="product_id")
	//private Product product;

	public Product() {
		
	}
	
	public Product(Long id, String name, String descripton, double price, String category, String brand,
			String imageUrl, float rating, Instant created_at, Instant updated_at) {
		this.id = id;
		this.name = name;
		this.descripton = descripton;
		this.price = price;
		this.category = category;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Instant getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}
	public Instant getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}

	

}