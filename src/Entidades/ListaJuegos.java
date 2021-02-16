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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ordon
 */
@Entity
@Table(name = "lista_juegos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaJuegos.findAll", query = "SELECT l FROM ListaJuegos l"),
    @NamedQuery(name = "ListaJuegos.findByIdListajuegos", query = "SELECT l FROM ListaJuegos l WHERE l.idListajuegos = :idListajuegos")})
public class ListaJuegos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLista_juegos")
    private Integer idListajuegos;
    @JoinColumn(name = "Cuenta", referencedColumnName = "id_cuenta")
    @ManyToOne
    private Cuenta cuenta;
    @JoinColumn(name = "Juegos", referencedColumnName = "idJuego")
    @ManyToOne
    private Juego juegos;

    public ListaJuegos() {
    }

    public ListaJuegos(Integer idListajuegos, Cuenta cuenta, Juego juegos) {
        this.idListajuegos = idListajuegos;
        this.cuenta = cuenta;
        this.juegos = juegos;
    }

    public ListaJuegos(Integer idListajuegos) {
        this.idListajuegos = idListajuegos;
    }

    public Integer getIdListajuegos() {
        return idListajuegos;
    }

    public void setIdListajuegos(Integer idListajuegos) {
        this.idListajuegos = idListajuegos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Juego getJuegos() {
        return juegos;
    }

    public void setJuegos(Juego juegos) {
        this.juegos = juegos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListajuegos != null ? idListajuegos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaJuegos)) {
            return false;
        }
        ListaJuegos other = (ListaJuegos) object;
        if ((this.idListajuegos == null && other.idListajuegos != null) || (this.idListajuegos != null && !this.idListajuegos.equals(other.idListajuegos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ListaJuegos[ idListajuegos=" + idListajuegos + " ]";
    }
    
}
