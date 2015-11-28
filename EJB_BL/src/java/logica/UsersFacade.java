/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sala_a
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements logica.UsersFacadeRemote {
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
        Users user = find(username);
        if(user == null){
            return -1;
        }
        if(user.getPassword().compareTo(password) != 0){
            return -1;
        }
        return 1;
    }
}
