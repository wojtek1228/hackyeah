package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.AppointmentDTO;
import com.hackyeah.mainapp.appointment.entities.Appointment;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.AppointmentService;
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
public class AppointmentStatisticController {


    @Autowired
    private AppointmentService appointmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/appointmentStatistics/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization){

        System.out.print("JESTEM Appointemnt Stat");

        List<Appointment> resList = appointmentService.findAllAppointmentsBySpecialization(Enum.valueOf(Specialization.class,specialization));

        List<AppointmentDTO> resListDTO = createAppointmentDTOforStatiscticCase(resList);

        return ResponseEntity.ok(resListDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/appointmentStatistics/dates/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){

        System.out.print("JESTEM Appointemnt Stat");

        List<Appointment> resList = appointmentService.findAllAppointmentsBySpecializationAndDates(Enum.valueOf(Specialization.class,specialization), startDate, endDate);

        List<AppointmentDTO> resListDTO = createAppointmentDTOforStatiscticCase(resList);

        return ResponseEntity.ok(resListDTO);
    }

    private List<AppointmentDTO> createAppointmentDTOforStatiscticCase(List<Appointment> resList) {
        List<AppointmentDTO> resListDTO = new ArrayList<>();

        for (Appointment appointment : resList) {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setLattitude(appointment.getLattitude());
            appointmentDTO.setLongitude(appointment.getLongitude());
            appointmentDTO.setDaysToAppointment(appointment.getDaysToAppointment());
            appointmentDTO.setSubscriptionDate(appointment.getSubscriptionDate());
            resListDTO.add(appointmentDTO);
        }
        return resListDTO;
    }
}
