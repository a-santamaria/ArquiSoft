/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.VisitingList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class VisitingListFacade extends AbstractFacade<VisitingList> implements logica.VisitingListFacadeRemote {
    @PersistenceContext(unitName = "EJB_BLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitingListFacade() {
        super(VisitingList.class);
    }
    
}
