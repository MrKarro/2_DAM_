package com.example.practica14_tienda.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String user;
    private String pass;
    private String nombre;

    public Usuario(String user, String pass, String nombre) {
        this.user = user;
        this.pass = pass;
        this.nombre = nombre;
    }
    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.nombre = "";
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
