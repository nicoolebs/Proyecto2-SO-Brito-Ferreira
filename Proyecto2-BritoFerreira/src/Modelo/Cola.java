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

public class Cola {
    
//    VARIABLES
    
//    Se tiene la consola de inicio y fin de la cola y el tamaño de la cola
    SuperSwitch inicio;
    SuperSwitch fin;
    int tamaño;
    
    //CONSTRUCTOR
    
//    Por defecto la cola empieza vacía
    public Cola(){
        tamaño = 0;
        inicio = null;
        fin = null;
    }
    
    //Metodo para saber si esta vacia la cola
    public boolean estaVacia(){
        return inicio == null;
    }
    
    //Metodo para insertar un elemento en la cola
    public void encolarConsola(int id, int prioridad){
        SuperSwitch nuevo = new SuperSwitch(id, prioridad);
        
        if(estaVacia()){
            inicio = nuevo;
        }else{
            fin.setSig(nuevo);
        }
        
        fin = nuevo;
        tamaño++;
    }
    
    //Metodo para insertar un elemento en la cola
    public void encolarNodoConsola(SuperSwitch consola){
        
        if(estaVacia()){
            inicio = consola;
        }else{
            fin.setSig(consola);
        }
        
        fin = consola;
        tamaño++;
    }
    
    //Metodo para sacar un elemento de la cola
    public SuperSwitch desencolar(){
        if(!estaVacia()){
            SuperSwitch temp = inicio;
            inicio = inicio.getSig();
            tamaño--;
            
            if(estaVacia()){
                fin = null;
            }
            
            return temp;
        }else{
            System.out.println("La cola está vacia");
            return inicio;
        }
        
    }
    
    public void imprimirCola(){
        SuperSwitch consola = this.inicio;
        System.out.println("Cola: ");
        
        while (consola != null) {            
            
            System.out.println("ID: " + consola.getId());
            System.out.println("Prioridad: " + consola.getPrioridad());
            System.out.println("Consolas revisadas hasta esta consola: " + consola.getNumConsolasRevisadas() + "\n");
            
        }
        
    }

    public SuperSwitch getInicio() {
        return inicio;
    }

    public void setInicio(SuperSwitch inicio) {
        this.inicio = inicio;
    }

    public SuperSwitch getFin() {
        return fin;
    }

    public void setFin(SuperSwitch fin) {
        this.fin = fin;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
}
