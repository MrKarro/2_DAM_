/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmobiliaria_davidcarrosalinas;

import java.util.Date;

/**
 *
 * @author 6002755
 */
public class Operaciones extends Sucursal{
    
    private String tipo;
    private String descripcion;
    private String empleado;
    private String propietario;
    private String inquilino;
    private String fecha;
    private int precio;
    private float descuento;

    public Operaciones(String tipo, String descripcion, String empleado, String propietario, String inquilino, String fecha, int precio, float descuento, String nombre, String razonSocial, String nif, float comision) {
        super(nombre, razonSocial, nif, comision);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.empleado = empleado;
        this.propietario = propietario;
        this.inquilino = inquilino;
        this.fecha = fecha;
        this.precio = precio;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Razón social: " + getRazonSocial() + ", Tipo: " + tipo + ", Propietario: " + propietario + ", Inquilino: " + inquilino + ", Fecha: " + fecha + ", Precio: " + precio + ", Comisión: " + String.valueOf(getComision()) + ", Descuento: " + descuento + ", Precio final: " + getPrecioFinal();
    }
    
    public double getPrecioFinal(){
        double pf =(double) this.precio - (double) this.descuento + (double) getComision();
        return pf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getInquilino() {
        return inquilino;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
    
    
    
    
}
