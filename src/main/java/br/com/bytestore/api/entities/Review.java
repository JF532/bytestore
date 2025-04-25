package br.com.bytestore.api.entities;

import java.sql.Date;
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
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int rating;
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@CreatedDate
	private Instant created_at;
	
	@LastModifiedBy
	private Instant updated_at;
	
	public Review() {
		
	}
	
	public Review(long id, int rating, String comment, User user, Instant created_at, Instant updated_at, Product product) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.user = user;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.product = product;
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
