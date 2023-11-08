/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio07_herencia_jtable;

import java.util.Random;

/**
 *
 * @author 6002755
 */
public class Empleado extends Proyecto {
    private String nombre;
    private float precioHora;
    
    private static final String[] nombres = {"Juan", "Ricardo", "Rosa", "Ana", "Sandra", "Laura", "Mario", "José", "Gael", "Clara", "Carlos", "Paz"};
    private static final float[] precioHoras = {9.5f, 12.4f, 16f, 18.7f, 20f, 22f, 30f};
    private static final String[] descripciones = {"Python", "Java", "C", "Cobol", "Fortran"};
    private static final String[] codigos = {"Pyt123", "qwe123", "zxc123", "098ert", "poi567"};

    public Empleado(String nombre, float precioHora, String codigo, String descr, int numHoras) {
        super(codigo, descr, numHoras);
        this.nombre = nombre;
        this.precioHora = precioHora;
    }
    
    public Empleado(String codigo,String descr,int numHoras) {
        super(codigo, descr, numHoras);
        this.nombre ="";
        this.precioHora = 0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    @Override
    public String toString() {
        return "Empleado: " + " nombre = " + nombre + " Código proyecto : " + this.getCodigo() + " Número de horas : " + this.getNumHoras() +   ", precioHora = " + precioHora + '}';
    }
    
    public float getSueldoFinal(){
        return this.getNumHoras() * precioHora;
    }
    public String[] aTabla(){
        String [] nuevo = new String[6];
        nuevo[0] = this.nombre;
        nuevo[1] = this.getCodigo();
        nuevo[2] = this.getDescr();
        nuevo[3] = Integer.toString(this.getNumHoras());
        nuevo[4] = Float.toString(precioHora);
        nuevo[5] = Double.toString(getSueldoFinal());
        
        return nuevo;
    }
    
    public void emp_aleatorio() {

        Random r = new Random();
        setNombre(nombres[r.nextInt(nombres.length)]);
        setCodigo(codigos[r.nextInt(codigos.length)]);
        setDescr(descripciones[r.nextInt(descripciones.length)]);
        setNumHoras(r.nextInt(50));
        setPrecioHora(precioHoras[r.nextInt(precioHoras.length)]);
        
    }
    
}
