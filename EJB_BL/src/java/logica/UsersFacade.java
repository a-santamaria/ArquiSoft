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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements logica.UsersFacadeRemote {
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
                
                // -------------------------------
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
                return 1;
            }else{
                return -2;
            }
        }else{
            return -1;
        }
    }    
    
}

