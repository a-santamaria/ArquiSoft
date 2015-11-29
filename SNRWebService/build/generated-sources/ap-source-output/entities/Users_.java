package entities;

import entities.Properties;
import entities.Rents;
import entities.VisitingList;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T18:20:05")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile ListAttribute<Users, Properties> propertiesList;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile ListAttribute<Users, VisitingList> visitingListList;
    public static volatile SingularAttribute<Users, String> role;
    public static volatile ListAttribute<Users, Rents> rentsList;
    public static volatile SingularAttribute<Users, String> password;

}