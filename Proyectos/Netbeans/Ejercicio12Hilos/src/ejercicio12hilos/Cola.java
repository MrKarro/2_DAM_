/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Cola {
    
    private boolean disponible;
    private char letra;
    
    public synchronized char get(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        disponible = false;
        notify();
        return letra;
        
        
    }
    
    public synchronized void put(char let){
         while(disponible){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        letra = let;
        disponible = true;
        
        notify();
    }
}
