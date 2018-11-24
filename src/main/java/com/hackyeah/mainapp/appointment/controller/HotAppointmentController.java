package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.AppointmentRegisterDTO;
import com.hackyeah.mainapp.appointment.entities.AppointmentCancelled;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.AppointmentCancelledService;
import com.hackyeah.mainapp.appointment.service.AppointmentRegisterService;
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
public class HotAppointmentController {


    @Autowired
    private AppointmentCancelledService appointmentCancelledService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/hotAppointment/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization){

        System.out.print("JESTEM Appointemnt Stat");

        List<AppointmentCancelled> resList = appointmentCancelledService.findAllHotAppointmentsBySpecialization(Enum.valueOf(Specialization.class,specialization));

        return ResponseEntity.ok(resList);
    }
}
