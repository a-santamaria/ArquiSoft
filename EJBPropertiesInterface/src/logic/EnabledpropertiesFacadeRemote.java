/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Enabledproperties;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface EnabledpropertiesFacadeRemote {

    void create(Enabledproperties enabledproperties);

    void edit(Enabledproperties enabledproperties);

    void remove(Enabledproperties enabledproperties);

    Enabledproperties find(Object id);

    List<Enabledproperties> findAll();

    List<Enabledproperties> findRange(int[] range);

    int count();
    
}
