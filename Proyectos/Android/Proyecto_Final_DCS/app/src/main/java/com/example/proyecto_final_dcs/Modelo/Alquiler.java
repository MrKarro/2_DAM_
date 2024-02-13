package com.example.proyecto_final_dcs.Modelo;

import java.io.Serializable;
import java.util.Date;

public class Alquiler implements Serializable {
    private int identificador;
    private int id_pelicula;
    private int id_usuario;
    private String fecha_alquiler;
    private String fecha_devolucion;
    private boolean extendido;

    // Constructor
    public Alquiler(int identificador, int id_pelicula, int id_usuario, String fecha_alquiler, String fecha_devolucion, boolean extendido) {
        this.identificador = identificador;
        this.id_pelicula = id_pelicula;
        this.id_usuario = id_usuario;
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = fecha_devolucion;
        this.extendido = extendido;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "identificador=" + identificador +
                ", id_pelicula=" + id_pelicula +
                ", id_usuario=" + id_usuario +
                ", fecha_alquiler=" + fecha_alquiler +
                ", fecha_devolucion=" + fecha_devolucion +
                ", extendido=" + extendido +
                '}';
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_alquiler() {
        return fecha_alquiler;
    }

    public void setFecha_alquiler(String fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public boolean isExtendido() {
        return extendido;
    }

    public void setExtendido(boolean extendido) {
        this.extendido = extendido;
    }
}
