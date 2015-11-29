/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Rents;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.MessagingException;

/**
 *
 * @author sala_a
 */
@Stateless
@LocalBean
public class TimerBean_rents_delete {
    @EJB
    private MailManager mailManager;
    @EJB
    private RentsFacade rentsFacade;
    
    @Schedule(minute="*",hour="*", persistent=false)
    public void myTimer() {
        long diff, hours;
        Date actual = new Date();
        List<Rents> rents = rentsFacade.findAll();
        for (Rents rent : rents) {
            diff = actual.getTime()-rent.getRentalDate().getTime();
            hours = diff/ (60 * 60 * 1000);
            if(hours > 24){
                rent.setEstado(BigInteger.valueOf(2));
                rentsFacade.edit(rent);
            }
        }
    }
}
