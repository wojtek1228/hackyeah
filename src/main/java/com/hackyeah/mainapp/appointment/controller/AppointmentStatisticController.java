package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.AppointmentDTO;
import com.hackyeah.mainapp.appointment.entities.Appointment;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppointmentStatisticController {


    @Autowired
    private AppointmentService appointmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/appointmentStatistics/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization){

        System.out.print("JESTEM Appointemnt Stat");

        List<Appointment> resList = appointmentService.findAllAppointmentsBySpecialization(Enum.valueOf(Specialization.class,specialization));

        List<AppointmentDTO> resListDTO = new ArrayList<>();

        for(Appointment appointment : resList){
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setLattitude(appointment.getLattitude());
            appointmentDTO.setLongitude(appointment.getLongitude());
            appointmentDTO.setDaysToAppointment(appointment.getDaysToAppointment());
            resListDTO.add(appointmentDTO);
        }

        return ResponseEntity.ok(resListDTO);
    }
}
