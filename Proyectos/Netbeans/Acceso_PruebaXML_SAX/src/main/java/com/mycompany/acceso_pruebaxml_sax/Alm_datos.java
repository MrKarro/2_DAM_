/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.acceso_pruebaxml_sax;


import java.util.ArrayList;
import org.xml.sax.InputSource;

/**
 *
 * @author carlos
 */
public class Alm_datos extends InputSource {

    private ArrayList<Empleados> datos;

    public Alm_datos(ArrayList<Empleados> datos) {
        this.datos = new ArrayList();
        this.datos = datos;
    }

    public Alm_datos(Alm_datos datos) {
        this.datos = new ArrayList();
        this.datos = datos.getDatos();
    }

    public Alm_datos() {
        this.datos = new ArrayList();
    }
    
    public Alm_datos(int n) {
        this.datos = new ArrayList();
        for (int i = 0; i < n; i++) {
            Empleados e = new Empleados();
            e.emp_aleatorio();
            this.datos.add(e);
        }
    } 

    public ArrayList<Empleados> getDatos() {
        return datos;
    }

    public void mostrar() {
        for (Empleados emp : datos) {
            System.out.println(emp);
        }
    }
}