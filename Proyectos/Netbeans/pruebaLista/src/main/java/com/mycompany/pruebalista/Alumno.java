/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebalista;

/**
 *
 * @author 6002755
 */
public class Alumno {

    
    private String nombre;
    private String apellidos;
    private String curso;

    
    
    Alumno(String nombre, String apellidos, String curso ){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellidos + " cursa " + curso;
    }
    
    
    
    
}
