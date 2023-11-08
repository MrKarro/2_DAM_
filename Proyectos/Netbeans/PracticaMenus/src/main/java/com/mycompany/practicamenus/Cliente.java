/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicamenus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 6002755
 */
public class Cliente {
    
    private String nombre;
    private String apellidos;
    private Date fecha;
    private String provincia;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public Cliente(String nombre, String apellidos, Date fecha, String provincia){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.provincia = provincia;
        
    }
     public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
    public String[] aTabla(){
        String [] nuevo = new String[4];
        nuevo[0] = this.nombre;
        nuevo[1] = this.apellidos;
        nuevo[2] = sdf.format(fecha);
        nuevo[3] = this.provincia;
        
        return nuevo;
    }
    
    
    
}
