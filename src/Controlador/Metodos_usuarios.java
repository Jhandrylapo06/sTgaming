/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.Rol;
import Modelo.Usuario;

/**
 *
 * @author ordon
 */
public class Metodos_usuarios {
    public void Registrar(Usuario u) {
        // que se guarde el usuario en la BD
    }
    public void Ingresar(String nombreuser, String contraseña){
        // se valida con los datos de la BD
    }
    public void ModificarRol(String Nombreuser){
        // se cambia el rol en la BD
    }
    public void Modificardatos(){
        // se guardan los cambios en la BD
    }
    public void cambiarcontra(String Contraseñanew){
        // se cambia la contraseña en la BD
    }
    public void asignarRol(Usuario u,String Rol){
        Rol rol=new Rol();
        rol.setTipo(Rol);
        // se cambia el rol del usuario en la  BD
    }
    public void dar_de_baja(Usuario u){
        // se elimina al usuario de la BD
    }
    
}
