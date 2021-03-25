/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Giselle Ferreira
 */
public class SuperSwitch {
    
//    VARIABLES
    
//    ID de la consola, nivel de prioridad, número de consolas revisadas antes de la actual y apuntador al siguiente nodo de la cola
    private int id, prioridad, numConsolasRevisadas;
    private SuperSwitch sig;

//    CONSTRUCTOR
    
//    Constructor para crear una consola con su ID, su nivel de prioridad y el contador en 0 por defecto
    public SuperSwitch(int id, int prioridad) {
        this.id = id;
        this.prioridad = prioridad;
        this.numConsolasRevisadas = 0;
        sig = null;
    }
    
//    GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public SuperSwitch getSig() {
        return sig;
    }

    public void setSig(SuperSwitch sig) {
        this.sig = sig;
    }

    public int getNumConsolasRevisadas() {
        return numConsolasRevisadas;
    }

    public void setNumConsolasRevisadas(int numConsolasRevisadas) {
        this.numConsolasRevisadas = numConsolasRevisadas;
    }
    
}
