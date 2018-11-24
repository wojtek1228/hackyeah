package com.hackyeah.mainapp.appointment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentRegisterDTO {

    private SpecializationDTO specialization;

    private Integer daysToAppointment;

    private String longitude;

    private String lattitude;

    private String name;

    private String surname;

    private String phone;

    private String city;

    private Date homeNumber;

    private String postalCode;

    private Date subscriptionDate;
}
