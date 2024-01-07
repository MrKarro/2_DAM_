/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10hilos;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 6002755
 */
public class Cajero {
    
    private long inicio;
    private long fin;
    private String nombre;
    private int atendidos;
    private ArrayList<Cliente> cola;
    
    Cajero(String nombre, ArrayList<Cliente> cola){
        
        this.cola = cola;
        this.nombre = nombre;
    }
    
    Cliente llamaCliente(ArrayList<Cliente> cola){
        Cliente c = null;
        Random aleat = new Random();
        int num = aleat.nextInt(cola.size());
        synchronized (cola){
            c = cola.get(num);
            cola.remove(num);
        }
        return c;
    }
    
    

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public ArrayList<Cliente> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Cliente> cola) {
        this.cola = cola;
    }

    
    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    public int getAtendidos() {
        return atendidos;
    }

    public void setAtendidos(int atendidos) {
        this.atendidos = atendidos;
    }

    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public long tiempo(){
        long tiempo = (System.nanoTime() - this.inicio) /(long)1e9 ;
        return tiempo;
        
    }
    
    
}
