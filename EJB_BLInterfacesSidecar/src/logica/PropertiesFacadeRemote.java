/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entities.Properties;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface PropertiesFacadeRemote {

    void create(Properties properties);

    void edit(Properties properties);

    void remove(Properties properties);

    Properties find(Object id);

    List<Properties> findAll();

    List<Properties> findRange(int[] range);

    int count();
    
}
