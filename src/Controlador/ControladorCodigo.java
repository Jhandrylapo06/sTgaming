/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Usuario iTC
 */
public class ControladorCodigo {
    public boolean comprobarcodigo(int cod, int enviado){
    boolean verificar;
        if (cod==enviado) {
            verificar=true;
        } else {
            verificar=false;
        }
    return verificar;
    
    }
    
}
