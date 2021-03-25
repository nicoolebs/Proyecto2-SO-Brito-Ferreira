/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Simulador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giselle Ferreira
 */
public class Robot {
    
//    Método para revisar una consola
    public void revisarConsola(SuperSwitch consola){
        
//        Primero se revisa si se pasó o no una consola por el parámetro
//          Si se pasó entonces pasa a revisar y hace lo siguiente:

//              El robot duerme 7 segundos mientras revisa la consola
//              Se reinicia el contador de consolas revisadas antes de esta consola
//              Se reinicia el el apuntador de la consola al siguiente nodo de la cola porque se puede mover de cola
//              Se calcula una probabilidad entre 0 y 100

//              Si la probabilidad esta entre 0 y 30 incluido (30%):
//                  Se imprime que la consola está despachada y no se hace mas nada con ella
//              Si la probabilidad esta entre 30 no incluido y 50 incluido (20%):
//                  Se mete la consola en la cola de consolas para mejorar y se imprime que la consola va a mejora
//              Si la probabilidad esta entre 50 no incluido y 100 incluido (50%):
//                  Se mete la consola en la cola de su prioridad nuevamente y se imprime que la consola va a su cola correspondiente
        
        
        if(consola != null){
            System.out.println("\nRevisando");
            try {
                Thread.sleep(7000);
                
                consola.setNumConsolasRevisadas(0);
                consola.setSig(null);
                
                int probabilidad = (int) (Math.random() * 100);
                
                if(probabilidad <= 30){
                    
                    System.out.println("Consola despachada:");
                    System.out.println("ID: " + consola.getId());
                    System.out.println("Prioridad: " + consola.getPrioridad());
                    
                }else if(probabilidad <= 50){
                    
                    Simulador.colaMejora.encolarNodoConsola(consola);
                    
                    System.out.println("Consola en mejora:");
                    System.out.println("ID: " + consola.getId());
                    System.out.println("Prioridad: " + consola.getPrioridad());
                    
                }else{
                    
                    if(consola.getPrioridad() == 1){
                        
                        Simulador.prioridadUno.encolarNodoConsola(consola);
                        
                    }else if(consola.getPrioridad() == 2){
                        
                        Simulador.prioridadDos.encolarNodoConsola(consola);
                        
                    }else{
                        
                        Simulador.prioridadTres.encolarNodoConsola(consola);
                        
                    }
                    
                    System.out.println("Vuelvo a mi cola:");
                    System.out.println("ID: " + consola.getId());
                    System.out.println("Prioridad: " + consola.getPrioridad());
                    
                }
                
                System.out.println("");
                
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
            
        }else{
            System.out.println("No hay consola pa revisar!!!!!!!!");
        }
        
    }
    
}
