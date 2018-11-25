package com.hackyeah.mainapp.appointment.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "APPOINTMENT_REGISTER")
@javax.persistence.Entity
public class AppointmentRegister {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    @Column(name = "SPECIALIZATION")
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(name = "DAYS_TO_APPOINTMENT")
    private Integer daysToAppointment;

    @Column(name = "SUBSCRIPTION_DATE")
    private Date subscriptionDate;

    @Column(name = "APPOINTMENT_DATE")
    private Date appointmentDate;
    				
    @Column(name = "EMAIL_SENT")
    private Boolean emailSent;
    
    @Column(name = "EMAIL")
    private String email;
    
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
    private String homeNumber;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "PLACE_NIP")
    private String placeNip;

    @Column(name = "STREET")
    private String street;
}
