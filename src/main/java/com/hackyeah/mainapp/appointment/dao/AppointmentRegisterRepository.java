package com.hackyeah.mainapp.appointment.dao;

import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRegisterRepository extends CrudRepository<AppointmentRegister,String> {

    public List<AppointmentRegister> findBySpecialization(Specialization specialization);

    public List<AppointmentRegister> findBySpecializationAndSubscriptionDateGreaterThanAndSubscriptionDateLessThan(Specialization specialization, Date  dateStart, Date dateEnd);

    @Query("select u.city, avg(u.daysToAppointment) from AppointmentRegister u where u.specialization = :specialization group by u.city")
    public List<Object[]> findBySpecializationGroupByDaysToAppointmentAverage(@Param("specialization") Specialization specialization);
    
//    @Query("select u.city, avg(u.daysToAppointment) from AppointmentRegister u where u.specialization = :specialization group by u.city")
    public List<AppointmentRegister> findByEmailSentFalse();
//    AppointemntDateAndAppointemntDateGreaterThanAnd

}
