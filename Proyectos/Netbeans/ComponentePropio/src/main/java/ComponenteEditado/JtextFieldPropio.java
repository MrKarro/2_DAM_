/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComponenteEditado;

import java.awt.Color;
import java.awt.event.FocusEvent;

/**
 *
 * @author 6002755
 */
public class JtextFieldPropio extends JTextField {
    
    Color entrada;
    Color salida;

    public JtextFieldPropio() {
        
    }
    
    public JtextFieldPropio(Color entrada, Color salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    public Color getEntrada() {
        return entrada;
    }

    public void setEntrada(Color entrada) {
        this.entrada = entrada;
    }

    public Color getSalida() {
        return salida;
    }

    public void setSalida(Color salida) {
        this.salida = salida;
    }
    
    
    
    
    
}
