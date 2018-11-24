package com.hackyeah.mainapp.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

	private String houseNumber;
	private String road;
	private String city;
	private String state;
	private String postcode;
	private String country;

//	https://nominatim.openstreetmap.org/search/135%20pilkington%20avenue,%20birmingham?format=xml&polygon=1&addressdetails=1
//	
}
