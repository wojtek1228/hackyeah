package com.hackyeah.mainapp.appointment.dto;

import com.hackyeah.mainapp.appointment.entities.Specialization;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class AppointmentCancelledDTO {

    private String id;

    private Specialization specialization;

    private Date appointmentDate;

    private String placeName;

    private String street;
}