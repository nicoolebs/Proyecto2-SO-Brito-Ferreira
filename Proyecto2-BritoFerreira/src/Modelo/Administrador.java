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
    
//    Método para crear una consola
    public void crearConsola(){
        
//        Primero se calcula una probabilidad entre 0 y 100
//        Si la probabilidad está entre 0 y 70 incluido:
//          Se calcula un numero entre 1 y 3
//          Dependiendo de lo que salga se coloca en cola de prioridad del número correspondiente
//          Y se actualiza el contador del id actual de consolas creadas
        
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
    
//    Método para darle una consola al robot para que la revise
    public SuperSwitch entregarConsolaAlRobot(){
        
//        Si hay consolas en la cola de prioridad 1, se desencola una de allí primero
//        Si no, si hay consolas en la cola de prioridad 2, se desencola una de allí
//        Si no, si hay consolas en la cola de prioridad 3, se desencola una de allí
//        Si no hay consolas en ninguna cola, se devuelve null
        
        if(!Simulador.prioridadUno.estaVacia()){
            
            return Simulador.prioridadUno.desencolar();
            
        }else if(!Simulador.prioridadDos.estaVacia()){
            
            return Simulador.prioridadDos.desencolar();
            
        }else if(!Simulador.prioridadTres.estaVacia()){
            
            return Simulador.prioridadTres.desencolar();
            
        }
        
        return null;
        
    }
    
//    Método para actualizar las colas de prioridad
    public void actualizarColas(){
        
//        VARIABLES
        
//        Una cola auxiliar para ir metiendo las consolas y un consola auxiliar para ir actualizando los datos
        Cola auxiliar = new Cola();
        SuperSwitch consolaAux;
        
//        Actualizar contadores

//      Se recorre la cola de prioridad 2 y se van desencolando las consolas una a una
//      Se va actualizando los contadores del número de consolas revisadas, sumándole 1
//      Se van metiendo en la cola auxiliar para que no se pierda la cola

//      Y se asigna la cola auxiliar como la cola de prioridad 2, como si no hubiera pasado nada
//      Se reinicia la cola auxiliar para seguir usándola

//      Se hace el mismo proceso con la cola de prioridad 3

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
        
        System.out.println("        Contadores de consolas actualizados");
        
//        Actualizar colas

//      Se recorre la cola de prioridad 2 y se van desencolando las consolas una a una
//      Se revisa si los contadores son iguales a 15
//      Si son iguales a 15 entonces:
//          Se reinicia el contador de consolas revisadas antes de la actual
//          Se cambia la prioridad a 1
//          Se reinicia el apuntador al siguiente nodo
//          Se encola la consola en la cola de prioridad 1
//      En caso contrario:
//          Se encola en la cola auxiliar para luego meterlo en la misma cola de prioridad

//      Y se asigna la cola auxiliar como la cola de prioridad 2, como si no hubiera pasado nada
//      Se reinicia la cola auxiliar para seguir usándola

//      Se hace el mismo proceso con la cola de prioridad 3, pero las consolas que cumplan la condicion cambian a prioridad 2
        
        while(!Simulador.prioridadDos.estaVacia()){
            
            consolaAux = Simulador.prioridadDos.desencolar();
            
            if(consolaAux.getNumConsolasRevisadas() == 15){
                
                System.out.println("        Consola " + consolaAux.getId() + " pasada a prioridad 1");
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
                
                System.out.println("        Consola " + consolaAux.getId() + " pasada a prioridad 2");
                consolaAux.setNumConsolasRevisadas(0);
                consolaAux.setPrioridad(2);
                consolaAux.setSig(null);
                Simulador.prioridadDos.encolarNodoConsola(consolaAux);
            
            }else{
            
                auxiliar.encolarNodoConsola(consolaAux);
            
            }
            
        }
        
        Simulador.prioridadTres = auxiliar;

        System.out.println("        Colas actualizadas");
    }
    
//    Método para actualizar la cola de mejora
    public void actualizarColaMejora(){
        
//        Primero se calcula una probabilidad entre 0 y 100 para sacar la consola de la cola de mejora
//        Si la probabilidad está entre 0 y 45 incluido:
//          Se desencola una consola de la cola de mejora
//          Se reinicia su apuntador al siguiente nodo para volverlo a encolar
//          Y dependiendo de su prioridad, se encola en la cola de prioridad correspondiente
        
        int probabilidadRepararConsola = (int) (Math.random() * 100);
        
        if(probabilidadRepararConsola <= 45){
            
            SuperSwitch consola = Simulador.colaMejora.desencolar();
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
