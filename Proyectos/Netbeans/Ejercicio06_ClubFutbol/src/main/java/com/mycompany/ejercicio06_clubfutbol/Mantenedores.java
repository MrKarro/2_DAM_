/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio06_clubfutbol;

/**
 *
 * @author 6002755
 */
public class Mantenedores extends Personal{
    private double sueldo;
    private boolean fijo;
    private float plus = 200f;

    public Mantenedores(double sueldo, boolean fijo, String nombre, String dni, String direccion, long telefono, int partidosGanados) {
        super(nombre, dni, direccion, telefono, partidosGanados);
        this.sueldo = sueldo;
        this.fijo = fijo;
    }

    @Override
    public String toString() {
        String act;
        if (fijo){
            act = "si";
        } else {
            act = "no";
        }
        return "Mantenedores\tnombre=" + this.getNombre() + " DNI: " + this.getDni() + ", sueldo = " + getSueldoFinal() + ", fijo = " + act;
    }
    
    public double getSueldoFinal(){
        
        if (fijo){
            return sueldo + plus;
        } else
            return sueldo;
    } 
}
