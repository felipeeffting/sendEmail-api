package com.nino.mail.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.nino.mail.domain.SendEmail;

@Service
public class SendEmailService {

	//Properties used for email sending
	private Properties props = new Properties();
	private Session session;
	
	//Set up email you send
	private final String sendingEmail    = "yourEmail@gmail.com";
	private final String sendingPassword = "yourPassword";
	
	public SendEmail sendEmail(SendEmail sendEmail) throws Exception{
		
		generetePropertiesGmail();
		genereteSession(sendingEmail, sendingPassword);
		
        //compose message
        try {
            MimeMessage message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(sendEmail.getEmissary()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmail.getRecipient()));

            message.setSubject(sendEmail.getSubjectText());
            
            String content = genereteContent(sendEmail);
            message.setContent(content, "text/html; charset=utf-8");

            //send message  
            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        return sendEmail;
        
	}
	
	public String genereteContent(SendEmail sendEmail) {
		
		StringBuffer buffer = new StringBuffer(); 
		
		buffer.append("----------------------------------");
		buffer.append("<br/> Assunto -> " + sendEmail.getSubjectText() + "<br/>");
		buffer.append("----------------------------------");
		buffer.append("<br/> Message -> <b>" + sendEmail.getBodyText() + "</b> <br/>");
		buffer.append("----------------------------------");
		buffer.append("<br/> Shopping date -> " + new Date() + "<br/>");
		buffer.append("----------------------------------");
		
		return buffer.toString();
	}
	
	public void genereteSession(final String email, final String password) throws Exception {
		
		this.session = Session.getDefaultInstance(this.props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
	}
	
	public void generetePropertiesGmail() throws Exception {
		
		this.props.put("mail.smtp.host", "smtp.gmail.com");
		this.props.put("mail.smtp.socketFactory.port", "465");
		this.props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
		this.props.put("mail.smtp.auth", "true");
		this.props.put("mail.smtp.port", "465");
        
	}
	
}

