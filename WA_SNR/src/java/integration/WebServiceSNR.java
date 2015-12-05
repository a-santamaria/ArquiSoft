/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import entities.Enabledproperties;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import logic.EnabledpropertiesFacade;

/**
 *
 * @author sala_a
 */
@WebService(serviceName = "WebServiceSNR")
public class WebServiceSNR {
    @EJB
    private EnabledpropertiesFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Enabledproperties entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Enabledproperties entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Enabledproperties entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public boolean find(@WebParam(name = "id") String id) {
        boolean sw=true;
        try {
            Enabledproperties e= ejbRef.find(id);
            sw=e.getEnabled().equals("Yes");
        } catch (Exception e) {
            sw=false;
        }
   
        return sw;
    }

    @WebMethod(operationName = "findAll")
    public List<Enabledproperties> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Enabledproperties> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
