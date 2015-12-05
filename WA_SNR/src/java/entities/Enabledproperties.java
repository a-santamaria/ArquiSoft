/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 5)
    @Column(name = "ENABLED")
    private String enabled;

    public Enabledproperties() {
    }

    public Enabledproperties(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (address != null ? address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enabledproperties)) {
            return false;
        }
        Enabledproperties other = (Enabledproperties) object;
        if ((this.address == null && other.address != null) || (this.address != null && !this.address.equals(other.address))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Enabledproperties[ address=" + address + " ]";
    }
    
}
