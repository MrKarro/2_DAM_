/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio06_clubfutbol;


import java.util.Date;

/**
 *
 * @author 6002755
 */
public class Jugadores extends Personal{
    private String posicion;
    private double sueldo;
    private String fechaNacimiento;
    private float plusPartidoGanado;
    private int numGoles;
    private float plusGol;

    public Jugadores(String posicion, double sueldo, String fechaNacimiento, float plusPartidoGanado, int numGoles, float plusGol, String nombre, String dni, String direccion, long telefono, int partidosGanados) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.plusPartidoGanado = plusPartidoGanado;
        this.numGoles = numGoles;
        this.plusGol = plusGol;
    }

    @Override
    public String toString() {
        return "Jugador:\t\tnombre = " + this.getNombre() + " posicion = " + posicion + ", sueldo = " + getSueldoFinal() ;
    }
    
    public double getSueldoFinal(){
        return sueldo + (plusGol*numGoles) + (plusPartidoGanado * this.getPartidosGanados()); 
        
    }
    
    
    
}
