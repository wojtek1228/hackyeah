/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hackyeah.mainapp.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hackyeah.mainapp.appointment.dao.AppointmentRegisterRepository;
import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private AppointmentRegisterRepository appointmentRegisterRepository;
    
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        
        log.info("Checking for pending rates {}", dateFormat.format(new Date()));
        
        //sprawdz czy minal juz termin wizyty i mail nie zostal wyslany 
       
        List<AppointmentRegister> appointments = appointmentRegisterRepository.findByEmailSentFalse();
        
        log.info("The time is size {}", appointments.size());
        
       //wyslij maila 
        
        //zaaktualizuj stan mail wyslany
        
        
    }
}
