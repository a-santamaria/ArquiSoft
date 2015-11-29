package entities;

import entities.Enabledproperties;
import entities.Locations;
import entities.Photos;
import entities.Rents;
import entities.Users;
import entities.VisitingList;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T18:20:05")
@StaticMetamodel(Properties.class)
public class Properties_ { 

    public static volatile SingularAttribute<Properties, BigDecimal> id;
    public static volatile SingularAttribute<Properties, Enabledproperties> enabledproperties;
    public static volatile SingularAttribute<Properties, String> address;
    public static volatile SingularAttribute<Properties, Locations> location;
    public static volatile ListAttribute<Properties, VisitingList> visitingListList;
    public static volatile SingularAttribute<Properties, Double> rent;
    public static volatile ListAttribute<Properties, Rents> rentsList;
    public static volatile ListAttribute<Properties, Photos> photosList;
    public static volatile SingularAttribute<Properties, String> type;
    public static volatile SingularAttribute<Properties, BigInteger> rooms;
    public static volatile SingularAttribute<Properties, Users> idOwner;

}