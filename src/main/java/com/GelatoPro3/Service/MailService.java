package com.GelatoPro3.Service;

import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

@Service
public class MailService
{
	public void sendMail(){

		System.out.println("sendMail()....");
		// Recipient's email ID needs to be mentioned.
		String to = "samy.geoffroy@hotmail.fr";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.protonmail.ch");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.trust", "smtp.protonmail.ch");
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		// Sender's email ID needs to be mentioned
		String from = "samy.geoffroy@proton.me";
		// Assuming you are sending email from localhost
		String host = "localhost";
		// Get system properties
		//Properties properties = System.getProperties();
		// Setup mail server
		//properties.setProperty("mail.smtp.host", host);
		// Get the default Session object.

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("samy.geoffroy@proton.me", "vvv14091992");
			}
		});

		//session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}
