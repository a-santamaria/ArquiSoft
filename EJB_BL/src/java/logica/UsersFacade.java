/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Properties;
import entities.Rents;
import entities.Users;
import entities.VisitingList;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements logica.UsersFacadeRemote {
    @Resource(mappedName = "jms/queueMails")
    private Queue queueMails;
    @Inject
    @JMSConnectionFactory("jms/queueFactory")
    private JMSContext context;
    
    @Resource(mappedName = "jms/topicRents")
    private Topic topicRents;
    @Inject
    @JMSConnectionFactory("jms/topicRentsFactory")
    private JMSContext contextTopic;
    
    @EJB
    private RentsFacade rentsFacade;
    @EJB
    private PropertiesFacade propertiesFacade;
    @EJB
    private TimerBean_rents_delete timerBean_rents_delete;
    
    @PersistenceContext(unitName = "EJB_BLPU")
    
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    @Override
    public int logIn(String username, String password) {
        System.out.println("----Login Request");
        timerBean_rents_delete.myTimer();
        Users user = find(username);
        if(user == null){
            return -1;
        }
        if(user.getPassword().compareTo(password) != 0){
            return -1;
        }
        return 1;
    }

 
    @Override
    public List<Properties> getPropertiesVisitingList(String username) {
        System.out.println("----getVisitingList request");
       
       Users user = find(username);
       List<VisitingList> visitingListList = user.getVisitingListList();
       visitingListList.size(); //<-- Solving lazy relationship
       
       List<Properties> properties = new ArrayList<>();
       for (VisitingList vl: visitingListList ){
          properties.add(vl.getIdProperty());
       }
       return properties; 
    }

    @Override
    public int rentProperty(int id_property, String id_customer, String email, Date rental_date, int rental_time, String creditcard_type, String creditcard_number, String creditcard_holder) {
        System.out.println("----- rent request");
        Properties property = propertiesFacade.find(BigDecimal.valueOf(id_property));
        
        if(property != null){
            System.out.println("---property founded");
            Users user = find(id_customer);
            
            if(user != null){
                System.out.println("---user founded");
                // VERIFICAR ENTIDAD FINANCIERA
                boolean autorizarPago = true;//autorizarPago(creditcard_type, creditcard_number, creditcard_holder, rental_time);
                // -------------------------------
                if(autorizarPago){
                    Rents rent = new Rents();
                    rent.setIdProperty(property);
                    rent.setIdCustomer(user);
                    rent.setEmail(email);
                    rent.setRentalDate(rental_date);
                    rent.setRentalTime((short)rental_time);
                    rent.setCreditcardHolder(creditcard_holder);
                    rent.setCreditcardType(creditcard_type);
                    rent.setCreditcardNumber(creditcard_number);
                    rent.setId(BigDecimal.valueOf(rentsFacade.count()));
                    rentsFacade.create(rent);
                    // Send to queue
                    System.out.println("---sending to queue");

                    try {
                        sendJMSMessageToQueueMails(email+":"+String.valueOf(id_property));
                    } catch (JMSException ex) {
                        Logger.getLogger(UsersFacade.class.getName()).log(Level.SEVERE, null, ex);
                        return -3;
                    }
                    // ----------
                    // Send to topic
                    System.out.println("---sending to topic");

                    try {
                        sendJMSMessageToTopicRents(rent);
                    } catch (JMSException ex) {
                        Logger.getLogger(UsersFacade.class.getName()).log(Level.SEVERE, null, ex);
                        return -4;
                    }
                    // ----------
                    return 1;
                }else{
                    System.out.println("---payment dont accepted");
                    return -3;
                }
            }else{
                return -2;
            }
        }else{
            return -1;
        }
    }    

    private void sendJMSMessageToQueueMails(String messageData) throws JMSException {
        TextMessage msg = context.createTextMessage();
        msg.setText(messageData);
        context.createProducer().send(queueMails, msg);
    }

    private void sendJMSMessageToTopicRents(Rents rentNotification) throws JMSException {
        MapMessage msg = contextTopic.createMapMessage();
        msg.setInt("id_property", rentNotification.getIdProperty().getId().intValue());
        msg.setString("id_customer", rentNotification.getIdCustomer().getUsername());
        msg.setString("email", rentNotification.getEmail());
        msg.setShort("rental_time", rentNotification.getRentalTime());
        msg.setString("rental_date", rentNotification.getRentalDate().toString());
        msg.setString("creditcard_holder", rentNotification.getCreditcardHolder());
        msg.setString("creditcard_type", rentNotification.getCreditcardType());
        msg.setString("creditcard_number", rentNotification.getCreditcardNumber());
        msg.setInt("id_rent", rentNotification.getId().intValue());
        contextTopic.createProducer().send(topicRents, msg);
    }
    
}

