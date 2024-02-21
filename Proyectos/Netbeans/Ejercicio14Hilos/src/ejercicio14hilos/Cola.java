/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14hilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cola {
    private boolean disponible ;
    private int num = -1;
    
    
    
    public synchronized int get(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        notifyAll();
        return num;
        
        
    }
    
    public synchronized void put(int numero){
         while(disponible){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        num = numero;
        disponible = true;
        
        notifyAll();
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
