package com.hackyeah.mainapp.geo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenStreetGetByCordResponseDTO {
	
	private String lat;
	private String lon;
	private String display_name;
	private AddressEmbeded address;
	
	
//	private String address;
	
//	{
//		  "place_id": "127664016",
//		  "licence": "Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright",
//		  "osm_type": "way",
//		  "osm_id": "222564414",
//		  "lat": "52.0042102",
//		  "lon": "21.0015163",
//		  "display_name": "Boczna, Pęchery, gmina Piaseczno, powiat piaseczyński, województwo mazowieckie, 05-540, Polska",
//		  "address": {
//		    "road": "Boczna",
//		    "village": "Pęchery",
//		    "county": "gmina Piaseczno",
//		    "state": "województwo mazowieckie",
//		    "postcode": "05-540",
//		    "country": "Polska",
//		    "country_code": "pl"
//		  },
//		  "boundingbox": [
//		    "52.0042102",
//		    "52.0071972",
//		    "21.0007377",
//		    "21.0015163"
//		  ]
//		}
	
//	@Override
//	public String toString() {
//		return "Response {" + "lat='" + lat + '\'' + "lon='" + lon + '\'' + ", display_name=" + display_name + ", address=" +  address+'}';
//	}
}
