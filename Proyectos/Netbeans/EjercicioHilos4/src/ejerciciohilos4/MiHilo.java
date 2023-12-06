/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciohilos4;

import static java.lang.Thread.activeCount;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class MiHilo extends Thread{
    private String nombre;
    private int veces; 

    MiHilo(String nombre, int veces){
        setName(nombre);
        this.veces = veces;
    }
    
    @Override
    public void run() {
        for (int i = 0 ; i < veces; i++){
            Random aleat = new Random();
            try {
                sleep(aleat.nextInt(5) * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (activeCount() <= 2){
                System.out.println("Soy el último superviviente.");
            }
            System.out.println("Hola soy " + getName() + " vez num: " + i);
        }
    }
}
