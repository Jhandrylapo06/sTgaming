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
public class Compra {
    
    int id;
    public static List<Juego> listacomprados=new ArrayList<>();
    Juego juego;

    public Compra() {
    }

    public static List<Juego> getListacomprados() {
        return listacomprados;
    }

    public static void setListacomprados(List<Juego> listacomprados) {
        Compra.listacomprados = listacomprados;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    
    
}