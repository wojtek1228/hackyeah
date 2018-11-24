package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.dto.AppointmentRegisterDTO;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
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
public class AppointmentRegisterStatisticController {


    @Autowired
    private AppointmentRegisterService appointmentRegisterService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/appointmentStatistics/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization){

        System.out.print("JESTEM Appointemnt Stat");

        List<AppointmentRegister> resList = appointmentRegisterService.findAllAppointmentsBySpecialization(Enum.valueOf(Specialization.class,specialization));

        List<AppointmentRegisterDTO> resListDTO = createAppointmentDTOforStatiscticCase(resList);

        return ResponseEntity.ok(resListDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/appointmentStatistics/dates/{specialization}", produces = "application/json")
    public ResponseEntity getEntity(@PathVariable("specialization") String specialization, @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){

        System.out.print("JESTEM Appointemnt Stat");

        List<AppointmentRegister> resList = appointmentRegisterService.findAllAppointmentsBySpecializationAndDates(Enum.valueOf(Specialization.class,specialization), startDate, endDate);

        List<AppointmentRegisterDTO> resListDTO = createAppointmentDTOforStatiscticCase(resList);

        return ResponseEntity.ok(resListDTO);
    }

    private List<AppointmentRegisterDTO> createAppointmentDTOforStatiscticCase(List<AppointmentRegister> resList) {
        List<AppointmentRegisterDTO> resListDTO = new ArrayList<>();

        for (AppointmentRegister appointmentRegister : resList) {
            AppointmentRegisterDTO appointmentRegisterDTO = new AppointmentRegisterDTO();
            appointmentRegisterDTO.setLattitude(appointmentRegister.getLattitude());
            appointmentRegisterDTO.setLongitude(appointmentRegister.getLongitude());
            appointmentRegisterDTO.setDaysToAppointment(appointmentRegister.getDaysToAppointment());
            appointmentRegisterDTO.setSubscriptionDate(appointmentRegister.getSubscriptionDate());
            resListDTO.add(appointmentRegisterDTO);
        }
        return resListDTO;
    }
}
