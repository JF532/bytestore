package br.com.bytestore.api.mappers;



import br.com.bytestore.api.dtos.AddressCreateDTO;
import br.com.bytestore.api.dtos.AddressResponseDTO;
import br.com.bytestore.api.entities.Address;

public class AddressMapper {
	
public static AddressResponseDTO toDTO(Address address) {
	AddressResponseDTO addressResponseDTO = new AddressResponseDTO(address.getId(), address.getStreet(), address.getNumber(), address.getNeighbothood(), address.getCity(), address.getState(), address.getCompliment(), address.getZipcode(), address.getUser());
	return addressResponseDTO;
}

public static Address toEntity(AddressCreateDTO addressCreateDTO) {
	Address address = new Address();
	
	address.setStreet(addressCreateDTO.street());
	address.setNumber(addressCreateDTO.number());
	address.setNeighbothood(addressCreateDTO.neighborhood());
	address.setCity(addressCreateDTO.city());
	address.setState(addressCreateDTO.state());
	address.setCompliment(addressCreateDTO.compliment());
	address.setZipcode(addressCreateDTO.zipcode());
	address.setUser(addressCreateDTO.user());
	
	return address;
	
}
}
