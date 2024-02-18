package com.example.proyecto_final_dcs.Modelo;

import java.util.Date;

public class Director {
    private int identificador;
    private String nombre;
    private Date fecha_nacimiento;

    // Constructor
    public Director(int identificador, String nombre, Date fecha_nacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
