package entities;

import entities.Properties;
import entities.Users;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T18:20:04")
@StaticMetamodel(VisitingList.class)
public class VisitingList_ { 

    public static volatile SingularAttribute<VisitingList, BigDecimal> idVisitingList;
    public static volatile SingularAttribute<VisitingList, Users> idUser;
    public static volatile SingularAttribute<VisitingList, Properties> idProperty;

}