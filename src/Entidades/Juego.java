/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario iTC
 */
@Entity
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j")
    , @NamedQuery(name = "Juego.findByIdJuego", query = "SELECT j FROM Juego j WHERE j.idJuego = :idJuego")
    , @NamedQuery(name = "Juego.findByNombre", query = "SELECT j FROM Juego j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Juego.findByDescripcion", query = "SELECT j FROM Juego j WHERE j.descripcion = :descripcion")
    , @NamedQuery(name = "Juego.findByDirportada", query = "SELECT j FROM Juego j WHERE j.dirportada = :dirportada")
    , @NamedQuery(name = "Juego.findByDirminiatura", query = "SELECT j FROM Juego j WHERE j.dirminiatura = :dirminiatura")
    , @NamedQuery(name = "Juego.findByRequisitos", query = "SELECT j FROM Juego j WHERE j.requisitos = :requisitos")
    , @NamedQuery(name = "Juego.findByPrecio", query = "SELECT j FROM Juego j WHERE j.precio = :precio")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJuego")
    private Integer idJuego;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Dirportada")
    private String dirportada;
    @Column(name = "Dirminiatura")
    private String dirminiatura;
    @Column(name = "Requisitos")
    private String requisitos;
    @Column(name = "Precio")
    private String precio;
    @JoinColumn(name = "Clasificacion", referencedColumnName = "idclasificacion")
    @ManyToOne
    private Clasificacion clasificacion;
    @JoinColumn(name = "Valoracion", referencedColumnName = "idvaloracion")
    @ManyToOne
    private Valoracion valoracion;

    public Juego() {
    }

    public Juego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirportada() {
        return dirportada;
    }

    public void setDirportada(String dirportada) {
        this.dirportada = dirportada;
    }

    public String getDirminiatura() {
        return dirminiatura;
    }

    public void setDirminiatura(String dirminiatura) {
        this.dirminiatura = dirminiatura;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuego != null ? idJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.idJuego == null && other.idJuego != null) || (this.idJuego != null && !this.idJuego.equals(other.idJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Juego[ idJuego=" + idJuego + " ]";
    }
    
}
