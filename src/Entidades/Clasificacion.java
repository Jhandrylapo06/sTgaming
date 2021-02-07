/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "Clasificacion.findByIdclasificacion", query = "SELECT c FROM Clasificacion c WHERE c.idclasificacion = :idclasificacion")
    , @NamedQuery(name = "Clasificacion.findByTipo", query = "SELECT c FROM Clasificacion c WHERE c.tipo = :tipo")})
public class Clasificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasificacion")
    private Integer idclasificacion;
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(mappedBy = "clasificacion")
    private Collection<Juego> juegoCollection;

    public Clasificacion() {
    }

    public Clasificacion(Integer idclasificacion, String tipo) {
        this.idclasificacion = idclasificacion;
        this.tipo = tipo;
    }

    

    public Integer getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Integer idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idclasificacion != null ? idclasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idclasificacion == null && other.idclasificacion != null) || (this.idclasificacion != null && !this.idclasificacion.equals(other.idclasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Clasificacion[ idclasificacion=" + idclasificacion + " ]";
    }
    
}
