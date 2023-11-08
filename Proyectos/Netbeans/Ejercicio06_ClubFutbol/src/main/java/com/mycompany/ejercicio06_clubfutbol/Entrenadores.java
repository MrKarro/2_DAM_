/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio06_clubfutbol;

/**
 *
 * @author 6002755
 */
public class Entrenadores extends Personal{
    private double sueldo;
    private float plusPartidoGanado;

    public Entrenadores(double sueldo, float plusPartidoGanado, String nombre, String dni, String direccion, long telefono, int partidosGanados) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.sueldo = sueldo;
        this.plusPartidoGanado = plusPartidoGanado;
    }
    
    public double getSueldoFinal(){
        return sueldo + ((double) plusPartidoGanado * this.getPartidosGanados()); 
        
    }
    
    public String toString() {
        return "Entrenador:\t\tnombre = " + this.getNombre() + " DNI = " + this.getDni() + ", sueldo = " + getSueldoFinal() ;
    }
    
    

    
    
    
}
