package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RMI.ConnectServer;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entities.Rents;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.RentsFacadeRemote;

/**
 *
 * @author sala_a
 */
@Named(value = "mB_Rent")
@Dependent
public class MB_Rent {
    
    
    RentsFacadeRemote rentsFacadeRemote = null;
    private String id_rent;
    private String id_customer;
    private String email;
    private String rent_property;
    private String date;
    private String time;
    
    /**
     * Creates a new instance of MB_Rent
     */
    public MB_Rent() throws NamingException {
        //this.rentsFacadeRemote= ConnectServer.connetServerRentsFacadeRemote();
        /*Map<String,String> params = FacesContext.getExternalContext().getRequestParameterMap();
        this.id_rent=params.get("id");*/
    }
    
    public String updateIdRent(){
        //this.id_rent=id_rent;
        //System.out.println(this.id_rent);
       
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        System.out.println(origRequest.getParameter("id"));
        String msn="ERROR";
        if(origRequest.getParameter("id")!=null){
            Rents rent=(Rents) this.rentsFacadeRemote.find(origRequest.getParameter("id"));
            if (rent!=null){
                msn="BIENVENIDO !!";
                this.id_rent=rent.getId().toString();
                this.date=rent.getRentalDate().toString();
                this.email=rent.getEmail().toString();
                this.id_customer=rent.getIdCustomer().toString();
                this.rent_property=rent.getIdProperty().toString();
            }
        }
        
        return msn;
    } 
    
    public void downloadFile() {
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
        response.setHeader("Content-Disposition", "attachment;filename=Renta.txt");  
        response.setContentLength((int) 25);  
        ServletOutputStream out = null;  
        try {  
            //FileInputStream input = new FileInputStream(file);  
            out = response.getOutputStream();  
            int i = 0;  
            String renta="|adasdsad|";
            //while ((i = input.read(buffer)) != -1) {  
                out.println("Contrado de arendamiento");
                out.println("Se arrienda al cliente: ");  
                out.println("ID cliente"+this.id_customer); 
                out.println("E-mail cliente"+this.email); 
                out.println("La propidad:"); 
                out.println("ID Porpiedad"+this.rent_property); 
                out.println("Fecha de la renta :"+this.date); 
                out.println("Tiempo de la renta:"+this.time); 
                out.flush();  
            //}  
            FacesContext.getCurrentInstance().getResponseComplete();  
        } catch (IOException err) {  
            err.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
            } catch (IOException err) {  
                err.printStackTrace();  
            }  
        }  
    //*/
    }
    
    public RentsFacadeRemote getRentsFacadeRemote() {
        return rentsFacadeRemote;
    }

    public void setRentsFacadeRemote(RentsFacadeRemote rentsFacadeRemote) {
        this.rentsFacadeRemote = rentsFacadeRemote;
    }

    public String getId_rent() {
        return id_rent;
    }

    public void setId_rent(String id_rent) {
        System.out.println(">>>>>>"+id_rent);
        this.id_rent = id_rent;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRent_property() {
        return rent_property;
    }

    public void setRent_property(String rent_property) {
        this.rent_property = rent_property;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
    
}
