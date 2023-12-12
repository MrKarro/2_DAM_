package com.example.practica16.Modelo;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private int numBastidor;
    private String marca;
    private String modelo;
    private String combustible;
    private String color;
    private int kilometraje;

    public Vehiculo() {

    }

    public Vehiculo(int numBastidor, String marca, String modelo, String combustible, String color, int kilometraje) {
        this.numBastidor = numBastidor;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numBastidor=" + numBastidor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combustible='" + combustible + '\'' +
                ", color='" + color + '\'' +
                ", kilometraje=" + kilometraje +
                '}';
    }

    public int getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(int numBastidor) {
        this.numBastidor = numBastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
}
