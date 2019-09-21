package com.nino.mail.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nino.mail.domain.SendEmail;
import com.nino.mail.domain.retornos.ReturnSimplified;
import com.nino.mail.service.SendEmailService;

@RestController
@RequestMapping("/email")
public class Mail {

	//Services
	@Autowired
	SendEmailService sendEmailServices;
	
	//Return
	private ReturnSimplified returnSimplified = new ReturnSimplified();
	
	@PostMapping(value = "/sendEmails")
	public ResponseEntity<ReturnSimplified> sendEmail(@RequestBody SendEmail sendEmail) throws Exception {
		
		SendEmail sendEmailReturn = sendEmailServices.sendEmail(sendEmail);
		
		returnSimplified.clean();
		returnSimplified.setObject(sendEmailReturn);
		returnSimplified.setPath("/email/sendEmails");
		returnSimplified.setMethod("post");
		
		return ResponseEntity.status(HttpStatus.OK).body(returnSimplified);
		
	}
	
}
