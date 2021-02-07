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
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByIdvaloracion", query = "SELECT v FROM Valoracion v WHERE v.idvaloracion = :idvaloracion")
    , @NamedQuery(name = "Valoracion.findByValor", query = "SELECT v FROM Valoracion v WHERE v.valor = :valor")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvaloracion")
    private Integer idvaloracion;
    @Column(name = "Valor")
    private Short valor;
    @OneToMany(mappedBy = "valoracion")
    private Collection<Juego> juegoCollection;

    public Valoracion() {
    }

    public Valoracion(Integer idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public Integer getIdvaloracion() {
        return idvaloracion;
    }

    public void setIdvaloracion(Integer idvaloracion) {
        this.idvaloracion = idvaloracion;
    }

    public Short getValor() {
        return valor;
    }

    public void setValor(Short valor) {
        this.valor = valor;
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
        hash += (idvaloracion != null ? idvaloracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idvaloracion == null && other.idvaloracion != null) || (this.idvaloracion != null && !this.idvaloracion.equals(other.idvaloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Valoracion[ idvaloracion=" + idvaloracion + " ]";
    }
    
}
