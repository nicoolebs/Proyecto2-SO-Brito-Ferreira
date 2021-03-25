/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Cola;
import Modelo.Robot;
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
        
        
        
    }
    
    
    
}
