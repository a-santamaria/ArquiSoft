/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Rents;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@LocalBean
@Stateless
public class RentsFacade extends AbstractFacade<Rents> implements logica.RentsFacadeRemote {
    @PersistenceContext(unitName = "EJB_BLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentsFacade() {
        super(Rents.class);
    }

    @Override
    public List<Rents> getActiveRents() {
        List<Rents> rents = findAll();
        List<Rents> activeRents = new ArrayList<>();
        for (Rents rent : rents) {
            if(rent.getEstado().intValue() == 1)
                activeRents.add(rent);
        }
        return activeRents;
    }
    
    
}
