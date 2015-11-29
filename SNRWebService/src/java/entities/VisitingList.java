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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "VISITING_LIST")
@NamedQueries({
    @NamedQuery(name = "VisitingList.findAll", query = "SELECT v FROM VisitingList v")})
public class VisitingList implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VISITING_LIST")
    private BigDecimal idVisitingList;
    @JoinColumn(name = "ID_USER", referencedColumnName = "USERNAME")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "ID_PROPERTY", referencedColumnName = "ID")
    @ManyToOne
    private Properties idProperty;

    public VisitingList() {
    }

    public VisitingList(BigDecimal idVisitingList) {
        this.idVisitingList = idVisitingList;
    }

    public BigDecimal getIdVisitingList() {
        return idVisitingList;
    }

    public void setIdVisitingList(BigDecimal idVisitingList) {
        this.idVisitingList = idVisitingList;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Properties getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Properties idProperty) {
        this.idProperty = idProperty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitingList != null ? idVisitingList.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitingList)) {
            return false;
        }
        VisitingList other = (VisitingList) object;
        if ((this.idVisitingList == null && other.idVisitingList != null) || (this.idVisitingList != null && !this.idVisitingList.equals(other.idVisitingList))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VisitingList[ idVisitingList=" + idVisitingList + " ]";
    }
    
}
