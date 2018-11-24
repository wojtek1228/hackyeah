package com.hackyeah.mainapp.appointment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "APPOINTMENT_CANCELLED")
@Entity
public class AppointmentCancelled {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @Column(name = "SPECIALIZATION")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "APPOINTMENT_DATE")
    private Date appointmentDate;

    @Column(name = "PLACE_NAME")
    private String placeName;

    @Column(name = "STREET")
    private String street;
}
