package com.hackyeah.mainapp.appointment.service;


import com.hackyeah.mainapp.appointment.dao.AppointmentRegisterRepository;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import com.hackyeah.mainapp.appointment.entities.Specialization;
import com.hackyeah.mainapp.geo.GeoLocalizerService;
import com.hackyeah.mainapp.geo.dto.AddressDTO;
import com.hackyeah.mainapp.geo.dto.OpenStreetGetByAddressResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentRegisterService {

    @Autowired
    private AppointmentRegisterRepository appointmentRegisterRepository;

    @Autowired
    private GeoLocalizerService geoLocalizerService;


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

    public boolean createNewAppointmentRegister(String nip, AppointmentRegister appointmentRegister){

        appointmentRegister.setPlaceNip(nip);
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(appointmentRegister.getCity());
        addressDTO.setPostcode(appointmentRegister.getPostalCode());
        addressDTO.setRoad(appointmentRegister.getStreet());
        addressDTO.setHouseNumber(appointmentRegister.getHomeNumber());

        OpenStreetGetByAddressResponseDTO res = geoLocalizerService.getCordsByAddress(addressDTO);

        appointmentRegister.setLattitude(res.getLat());
        appointmentRegister.setLongitude(res.getLon());

        AppointmentRegister ap =  appointmentRegisterRepository.save(appointmentRegister);
        if(ap!=null){
            return true;
        }else{
            return false;
        }
    }

}
