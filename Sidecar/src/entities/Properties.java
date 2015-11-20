/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "PROPERTIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Properties.findAll", query = "SELECT p FROM Properties p"),
    @NamedQuery(name = "Properties.findByRent", query = "SELECT p FROM Properties p WHERE p.rent = :rent"),
    @NamedQuery(name = "Properties.findByRooms", query = "SELECT p FROM Properties p WHERE p.rooms = :rooms"),
    @NamedQuery(name = "Properties.findByAddress", query = "SELECT p FROM Properties p WHERE p.address = :address"),
    @NamedQuery(name = "Properties.findById", query = "SELECT p FROM Properties p WHERE p.id = :id"),
    @NamedQuery(name = "Properties.findByType", query = "SELECT p FROM Properties p WHERE p.type = :type")})
public class Properties implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "RENT")
    private double rent;
    @Basic(optional = false)
    @Column(name = "ROOMS")
    private BigInteger rooms;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @JoinColumn(name = "ID_OWNER", referencedColumnName = "USERNAME")
    @ManyToOne
    private Users idOwner;
    @JoinColumn(name = "LOCATION", referencedColumnName = "LOCATION")
    @ManyToOne
    private Locations location;
    @OneToMany(mappedBy = "idProperty")
    private List<Rents> rentsList;
    @OneToMany(mappedBy = "idProperty")
    private List<Photos> photosList;

    public Properties() {
    }

    public Properties(BigDecimal id) {
        this.id = id;
    }

    public Properties(BigDecimal id, double rent, BigInteger rooms, String address, String type) {
        this.id = id;
        this.rent = rent;
        this.rooms = rooms;
        this.address = address;
        this.type = type;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public BigInteger getRooms() {
        return rooms;
    }

    public void setRooms(BigInteger rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Users getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Users idOwner) {
        this.idOwner = idOwner;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    @XmlTransient
    public List<Rents> getRentsList() {
        return rentsList;
    }

    public void setRentsList(List<Rents> rentsList) {
        this.rentsList = rentsList;
    }

    @XmlTransient
    public List<Photos> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<Photos> photosList) {
        this.photosList = photosList;
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
        if (!(object instanceof Properties)) {
            return false;
        }
        Properties other = (Properties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Properties[ id=" + id + " ]";
    }
    
}
