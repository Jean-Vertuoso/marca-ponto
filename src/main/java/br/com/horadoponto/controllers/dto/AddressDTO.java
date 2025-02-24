package br.com.horadoponto.controllers.dto;

import br.com.horadoponto.infrastructure.entities.Address;

public class AddressDTO {

	private Long id;
	private String zipCode;
	private String street;
	private Long number;
	private String city;
	private String state;
	private String country;

	public AddressDTO() {
	}

	public AddressDTO(Long id, String zipCode, String street, Long number, String city, String state, String country) {
		this.id = id;
		this.zipCode = zipCode;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
