package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.AppointmentRegisterDTO;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.AppointmentRegisterService;
import com.hackyeah.mainapp.geo.GeoLocalizerService;
import com.hackyeah.mainapp.geo.dto.AddressDTO;
import com.hackyeah.mainapp.geo.dto.OpenStreetGetByAddressResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppointmentRegisterController {


    @Autowired
    private AppointmentRegisterService appointmentRegisterService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/appointmentRegister/{nip}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("nip") String nip, AppointmentRegister appointmentRegister){




        boolean created = appointmentRegisterService.createNewAppointmentRegister(nip, appointmentRegister);

        if(created) {
            return ResponseEntity.status(201).build();
        }else {
            return ResponseEntity.status(500).build();
        }
    }

}
