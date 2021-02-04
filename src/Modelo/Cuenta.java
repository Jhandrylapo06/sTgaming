/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ordon
 */
public class Cuenta {
    String nusuario;
    String clave;
    String direccfoto;
    public static List<Juego> juegoscomprados=new ArrayList<>();
    int id;
    boolean rol;

    public Cuenta(String nusuario, String clave) {
        this.nusuario = nusuario;
        this.clave = clave;
    }

    public String getNusuario() {
        return nusuario;
    }

    public void setNusuario(String nusuario) {
        this.nusuario = nusuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccfoto() {
        return direccfoto;
    }

    public void setDireccfoto(String direccfoto) {
        this.direccfoto = direccfoto;
    }

    public static List<Juego> getJuegoscomprados() {
        return juegoscomprados;
    }

    public static void setJuegoscomprados(List<Juego> juegoscomprados) {
        Cuenta.juegoscomprados = juegoscomprados;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
       this.rol = rol;
    }
}