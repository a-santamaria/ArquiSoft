package entities;

import entities.Properties;
import entities.Users;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T18:20:04")
@StaticMetamodel(Rents.class)
public class Rents_ { 

    public static volatile SingularAttribute<Rents, BigDecimal> id;
    public static volatile SingularAttribute<Rents, String> creditcardNumber;
    public static volatile SingularAttribute<Rents, BigInteger> estado;
    public static volatile SingularAttribute<Rents, Users> idCustomer;
    public static volatile SingularAttribute<Rents, String> email;
    public static volatile SingularAttribute<Rents, Short> rentalTime;
    public static volatile SingularAttribute<Rents, String> creditcardType;
    public static volatile SingularAttribute<Rents, String> creditcardHolder;
    public static volatile SingularAttribute<Rents, Properties> idProperty;
    public static volatile SingularAttribute<Rents, Date> rentalDate;

}