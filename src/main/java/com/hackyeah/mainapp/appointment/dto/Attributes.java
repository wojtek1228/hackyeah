package com.hackyeah.mainapp.appointment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {

    @JsonProperty("regon-provider")
    private String regon;

    private String phone;

    private String benefit;

    private String provider;

    private Statistics statistics;

    private String ramp;

    private String elevator;

    @JsonProperty("car-park")
    private String carPark;

    private String toilet;

    private Dates dates;

    private String address;

    private String locality;

    private String longitude;

    private String latitude;

    @JsonProperty("nip-provider")
    private String nip;

    private String place;

    private Double rate;

}
