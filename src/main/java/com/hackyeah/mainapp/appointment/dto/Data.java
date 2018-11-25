package com.hackyeah.mainapp.appointment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private String id;

    private Attributes attributes;

    private String type;
}
