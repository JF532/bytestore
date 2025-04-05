CREATE TABLE adresse(
	id BIGINT AUTO_INCREMENTT PRIMARY KEY,
	street VARCHAR(255),
	number VARCHAR(255),
	neighborhood VARCHAR(255),
	city VARCHAR(255),
	state VARCHAR(255),
	complement VARCHAR(255),
	zipcode BIGINT,
	user_id BIGINT,
	FOREIGN KEY (user_id) REFERENCES users(id)	
)