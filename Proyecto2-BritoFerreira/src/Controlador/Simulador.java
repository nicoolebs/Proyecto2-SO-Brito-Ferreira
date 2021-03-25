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
    
//    VARIABLES
    
//    Colas
    public static Cola prioridadUno;
    public static Cola prioridadDos;
    public static Cola prioridadTres;
    public static Cola colaMejora;
    
//    Administrador y robot
    public static Administrador administrador;
    public static Robot robot;
    
//    Contador id consolas creadas
    public static int idActual;
    
//    Vista
    public Vista vista;

//    CONSTRUCTOR
    public Simulador() {
        
//        Se inicializarn las colas vacías, el administrador, el robot, el id inicial de consolas en 1, la vista y se empieza la simulación
        
        Simulador.prioridadUno = new Cola();
        Simulador.prioridadDos = new Cola();
        Simulador.prioridadTres = new Cola();
        Simulador.colaMejora = new Cola();
        
        Simulador.administrador = new Administrador();
        Simulador.robot = new Robot();
        
        Simulador.idActual = 1;
        
        this.vista = new Vista();
        
        this.empezar();
        
    }
    
//    MÉTODO DE LA SIMULACIÓN
    public void empezar(){
        
//        VARIABLES

//      Consola que va a esta en el robot y booleano para medir los turnos de creación de nuevas consolas
        SuperSwitch consola;
        boolean intentarCrear = true;
                   
//        Se empieza creando una consola
        administrador.crearConsola();
        
//        Bucle infinito de la simulación
        while(true){
            
//            Primero el administrador saca una consola para dársela al robot
//            Se actualiza la vista con la consola y la información de las colas
//            Se manda al robot a revisar la consola
//            Se manda al administrador a actualizar los contadores de las consolas y las colas si corresponde
//            Si hay elementos en la cola de mejora, se manda al administrado a ver si se puede sacar alguna consola de la cola
//            Si ya pasaron 2 ciclos de revisión, con el booleano intentarCrear se habilita o no al administrador para que intente crear consola
//            Se repite el ciclo
            
            consola = administrador.entregarConsolaAlRobot();
            
            vista.actualizar(consola, obtenerInfoCola1(), obtenerInfoCola2(), obtenerInfoCola3(), obtenerInfoColaMejora());
            
            robot.revisarConsola(consola);
            
            administrador.actualizarColas();
            
            if(!this.colaMejora.estaVacia()){
                
                administrador.actualizarColaMejora();
                
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
    
//    Método para imprimir la información de la cola 1
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
    
//    Método para imprimir la información de la cola 2
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
    
//    Método para imprimir la información de la cola 3
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
    
//    Método para imprimir la información de la cola de mejora
    public String obtenerInfoColaMejora(){
        
        String informacion = "";
        SuperSwitch consola;
        Cola aux = new Cola();
        
        if(colaMejora.estaVacia()){
            
            return "Cola vacía";
            
        }
        
        while (!colaMejora.estaVacia()) {
            
            consola = colaMejora.desencolar();
            aux.encolarNodoConsola(consola);
            informacion = (informacion + "Consola " + consola.getId() + "\n");
            
        }
        
        colaMejora = aux;
        
        return informacion;
        
    }
}
