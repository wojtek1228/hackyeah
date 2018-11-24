package com.hackyeah.mainapp.appointment.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "APPOINTMENT")
@javax.persistence.Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @Column(name = "SPECIALIZATION")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "DAYS_TO_APPOINTMENT")
    private Integer daysToAppointment;

    @Column(name = "SUBSCRIPTION_DATE")
    private Date subscriptionDate;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "LATTITUDE")
    private String lattitude;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CITY")
    private String city;

    @Column(name = "HOME_NUMBER")
    private Date homeNumber;

    @Column(name = "POSTAL_CODE")
    private String postalCode;
}
