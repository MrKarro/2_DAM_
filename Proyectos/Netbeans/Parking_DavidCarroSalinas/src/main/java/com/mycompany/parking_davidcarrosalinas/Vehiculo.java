/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parking_davidcarrosalinas;

import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class Vehiculo {
    
    String tipo;
    float precioHora;
    String[] propietario;
    LocalDate entrada;
    LocalDate salida;

    public Vehiculo(String tipo, float precioHora, String[] propietario, LocalDate entrada, LocalDate salida) {
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.propietario = propietario;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Vehiculo(String tipo, float precioHora, LocalDate entrada, LocalDate salida) {
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.entrada = entrada;
        this.salida = salida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public String[] getPropietario() {
        return propietario;
    }

    public void setPropietario(String[] propietario) {
        this.propietario = propietario;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    
    
}

