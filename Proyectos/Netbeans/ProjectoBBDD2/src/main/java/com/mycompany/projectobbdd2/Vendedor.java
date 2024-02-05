/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectobbdd2;

/**
 *
 * @author 6002755
 */
public class Vendedor {
    
    private String nombre;
    private int numVenta;

    public Vendedor(String nombre, int numVenta) {
        this.nombre = nombre;
        this.numVenta = numVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    @Override
    public String toString() {
        return  "nombre=" + nombre + ", numVenta=" + numVenta + '}';
    }
    
    
    
    
    
    
    
}
