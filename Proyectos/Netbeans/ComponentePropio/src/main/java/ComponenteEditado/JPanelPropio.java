/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComponenteEditado;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author 6002755
 */
public class JPanelPropio extends JPanel{
    
    private File rutaArchivo;
    private JPanel panel;
    private JButton boton;

    public JPanelPropio() {
        
        
    }
    

    public File getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(File rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (rutaArchivo != null && rutaArchivo.exists()){
            ImageIcon img = new ImageIcon(rutaArchivo.getAbsolutePath());
            g.drawImage(img.getImage(), 0, 0, null);
        }
        
    }
    
    
    
    
    
}
