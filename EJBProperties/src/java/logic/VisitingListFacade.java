/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.VisitingList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class VisitingListFacade extends AbstractFacade<VisitingList> implements logic.VisitingListFacadeRemote {
    @PersistenceContext(unitName = "EJBPropertiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitingListFacade() {
        super(VisitingList.class);
    }
    
}
