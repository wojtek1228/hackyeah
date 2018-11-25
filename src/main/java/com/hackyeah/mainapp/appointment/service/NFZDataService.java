package com.hackyeah.mainapp.appointment.service;

import com.hackyeah.mainapp.appointment.dto.NFZAppointmentsResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NFZDataService {

    public NFZAppointmentsResponseDTO createNFZAppointmentData(String city, String province, String specialization){
        RestTemplate restTemplate = new RestTemplate();
        String request = "https://api.nfz.gov.pl/queues?page=1&limit=25&format=json&case=1&province=" + province + "&locality=" + city + "&name=" + specialization;
        System.out.print(request);
        NFZAppointmentsResponseDTO resp = restTemplate.getForObject(request, NFZAppointmentsResponseDTO.class);

        return resp;
    }
}
