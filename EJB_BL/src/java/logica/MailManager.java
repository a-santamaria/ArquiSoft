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
     
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.host", "smtp.gmail.com");
        props.put("mail.user", "stivenavila140@gmail.com");
        props.put("mail.password", "Stiv3n140");
        props.put("mail.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getDefaultInstance(props, null);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("This is a test");
        message.setContent(msg, "text/plain");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}
