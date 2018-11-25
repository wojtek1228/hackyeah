package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.NFZAppointmentsResponseDTO;
import com.hackyeah.mainapp.appointment.entities.AppointmentCancelled;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.NFZDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NFZAppointmentController {

    @Autowired
    private NFZDataService nfzDataService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/nfzAppointments/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization, @RequestParam("city") String city, @RequestParam("province") String province){

        System.out.print("JESTEM Appointemnt Stat");

        NFZAppointmentsResponseDTO res = nfzDataService.createNFZAppointmentData(city, province, specialization);

        return ResponseEntity.ok(res);
    }

}
