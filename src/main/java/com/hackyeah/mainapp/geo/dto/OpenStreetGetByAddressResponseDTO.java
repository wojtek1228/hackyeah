package com.hackyeah.mainapp.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenStreetGetByAddressResponseDTO {

//    "lat": "52.3955671",
//    "lon": "16.8620571",
//    "display_name": "1, Bułgarska, Kasztelanów, Grunwald Południe, Poznań, województwo wielkopolskie, 60-316, Polska",
//    

	private String lat;
	private String lon;
	private String display_name;

	@Override
	public String toString() {
		return "Response {" + "lat='" + lat + '\'' + "lon='" + lon + '\'' + ", display_name=" + display_name + '}';
	}

}
