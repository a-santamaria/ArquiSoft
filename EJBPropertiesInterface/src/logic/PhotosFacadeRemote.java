/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Photos;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface PhotosFacadeRemote {

    void create(Photos photos);

    void edit(Photos photos);

    void remove(Photos photos);

    Photos find(Object id);

    List<Photos> findAll();

    List<Photos> findRange(int[] range);

    int count();
    
}
