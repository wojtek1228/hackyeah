package com.hackyeah.mainapp.appointment.controller;

import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.appointment.service.AppointmentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ExcelDownloadController {

    @Autowired
    private AppointmentRegisterService appointmentRegisterService;

    @RequestMapping(value = "/download/{specialization}", method = RequestMethod.GET)
    public String download(Model model, @PathVariable("specialization") String specialization) {
        model.addAttribute("appointments", appointmentRegisterService.calculateAverageTimeToAppointmentForEachCity(Enum.valueOf(Specialization.class,specialization)));
        return "";
    }
}
