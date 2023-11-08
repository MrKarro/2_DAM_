/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio06_clubfutbol;

/**
 *
 * @author 6002755
 */
public class Personal {
    private String nombre;
    private String dni;
    private String direccion;
    private long telefono;
    private int partidosGanados;

    public Personal(String nombre, String dni, String direccion, long telefono, int partidosGanados) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.partidosGanados = partidosGanados;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", partidosGanados=" + partidosGanados + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }
    
    
    
    
    
}
