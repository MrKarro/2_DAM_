/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parking_davidcarrosalinas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author usuario
 */
public class Vehiculo implements Serializable{
    
    
    private String matricula;
    private String tipo;
    private float precioHora;
    private String[] propietario;
    private LocalDateTime entrada;
    private LocalDateTime salida;

    public Vehiculo(String matricula, String tipo, float precioHora, LocalDateTime entrada, LocalDateTime salida, String[] propietario) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.propietario = propietario;
        this.entrada = entrada;
        this.salida = null;
    }

    public Vehiculo(String matricula, String tipo, float precioHora, LocalDateTime entrada, LocalDateTime salida) {
        this.matricula = matricula;
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.entrada = entrada;
        this.salida = null;
        this.propietario = null;
    }

    @Override
    public String toString() {
        String str = "";
        if (this.propietario != null){
            str = "Matrícula: " + this.matricula + " Tipo: " + this.tipo + " Propietario: " + this.propietario[0];
        } else {
            str = "Matrícula: " + this.matricula + " Tipo: " + this.tipo;
        }
        
        return str;
    }
    
    public double precioEstancia(){
        
        long minutos = ChronoUnit.MINUTES.between(this.entrada, this.salida);
        return minutos * this.precioHora;
    }
    
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    
    
}

