/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo_herencia;

/**
 *
 * @author 6002755
 */
public class Alumno extends Centro {
    
    String nombre;
    String curso;

    public Alumno(String nombre, String curso, String denom, String ciudad) {
        super(denom, ciudad);
        this.nombre = nombre;
        this.curso = curso;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return nombre + ", " + curso + ", " + denom + ", " + ciudad;
    }
    
    
    
    
}
