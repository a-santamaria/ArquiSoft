/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "ENABLEDPROPERTIES")
@NamedQueries({
    @NamedQuery(name = "Enabledproperties.findAll", query = "SELECT e FROM Enabledproperties e")})
public class Enabledproperties implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPERTIES_ID")
    private BigDecimal propertiesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ENABLED")
    private String enabled;
    @JoinColumn(name = "PROPERTIES_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Properties properties;

    public Enabledproperties() {
    }

    public Enabledproperties(BigDecimal propertiesId) {
        this.propertiesId = propertiesId;
    }

    public Enabledproperties(BigDecimal propertiesId, String enabled) {
        this.propertiesId = propertiesId;
        this.enabled = enabled;
    }

    public BigDecimal getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(BigDecimal propertiesId) {
        this.propertiesId = propertiesId;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertiesId != null ? propertiesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enabledproperties)) {
            return false;
        }
        Enabledproperties other = (Enabledproperties) object;
        if ((this.propertiesId == null && other.propertiesId != null) || (this.propertiesId != null && !this.propertiesId.equals(other.propertiesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Enabledproperties[ propertiesId=" + propertiesId + " ]";
    }
    
}
