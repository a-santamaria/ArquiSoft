/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Rents;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface RentsFacadeRemote {

    void create(Rents rents);

    void edit(Rents rents);

    void remove(Rents rents);

    Rents find(Object id);

    List<Rents> findAll();

    List<Rents> findRange(int[] range);

    int count();
    
    List<Rents> getActiveRents();
    
}
