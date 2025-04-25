package br.com.bytestore.api.entities;


import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import br.com.bytestore.api.enuns.OrderStatus;
import br.com.bytestore.api.enuns.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private float totalPrice;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	private String trackingCode;
	@CreatedDate
	private Instant created_at;
	
	@LastModifiedBy
	private Instant updated_at;
	
	public Order() {
		
	}
	    

	
	
	public Order(long id, User user, float totalPrice, OrderStatus status, String trackingCode, Instant created_at,
			Instant updated_at, PaymentMethod paymentMethod) {
		this.id = id;
		this.user = user;
		this.totalPrice = totalPrice;
		this.status = status;
		this.trackingCode = trackingCode;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.paymentMethod = paymentMethod;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getTrackingCode() {
		return trackingCode;
	}
	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
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


	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	
	
}
