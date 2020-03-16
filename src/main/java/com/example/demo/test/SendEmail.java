package com.example.demo.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
//CLASE PARA ENVIAR CORREOS MEDIANTE SERVIDOR GMAIL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String destinatario = "destinatario@hotmail.com";

	      // Sender's email ID needs to be mentioned
	      String emisor = "emisor@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "smtp.gmail.com";
	      String port="587";

	      // Get system properties
	      
	      Properties properties = System.getProperties();

	      // Propiedades de Servidor Email
	      properties.setProperty("mail.smtp.user","emisor@gmail.com");
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      properties.setProperty("mail.smtp.starttls.enable", "true");
	      properties.setProperty("mail.smtp.auth", "true"); //autenticacion
	      
	     

	      // Get the default Session object.
	      //Session session = Session.getDefaultInstance(properties);
	      Session session = Session.getDefaultInstance(properties,
	    		    new Authenticator() {
	    		        protected PasswordAuthentication  getPasswordAuthentication() {
	    		        return new PasswordAuthentication(
	    		                    "user@gmail.com", "password");
	    		                }
	    		    });

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(emisor));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

	         // Set Subject: header field
	         message.setSubject("Asunto");

	         // Now set the actual message
	         message.setText("mensaje de texto para enviar");
	         

	         // Send message
	         Transport.send(message);
	         
	         System.out.println("Mensaje enviado correctamente....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	

}
