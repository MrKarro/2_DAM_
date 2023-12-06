/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5hilos;

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
    private ArrayList<Cliente> clientes;
    
    Cajero(String nombre){
        
        this.clientes = creaClientes();
        this.nombre = nombre;
    }
    
    private ArrayList<Cliente> creaClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        Random aleat = new Random();
        for ( int i = 0; i< (aleat.nextInt(5) + 5); i++){
            Cliente c = new Cliente(aleat.nextInt(20));
            lista.add(c);
        }
        return lista;
    }
    
    

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
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
