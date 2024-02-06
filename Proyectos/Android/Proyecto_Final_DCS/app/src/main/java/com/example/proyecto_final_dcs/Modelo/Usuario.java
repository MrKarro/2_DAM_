package com.example.proyecto_final_dcs.Modelo;

public class Usuario {
    private int identificador;
    private String dni;
    private String nombre;
    private String login;
    private String password;
    private boolean trabajador;
    private boolean bloqueado;

    // Constructor
    public Usuario(int identificador, String dni, String nombre, String login, String password, boolean trabajador, boolean bloqueado) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.trabajador = trabajador;
        this.bloqueado = bloqueado;
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTrabajador() {
        return trabajador;
    }

    public void setTrabajador(boolean trabajador) {
        this.trabajador = trabajador;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
