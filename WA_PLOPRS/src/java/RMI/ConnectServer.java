/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import javax.naming.InitialContext;
import logica.UsersFacadeRemote;
import java.util.Properties;
import javax.naming.NamingException;
import logica.RentsFacadeRemote;

/**
 *
 * @author sala_a
 */
public class ConnectServer {
    
    public static String ip="192.168.0.191";
    
    public static UsersFacadeRemote connetServerUsersFacadeRemote() throws NamingException{
        System.out.println("-------accediendo al bean");
        Properties p = new Properties();
        p.put("org.omg.CORBA.ORBInitialHost", ip);
        p.put("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(p);
        return (UsersFacadeRemote)ctx.lookup("java:global/EJB_BL/UsersFacade");
       
    }
    
    public static RentsFacadeRemote connetServerRentsFacadeRemote() throws NamingException{
        System.out.println("-------accediendo al bean");
        Properties p = new Properties();
        p.put("org.omg.CORBA.ORBInitialHost", ip);
        p.put("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(p);
        return (RentsFacadeRemote)ctx.lookup("java:global/EJB_BL/RentsFacade");
       
    }
    
    
}
