/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instancias;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario iTC
 */
@Entity
@Table(name = "clasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c")
    , @NamedQuery(name = "Clasificacion.findByNombreclasi", query = "SELECT c FROM Clasificacion c WHERE c.nombreclasi = :nombreclasi")})
public class Clasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nombreclasi")
    private String nombreclasi;
    @OneToMany(mappedBy = "clasificacion")
    private Collection<Juego> juegoCollection;

    public Clasificacion() {
    }

    public Clasificacion(String nombreclasi) {
        this.nombreclasi = nombreclasi;
    }

    public String getNombreclasi() {
        return nombreclasi;
    }

    public void setNombreclasi(String nombreclasi) {
        this.nombreclasi = nombreclasi;
    }

    @XmlTransient
    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreclasi != null ? nombreclasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.nombreclasi == null && other.nombreclasi != null) || (this.nombreclasi != null && !this.nombreclasi.equals(other.nombreclasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instancias.Clasificacion[ nombreclasi=" + nombreclasi + " ]";
    }
    
}
