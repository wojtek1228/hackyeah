package com.hackyeah.mainapp.geo;

import java.util.Arrays;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.hackyeah.mainapp.geo.dto.AddressDTO;
import com.hackyeah.mainapp.geo.dto.OpenStreetGetByAddressResponseDTO;
import com.hackyeah.mainapp.geo.dto.OpenStreetGetByCordResponseDTO;

@Controller
@RequestMapping("/")
public class GeoLocalizator {

	private static final Logger log = LoggerFactory.getLogger(GeoLocalizator.class);

	private final String GET_BY_ADDRESS_URL = "https://nominatim.openstreetmap.org/search?q=";

	private final String GET_BY_CORD_URL = "https://nominatim.openstreetmap.org/reverse?format=json&";

	/**
	 * example for post http://localhost:8080/getCordsByAddress 
	 * { "houseNumber":"1","road":"bulgarska", "city":"poznan" }
	 * 
	 */
	@PostMapping(value = "/getCordsByAddress", produces = "application/json")
	public ResponseEntity getCordsByAddress(@RequestBody AddressDTO address) {

		RestTemplate restTemplate = new RestTemplate();
//        bulgarska+1+poznan&format=json&addressdetails=1
//        https://nominatim.openstreetmap.org/search?q=135+pilkington+avenue,+birmingham&format=xml&polygon=1&addressdetails=1

		String fullURL = GET_BY_ADDRESS_URL + address.getRoad() + "+" + address.getHouseNumber() + "+"
				+ address.getCity() + "&format=json&addressdetails=1";
		log.debug("quering url : {}", fullURL);
		OpenStreetGetByAddressResponseDTO[] quote = restTemplate.getForObject(fullURL, OpenStreetGetByAddressResponseDTO[].class);

		log.info(quote[0].toString());

		return ResponseEntity.ok(quote[0].toString());
	}


	
//	example get http://localhost:8080/getCordsByAddress/52/21
//	https://nominatim.openstreetmap.org/reverse?format=json&lat=52.5487429714954&lon=-1.81602098644987&zoom=18&addressdetails=1
	@GetMapping(value = "/getCordsByAddress/{lat}/{lon}", produces = "application/json")
	public ResponseEntity getCordsByAddress(@PathVariable("lat") String lat, @PathVariable("lon") String lon) {

		log.info("--------------------------------------------");
		RestTemplate restTemplate = new RestTemplate();

//		lat=52.5487429714954&lon=-1.81602098644987&zoom=18&addressdetails=1
			
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		String fullURL = GET_BY_CORD_URL + "lat="+lat + "&lon=" + lon + "&zoom=18&addressdetails=1";
        ResponseEntity<OpenStreetGetByCordResponseDTO> res = restTemplate.exchange(fullURL, HttpMethod.GET, entity, OpenStreetGetByCordResponseDTO.class);
		
		log.info("quering url : {}", fullURL);
		log.info(res.getBody().toString());
		log.info("--------------------------------------------");
		return ResponseEntity.ok(res.getBody().getAddress());
	}

}