/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Simulador;

/**
 *
 * @author Giselle Ferreira
 */
public class Administrador {
    
    public void crearConsola(){
        
        int probabilidadCrearConsola = (int) (Math.random() * 100);
        
        if(probabilidadCrearConsola <= 70){
            
            int prioridad = (int) ((Math.random() * 3) + 1);
            
            if(prioridad == 1){
                
                Simulador.prioridadUno.encolarConsola(Simulador.idActual, prioridad);
                Simulador.idActual++;
                
            }else if(prioridad == 2){
                
                Simulador.prioridadDos.encolarConsola(Simulador.idActual, prioridad);
                Simulador.idActual++;
                
            }else{
                
                Simulador.prioridadTres.encolarConsola(Simulador.idActual, prioridad);
                Simulador.idActual++;
                
            }
            
        }
        
    }
    
    public SuperSwitch entregarConsolaAlRobot(){
        
        if(!Simulador.prioridadUno.estaVacia()){
            
            return Simulador.prioridadUno.desencolar();
            
        }else if(!Simulador.prioridadDos.estaVacia()){
            
            return Simulador.prioridadDos.desencolar();
        }else{
            
            return Simulador.prioridadTres.desencolar();
        }
        
    }
    
}
