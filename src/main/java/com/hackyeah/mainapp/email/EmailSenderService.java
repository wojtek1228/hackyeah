package com.hackyeah.mainapp.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmailSenderService {

	private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);

	@Autowired
	private JavaMailSender sender;

//ALL	mails will be send from mail : mtesterhackyeah@gmail.com
	@PostMapping(value = "/sendMail", produces = "application/json")
	public ResponseEntity sendMail(@RequestBody String email) {

		log.info("------------ sending email -----------------");
//		String mailTo = "mtesterhackyeah@gmail.com";
		String mailTo = email;
		String mailBody = "Hi, \n Please click below link to rate your appoitment \n  link etc  \n\n  Regards \n\n PyroSoft Team";
		String subject = "Rate your visit!!!";
		sentEmail(mailTo, mailBody, subject);

		log.info("------------ sent !!! -----------------");
		return ResponseEntity.ok("Mail Sent Success!");
	}

	private void sentEmail(String mailTo, String mailBody, String subject) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(mailTo);
			helper.setText(mailBody);
			helper.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(message);
	}

	@PostMapping(value = "/sendMailAtt", produces = "application/json")
	public ResponseEntity sendMailAttachment(@RequestBody String email) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		try {
			helper.setTo(email);
			helper.setText("U mnie działa :P");
			helper.setSubject("U mnie działa :P");
			ClassPathResource file = new ClassPathResource("man.png");
			helper.addAttachment("man.png", file);

			ClassPathResource cheat = new ClassPathResource("cheat.jpg");
			helper.addAttachment("cheat.jpg", cheat);

		} catch (MessagingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		sender.send(message);

		log.info("------------ sent !!! -----------------");
		return ResponseEntity.ok("Mail Sent Success!");
	}
}