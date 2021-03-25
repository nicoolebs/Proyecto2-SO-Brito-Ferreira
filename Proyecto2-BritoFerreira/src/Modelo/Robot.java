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
    
    
    public void revisarConsola(SuperSwitch consola){
        
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
                    
                }else if(probabilidad <= 80){
                    
                    Simulador.bloqueados.encolarNodoConsola(consola);
                    
                    System.out.println("Consola bloqueada:");
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
