/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio05_herencia;

/**
 *
 * @author 6002755
 */
public class Jubilado extends Persona {
    double sueldo;
    String ocupacion;
    int edad;

    public Jubilado(double sueldo, String ocupacion, int edad, int id, String nombre, String dni, String domicilio, String telefono) {
        super(id, nombre, dni, domicilio, telefono);
        this.sueldo = sueldo;
        this.ocupacion = ocupacion;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jubilado:\n" + super.toString() + " \nSueldo=" + sueldo + " Ocupacion=" + ocupacion + " Edad=" + edad ;
    }
    
    

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
