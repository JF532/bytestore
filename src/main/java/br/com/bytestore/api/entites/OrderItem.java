package br.com.bytestore.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantity;
	private float subtotal;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_variation_id")
	private ProductVariation productVariation;

	public OrderItem() {
		
	}
	
	public OrderItem(long id, int quantity, float subtotal, Order order, ProductVariation productVariation) {
		this.id = id;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.order = order;
		this.productVariation = productVariation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductVariation getProductVariation() {
		return productVariation;
	}

	public void setProductVariation(ProductVariation productVariation) {
		this.productVariation = productVariation;
	}

	
	
	
}
