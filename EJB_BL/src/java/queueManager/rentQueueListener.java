/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueManager;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import logica.MailManager;

/**
 *
 * @author david
 */
@JMSDestinationDefinition(name = "jms/queueMails", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "queueMails")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queueMails"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class rentQueueListener implements MessageListener {
    
    @EJB
    private MailManager mailManager;
    
    public rentQueueListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            String[] data = msg.getText().split(":");
            String email = data[0];
            String id_property = data[1];
            String body = "Hi!! This is a OPRS System message. To download your contract go to the next link: " + id_property;
            mailManager.sendEmail(email, body);
        } catch (JMSException ex) {
            Logger.getLogger(rentQueueListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(rentQueueListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
