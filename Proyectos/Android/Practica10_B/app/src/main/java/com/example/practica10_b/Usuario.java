package com.example.practica10_b;

import java.io.Serializable;

public class Usuario implements Serializable {

    String nombre;
    String apell;
    int edad;
    String dni;
    String telefono;
    String provincia;

    public Usuario(String nombre, String apell, int edad, String dni, String telefono, String provincia) {
        this.nombre = nombre;
        this.apell = apell;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apell='" + apell + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
