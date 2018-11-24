package com.hackyeah.mainapp.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressEmbeded {

	private String road;
	private String village;
	private String county;
	private String state;
	private String postcode;
	private String country;

}
