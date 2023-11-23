/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import org.xml.sax.InputSource;

/**
 *
 * @author 6002755
 */
public class Informatica extends InputSource implements Serializable{
    private ArrayList<Ciclo> ciclos;

    public Informatica() {
    }

    public Informatica(ArrayList<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public ArrayList<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(ArrayList<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    @Override
    public String toString() {
        return "Informatica{" + "ciclos=" + ciclos + '}';
    }

    
    
    
    
}
