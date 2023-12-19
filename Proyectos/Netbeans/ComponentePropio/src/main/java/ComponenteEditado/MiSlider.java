/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComponenteEditado;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;

/**
 *
 * @author 6002755
 */
public class MiSlider extends JSlider{
    
    private Font fuente;
    private Color color;
    
    
    public MiSlider(){
        setFont(fuente);
        setBackground(color);
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFont(Font font) {
        if (this.fuente != null){
            font = fuente;
        }
        super.setFont(font); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
    }

    @Override
    public void setBackground(Color fg) {
        if (this.color != null){
            fg = color;
        }
        super.setBackground(fg); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
