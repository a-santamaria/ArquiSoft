/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import RMI.ConnectServer;
import entities.Properties;
import entities.Rents;
import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import logica.UsersFacadeRemote;

/**
 *
 * @author sala_a
 */
@Named(value = "mB_User")
@SessionScoped
public class MB_User implements Serializable {

    UsersFacadeRemote usersFacadeRemote = null;
    private String username, password;
    private List<Properties> propertieses;
    ///-----------------------------------
    private int id_property;
    //private String id_customer;
    private String email; 
    private Date rental_date;
    private int rental_time; 
    private String creditcard_type; 
    private String creditcard_number; 
    private String creditcard_holder;
    ///-------------------------------
    
    /**
     * Creates a new instance of MB_User
     */
    public MB_User() throws NamingException  {
        System.out.println("-------accediendo al bean");
        this.usersFacadeRemote = ConnectServer.connetServerUsersFacadeRemote();
        System.out.println("-------bean referenciado");
        this.propertieses=null;
    }
    
     
    public List<Users> listUsers() {
        List<Users> users = usersFacadeRemote.findAll();
        return users;
    }
    
    public String logIn(){
        System.out.println("------Iniciando sesión");
        int role = usersFacadeRemote.logIn(username, password);
        if(role == -1){
            System.out.println("No Logeado");
        }else{
            if(role == 1){
                System.out.println("Owner Logged");
                return "ownerHome";
            }else{
                System.out.println("Client logged");
                return "clientHome";
            }
        }
        return "";
    }
    
    public List<Properties> getVistingList() {
        System.out.println("------>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ---> "+username);
        if (propertieses==null){
            this.propertieses = usersFacadeRemote.getPropertiesVisitingList(username);
        }
        for (Properties propertiese : propertieses) {
            System.out.println(propertiese.getAddress());
        }
        return propertieses;
    }
    
    public String  goToRentProperty(int idProperty){
        this.id_property=idProperty;
        return "rentProperty";
    }
    
    public String createRent(){
        rental_date=new Date();
       int response=usersFacadeRemote.rentProperty(id_property, username, email, rental_date, rental_time, creditcard_type, creditcard_number, creditcard_holder);
        return "ownerHome";
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UsersFacadeRemote getUsersFacadeRemote() {
        return usersFacadeRemote;
    }

    public void setUsersFacadeRemote(UsersFacadeRemote usersFacadeRemote) {
        this.usersFacadeRemote = usersFacadeRemote;
    }

    public List<Properties> getPropertieses() {
        return propertieses;
    }

    public void setPropertieses(List<Properties> propertieses) {
        this.propertieses = propertieses;
    }

    public int getId_property() {
        return id_property;
    }

    public void setId_property(int id_property) {
        this.id_property = id_property;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRental_date() {
        return rental_date;
    }

    public void setRental_date(Date rental_date) {
        this.rental_date = rental_date;
    }

    public int getRental_time() {
        return rental_time;
    }

    public void setRental_time(int rental_time) {
        this.rental_time = rental_time;
    }

    public String getCreditcard_type() {
        return creditcard_type;
    }

    public void setCreditcard_type(String creditcard_type) {
        this.creditcard_type = creditcard_type;
    }

    public String getCreditcard_number() {
        return creditcard_number;
    }

    public void setCreditcard_number(String creditcard_number) {
        this.creditcard_number = creditcard_number;
    }

    public String getCreditcard_holder() {
        return creditcard_holder;
    }

    public void setCreditcard_holder(String creditcard_holder) {
        this.creditcard_holder = creditcard_holder;
    }
    
    
    
    
    public String getPageOwnerHome(){
        return "ownerHome";
    } 
    
    public String getPageVisitingList(){
        return "viewVisitingList";
    }
    
    public List<Rents> getListActiveRents(){
        
       return null;
        
    }
    
}
