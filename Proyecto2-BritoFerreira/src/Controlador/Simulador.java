/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Cola;
import Modelo.Robot;
import Modelo.SuperSwitch;
import Vista.Vista;

/**
 *
 * @author Giselle Ferreira
 */
public class Simulador {
    
    public static Cola prioridadUno;
    public static Cola prioridadDos;
    public static Cola prioridadTres;
    public static Cola bloqueados;
    
    public static Administrador administrador;
    public static Robot robot;
    
    public static int idActual;
    
    public Vista vista;

    public Simulador() {
        
        this.prioridadUno = new Cola();
        this.prioridadDos = new Cola();
        this.prioridadTres = new Cola();
        this.bloqueados = new Cola();
        
        this.administrador = new Administrador();
        this.robot = new Robot();
        
        this.idActual = 1;
        
        this.vista = new Vista();
        
        this.empezar();
        
    }
    
    public void empezar(){
        
        SuperSwitch consola;
                    
        administrador.crearConsola();
        
        boolean intentarCrear = true;
        
        while(true){
            
            consola = administrador.entregarConsolaAlRobot();
            
            vista.actualizar(consola, obtenerInfoCola1(), obtenerInfoCola2(), obtenerInfoCola3(), obtenerInfoColaBloqueados());
            
            robot.revisarConsola(consola);
            
            administrador.actualizarColas();
            System.out.println("        Colas actualizadas");
            
            if(!this.bloqueados.estaVacia()){
                
                administrador.actualizarReparacion();
                
            }
            
            if(intentarCrear){
                
                System.out.println("                No toca crear!!!!!");
                intentarCrear = false;
                
            }else{
                
                System.out.println("                Toca crear");
                administrador.crearConsola();
                intentarCrear = true;
                
            }
            
        }
    
    }
    
    public String obtenerInfoCola1(){
        
        String informacion = "";
        SuperSwitch consola;
        Cola aux = new Cola();
        
        if(prioridadUno.estaVacia()){
            
            return "Cola vacía";
            
        }
        
        while (!prioridadUno.estaVacia()) {
            
            consola = prioridadUno.desencolar();
            aux.encolarNodoConsola(consola);
            informacion = (informacion + "Consola " + consola.getId() + "\n");
            
        }
        
        prioridadUno = aux;
        
        return informacion;
        
    }
    
    public String obtenerInfoCola2(){
        
        String informacion = "";
        SuperSwitch consola;
        Cola aux = new Cola();
        
        if(prioridadDos.estaVacia()){
            
            return "Cola vacía";
            
        }
        
        while (!prioridadDos.estaVacia()) {
            
            consola = prioridadDos.desencolar();
            aux.encolarNodoConsola(consola);
            informacion = (informacion + "Consola " + consola.getId() + "\n");
            
        }
        
        prioridadDos = aux;
        
        return informacion;
        
    }
    
    public String obtenerInfoCola3(){
        
        String informacion = "";
        SuperSwitch consola;
        Cola aux = new Cola();
        
        if(prioridadTres.estaVacia()){
            
            return "Cola vacía";
            
        }
        
        while (!prioridadTres.estaVacia()) {
            
            consola = prioridadTres.desencolar();
            aux.encolarNodoConsola(consola);
            informacion = (informacion + "Consola " + consola.getId() + "\n");
            
        }
        
        prioridadTres = aux;
        
        return informacion;
        
    }
    
    public String obtenerInfoColaBloqueados(){
        
        String informacion = "";
        SuperSwitch consola;
        Cola aux = new Cola();
        
        if(bloqueados.estaVacia()){
            
            return "Cola vacía";
            
        }
        
        while (!bloqueados.estaVacia()) {
            
            consola = bloqueados.desencolar();
            aux.encolarNodoConsola(consola);
            informacion = (informacion + "Consola " + consola.getId() + "\n");
            
        }
        
        bloqueados = aux;
        
        return informacion;
        
    }
}
