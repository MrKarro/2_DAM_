package com.example.practica17_davidcarrosalinas;

import java.io.Serializable;
import java.util.ArrayList;

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

    public static ArrayList<Usuario> nuevosUsuarios(int cant){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String[] provincias = {"Salamanca", "Ávila", "Zamora", "Valladolid", "León"};

        for (int i  = 0; i< cant ; i++){
            String nombre = "nombre" + i;
            String apell = "apellido1_" + i + " apellido2_" + i;
            int edad = 15 +i;
            String dni = "12345" + (char) 65+ i;
            String telefono = String.valueOf(1234567 +i);
            String provincia = provincias[i%5] ;

            lista.add(new Usuario(nombre, apell, edad, dni, telefono, provincia));
        }

        return lista;
    }

}
