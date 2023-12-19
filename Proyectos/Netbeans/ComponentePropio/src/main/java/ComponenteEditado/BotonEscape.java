/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComponenteEditado;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author 6002755
 */
public class BotonEscape extends JButton implements MouseListener{
    
    private Color[] colores = {Color.red, Color.yellow, Color.black, Color.blue};
    
    
    public BotonEscape (){
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Random aleat = new Random();
        int ancho = e.getComponent().getParent().getWidth() - e.getComponent().getWidth();
        int alto = e.getComponent().getParent().getHeight() - e.getComponent().getHeight();
        e.getComponent().setLocation(aleat.nextInt(ancho), aleat.nextInt(alto));
        setBackground(colores[aleat.nextInt(colores.length)]);
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    
    
    
    
}
