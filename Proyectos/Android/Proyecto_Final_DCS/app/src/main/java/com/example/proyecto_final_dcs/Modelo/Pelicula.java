package com.example.proyecto_final_dcs.Modelo;

import java.sql.Time;

public class Pelicula {
    private int identificador;
    private String titulo;
    private String duracion;
    private int anho;
    private String portada;
    private int idDirector;
    private boolean disponible;

    public Pelicula(int identificador, String titulo, String duracion, int anho, String portada, int idDirector, boolean disponible) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.duracion = duracion;
        this.anho = anho;
        this.portada = portada;
        this.idDirector = idDirector;
        this.disponible = disponible;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
