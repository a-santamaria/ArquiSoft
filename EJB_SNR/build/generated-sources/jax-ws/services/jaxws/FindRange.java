
package services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findRange", namespace = "http://services/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findRange", namespace = "http://services/")
public class FindRange {

    @XmlElement(name = "range", namespace = "", nillable = true)
    private int[] range;

    /**
     * 
     * @return
     *     returns int[]
     */
    public int[] getRange() {
        return this.range;
    }

    /**
     * 
     * @param range
     *     the value for the range property
     */
    public void setRange(int[] range) {
        this.range = range;
    }

}
