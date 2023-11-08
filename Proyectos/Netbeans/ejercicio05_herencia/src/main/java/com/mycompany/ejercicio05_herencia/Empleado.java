/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio05_herencia;

/**
 *
 * @author 6002755
 */
public class Empleado extends Persona{

    int codigo;
    String cargo;
    double sueldo;
    
    public Empleado(int codigo, String cargo, double sueldo, int id, String nombre, String dni, String domicilio, String telefono) {
         super(id, nombre, dni, domicilio, telefono);
        this.codigo = codigo;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado:\n" + super.toString() + " \nCódigo=" + codigo + " Cargo=" + cargo + " Sueldo=" + sueldo ;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
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
