/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ordon
 */
public class Juego {
    int id;
    String nombre;
    String descripcion;
    String direccportada;
    String direccminiatura;
    String requisitos;
    //archivo juego
    double precio;
    Clasificacion clasificacion;
    Valoracion valoracion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDireccportada() {
        return direccportada;
    }

    public void setDireccportada(String direccportada) {
        this.direccportada = direccportada;
    }

    public String getDireccminiatura() {
        return direccminiatura;
    }

    public void setDireccminiatura(String direccminiatura) {
        this.direccminiatura = direccminiatura;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
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
}