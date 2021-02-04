/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Juego;

/**
 *
 * @author ordon
 */
public class Metodos_Juego {
    public void Agregar(Juego juego){
        // se guarda los datos en la BD
    }
    public void ModificarJuego(Juego juego){
        // se modifican los datos del juego
    }
    public void dar_de_baja(Juego juego){
        // mediante el nombre se eliminara el juego
    }
    public void Clasificar(Juego juego,String clasificacion){
        juego.getClasificacion().setTipo(clasificacion);
        //Guardar la clasificacion en la BD
    }
    public void valorar(Juego juego,int valoracion){
        //PENDIENTE
    }
}