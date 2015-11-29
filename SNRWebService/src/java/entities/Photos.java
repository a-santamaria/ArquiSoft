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
import javax.validation.constraints.Size;

/**
 *
 * @author sala_a
 */
@Entity
@Table(name = "PHOTOS")
@NamedQueries({
    @NamedQuery(name = "Photos.findAll", query = "SELECT p FROM Photos p")})
public class Photos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "URL")
    private String url;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PHOTO")
    private BigDecimal idPhoto;
    @JoinColumn(name = "ID_PROPERTY", referencedColumnName = "ID")
    @ManyToOne
    private Properties idProperty;

    public Photos() {
    }

    public Photos(BigDecimal idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Photos(BigDecimal idPhoto, String url) {
        this.idPhoto = idPhoto;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(BigDecimal idPhoto) {
        this.idPhoto = idPhoto;
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
        hash += (idPhoto != null ? idPhoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photos)) {
            return false;
        }
        Photos other = (Photos) object;
        if ((this.idPhoto == null && other.idPhoto != null) || (this.idPhoto != null && !this.idPhoto.equals(other.idPhoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Photos[ idPhoto=" + idPhoto + " ]";
    }
    
}
