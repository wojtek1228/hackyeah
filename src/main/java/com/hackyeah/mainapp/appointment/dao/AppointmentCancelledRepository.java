package com.hackyeah.mainapp.appointment.dao;

import com.hackyeah.mainapp.appointment.entities.AppointmentCancelled;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentCancelledRepository extends CrudRepository<AppointmentCancelled,String> {

    public List<AppointmentCancelled> findByAppointmentDateGreaterThanAndSpecialization(Date date, Specialization specialization);
}
