/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio07_herencia_jtable;

/**
 *
 * @author 6002755
 */
public class Proyecto {
    private String codigo;
    private String descr;
    private int numHoras;

    public Proyecto(String codigo, String descr, int numHoras) {
        this.codigo = codigo;
        this.descr = descr;
        this.numHoras = numHoras;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }
    
    
}
