/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.VisitingList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sala_a
 */
@Remote
public interface VisitingListFacadeRemote {

    void create(VisitingList visitingList);

    void edit(VisitingList visitingList);

    void remove(VisitingList visitingList);

    VisitingList find(Object id);

    List<VisitingList> findAll();

    List<VisitingList> findRange(int[] range);

    int count();
    
}
