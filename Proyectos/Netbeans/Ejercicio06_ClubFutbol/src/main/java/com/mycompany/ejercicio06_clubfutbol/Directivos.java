/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio06_clubfutbol;

/**
 *
 * @author 6002755
 */
public class Directivos extends Personal{
    private String cargo;
    private double sueldo;
    private boolean activo;

    public Directivos(String cargo, double sueldo, boolean activo, String nombre, String dni, String direccion, long telefono, int partidosGanados) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = activo;
    }

    @Override
    public String toString() {
        String act;
        if (activo){
            act = "si";
        } else {
            act = "no";
        }
        
        return "Directivo:\t\tnombre = " + this.getNombre() + " cargo = " + cargo + ", sueldo = " + getSueldoFinal() + ", activo = " + act;
    }

    private double getSueldoFinal() {
        return sueldo;
    }
    
    
    
}
