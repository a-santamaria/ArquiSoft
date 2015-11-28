/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface UsersFacadeRemote {

    void create(Users users);

    void edit(Users users);

    void remove(Users users);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();
    
    int logIn(String username, String password);
}
