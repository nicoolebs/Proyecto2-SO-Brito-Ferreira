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
            System.out.println("                    Consola creada");
        }else{
            System.out.println("                    Consola NO creada!!!!!!!!!!");
        }
        
    }
    
    public SuperSwitch entregarConsolaAlRobot(){
        
        if(!Simulador.prioridadUno.estaVacia()){
            
            return Simulador.prioridadUno.desencolar();
            
        }else if(!Simulador.prioridadDos.estaVacia()){
            
            return Simulador.prioridadDos.desencolar();
            
        }else if(!Simulador.prioridadTres.estaVacia()){
            
            return Simulador.prioridadTres.desencolar();
            
        }
        
        return null;
        
    }
    
    public void actualizarColas(){
        
        Cola auxiliar = new Cola();
        SuperSwitch consolaAux;
        
//        Actualizar contadores

        while(!Simulador.prioridadDos.estaVacia()){
            
            consolaAux = Simulador.prioridadDos.desencolar();
            consolaAux.setNumConsolasRevisadas(consolaAux.getNumConsolasRevisadas() + 1);
            auxiliar.encolarNodoConsola(consolaAux);
            
        }
        
        Simulador.prioridadDos = auxiliar;
        auxiliar = new Cola();
        
        while(!Simulador.prioridadTres.estaVacia()){
            
            consolaAux = Simulador.prioridadTres.desencolar();
            consolaAux.setNumConsolasRevisadas(consolaAux.getNumConsolasRevisadas() + 1);
            auxiliar.encolarNodoConsola(consolaAux);
            
        }
        
        Simulador.prioridadTres = auxiliar;
        auxiliar = new Cola();
        
//        Actualizar colas
        
        while(!Simulador.prioridadDos.estaVacia()){
            
            consolaAux = Simulador.prioridadDos.desencolar();
            
            if(consolaAux.getNumConsolasRevisadas() == 15){
                
                consolaAux.setNumConsolasRevisadas(0);
                consolaAux.setPrioridad(1);
                consolaAux.setSig(null);
                Simulador.prioridadUno.encolarNodoConsola(consolaAux);
            
            }else{
            
                auxiliar.encolarNodoConsola(consolaAux);
            
            }
            
        }
        
        Simulador.prioridadDos = auxiliar;
        auxiliar = new Cola();
        
        while(!Simulador.prioridadTres.estaVacia()){
            
            consolaAux = Simulador.prioridadTres.desencolar();
            
            if(consolaAux.getNumConsolasRevisadas() == 15){
                
                consolaAux.setNumConsolasRevisadas(0);
                consolaAux.setPrioridad(1);
                consolaAux.setSig(null);
                Simulador.prioridadDos.encolarNodoConsola(consolaAux);
            
            }else{
            
                auxiliar.encolarNodoConsola(consolaAux);
            
            }
            
        }
        
        Simulador.prioridadTres = auxiliar;

    }
    
    public void actualizarReparacion(){
        
        int probabilidadRepararConsola = (int) (Math.random() * 100);
        
        if(probabilidadRepararConsola <= 45){
            
            SuperSwitch consola = Simulador.bloqueados.desencolar();
            consola.setSig(null);
            
            if(consola.getPrioridad() == 1){
                
                Simulador.prioridadUno.encolarNodoConsola(consola);
                
            }else if(consola.getPrioridad() == 2){
                
                Simulador.prioridadDos.encolarNodoConsola(consola);
                
            }else{
                
                Simulador.prioridadTres.encolarNodoConsola(consola);
                
            }
            System.out.println("            Sacado de reparacion");
        }else{
            System.out.println("            Quede en reparacion!!!!!!!");
        }
        
    }
    
}
