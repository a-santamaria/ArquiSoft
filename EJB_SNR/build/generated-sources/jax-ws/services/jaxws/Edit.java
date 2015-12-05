
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "edit", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edit", namespace = "http://services/")
public class Edit {

    @XmlElement(name = "entity", namespace = "")
    private entities.Enabledproperties entity;

    /**
     * 
     * @return
     *     returns Enabledproperties
     */
    public entities.Enabledproperties getEntity() {
        return this.entity;
    }

    /**
     * 
     * @param entity
     *     the value for the entity property
     */
    public void setEntity(entities.Enabledproperties entity) {
        this.entity = entity;
    }

}
