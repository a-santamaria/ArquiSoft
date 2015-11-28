/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "RENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rents.findAll", query = "SELECT r FROM Rents r"),
    @NamedQuery(name = "Rents.findByEmail", query = "SELECT r FROM Rents r WHERE r.email = :email"),
    @NamedQuery(name = "Rents.findByRentalDate", query = "SELECT r FROM Rents r WHERE r.rentalDate = :rentalDate"),
    @NamedQuery(name = "Rents.findByRentalTime", query = "SELECT r FROM Rents r WHERE r.rentalTime = :rentalTime"),
    @NamedQuery(name = "Rents.findById", query = "SELECT r FROM Rents r WHERE r.id = :id")})
public class Rents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "RENTAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDate;
    @Column(name = "RENTAL_TIME")
    private Short rentalTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "USERNAME")
    @ManyToOne
    private Users idCustomer;
    @JoinColumn(name = "ID_PROPERTY", referencedColumnName = "ID")
    @ManyToOne
    private Properties idProperty;

    public Rents() {
    }

    public Rents(BigDecimal id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Short getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Short rentalTime) {
        this.rentalTime = rentalTime;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Users getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Users idCustomer) {
        this.idCustomer = idCustomer;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rents)) {
            return false;
        }
        Rents other = (Rents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rents[ id=" + id + " ]";
    }
    
}
