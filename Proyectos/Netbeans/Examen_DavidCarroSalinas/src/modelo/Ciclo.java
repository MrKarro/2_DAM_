/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 6002755
 */
public class Ciclo implements Serializable{
    private String nombreCorto;
    private String nombreLargo;
    private String grado;
    private int horas;
    private ArrayList<Modulo> modulos;

    public Ciclo(String nombreCorto, String nombreLargo, String grado, int horas, ArrayList<Modulo> modulos) {
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.grado = grado;
        this.horas = horas;
        this.modulos = modulos;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return nombreCorto + "#" + nombreLargo + "#" + grado + "#" + horas + "\n";
    }
    
    
    
}
