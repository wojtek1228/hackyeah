package com.hackyeah.mainapp.appointment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFZAppointmentsResponseDTO {
    private Data[] data;
}
