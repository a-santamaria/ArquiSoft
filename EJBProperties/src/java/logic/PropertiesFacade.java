/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Properties;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class PropertiesFacade extends AbstractFacade<Properties> implements logic.PropertiesFacadeRemote {
    @PersistenceContext(unitName = "EJBPropertiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropertiesFacade() {
        super(Properties.class);
    }
    
}
