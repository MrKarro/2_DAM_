/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciohilos4;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class EjercicioHilos4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<MiHilo> lista = new ArrayList<>();
        Random aleat = new Random();
        for (int i = 0 ; i < 5; i++){
            String nombre = "Hilo "+ (i+1);
            lista.add(new MiHilo(nombre, aleat.nextInt(10)));
        }
        
        for (MiHilo m : lista)
            m.start();
        
        for (MiHilo m : lista)
            try {
                m.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EjercicioHilos4.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         System.out.println("Todos los hilos han muerto");
        
    }
    
}
