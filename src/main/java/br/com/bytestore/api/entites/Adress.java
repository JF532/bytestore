package br.com.bytestore.api.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String street;
	private String number;
	private String neighbothood;
	private String city;
	private String state;
	private String complement;
	private long zipcode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Adress() {
		
	}
	
	public Adress(long id, String street, String number, String neighbothood, String city, String state,
			String complement, long zipcode, User user) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighbothood = neighbothood;
		this.city = city;
		this.state = state;
		this.complement = complement;
		this.zipcode = zipcode;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighbothood() {
		return neighbothood;
	}
	public void setNeighbothood(String neighbothood) {
		this.neighbothood = neighbothood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
