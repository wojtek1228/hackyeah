package com.hackyeah.mainapp.appointment.service;


import com.hackyeah.mainapp.appointment.dao.AppointmentRegisterRepository;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentRegisterService {

    @Autowired
    private AppointmentRegisterRepository appointmentRegisterRepository;

    public List<AppointmentRegister> findAllAppointmentsBySpecialization(Specialization specialization){

        return appointmentRegisterRepository.findBySpecialization(specialization);
    }

    public List<AppointmentRegister> findAllAppointmentsBySpecializationAndDates(Specialization specialization, Date startDate, Date endDate){

        return appointmentRegisterRepository.findBySpecializationAndSubscriptionDateGreaterThanAndSubscriptionDateLessThan(specialization, startDate, endDate);
    }

    public List<Object[]> calculateAverageTimeToAppointmentForEachCity(Specialization specialization){

        List<Object[]> list = appointmentRegisterRepository.findBySpecializationGroupByDaysToAppointmentAverage(specialization);
        return list;
    }

}
