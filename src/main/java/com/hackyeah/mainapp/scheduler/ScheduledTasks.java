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
import com.hackyeah.mainapp.email.EmailSenderService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private AppointmentRegisterRepository appointmentRegisterRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));

		log.info("Checking for pending rates {}", dateFormat.format(new Date()));

		// sprawdz czy minal juz termin wizyty i mail nie zostal wyslany

		Date date = new Date();
		log.info("check for date  {}", date);
		List<AppointmentRegister> appointments = appointmentRegisterRepository
				.findByEmailSentFalseAndAppointemntDateLessThan(date);

		log.info("Found Appointments {}", appointments.size());

		// wyslij maila
		for (AppointmentRegister appointmentRegister : appointments) {

			String email = appointmentRegister.getEmail();
			if (email != null) {
				emailSenderService.sendMail(email);
				appointmentRegister.setEmailSent(true);

				// zaaktualizuj stan mail wyslany
				appointmentRegisterRepository.save(appointmentRegister);
			}
		}
	}
}
