/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Date;
import java.util.Properties;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sala_a
 */
@Stateless
@LocalBean
public class MailManager {

    public void sendEmail(String email, String msg) throws MessagingException{
     
        final String username = "stivenavila140@gmail.com";
        final String password = "Stiv3n140";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
          });
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from-email@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
        message.setSubject("Rent Contract");
        message.setText(msg);

        Transport.send(message);

        System.out.println("Done");
    }
}
