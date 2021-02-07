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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByNickname", query = "SELECT c FROM Cuenta c WHERE c.nickname = :nickname")
    , @NamedQuery(name = "Cuenta.findByContrasena", query = "SELECT c FROM Cuenta c WHERE c.contrasena = :contrasena")
    , @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "Contrasena")
    private String contrasena;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Integer idCuenta;
    @OneToMany(mappedBy = "cuentauser")
    private Collection<Usuario> usuarioCollection;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(Integer idCuenta, String nickname, String contrasena) {
        this.idCuenta = idCuenta;
        this.nickname = nickname;
        this.contrasena = contrasena;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
