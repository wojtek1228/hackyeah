package com.hackyeah.mainapp.appointment.service;


import com.hackyeah.mainapp.appointment.dao.AppointmentCancelledRepository;
import com.hackyeah.mainapp.appointment.dao.AppointmentRegisterRepository;
import com.hackyeah.mainapp.appointment.entities.AppointmentCancelled;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentCancelledService {

    @Autowired
    private AppointmentCancelledRepository appointmentCancelledRepository;

    public List<AppointmentCancelled> findAllHotAppointmentsBySpecialization(Specialization specialization){

        return appointmentCancelledRepository.findByAppointmentDateGreaterThanAndSpecialization(new Date(), specialization);
    }


}
