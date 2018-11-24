package com.hackyeah.mainapp.appointment.service;


import com.hackyeah.mainapp.appointment.dao.AppointmentRepository;
import com.hackyeah.mainapp.appointment.entities.Appointment;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAllAppointmentsBySpecialization(Specialization specialization){

        return appointmentRepository.getAppointmentBySpecialization(specialization);
    }

}
