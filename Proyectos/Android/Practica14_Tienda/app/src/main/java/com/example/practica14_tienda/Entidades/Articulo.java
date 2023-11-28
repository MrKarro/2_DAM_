package com.example.practica14_tienda.Entidades;

public class Articulo {
    private int codigo;
    private String nombre;
    private String descr;
    private String color;
    private float precio;

    public Articulo(int codigo, String nombre, String descr, String color, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descr = descr;
        this.color = color;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", descr='" + descr + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
