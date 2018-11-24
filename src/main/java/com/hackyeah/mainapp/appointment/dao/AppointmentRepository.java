package com.hackyeah.mainapp.appointment.dao;

import com.hackyeah.mainapp.appointment.entities.Appointment;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,String> {

    public List<Appointment> findBySpecialization(Specialization specialization);

    public List<Appointment> findBySpecializationAndSubscriptionDateGreaterThanAndSubscriptionDateLessThan(Specialization specialization, Date  dateStart, Date dateEnd);
}
