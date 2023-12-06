/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebahilos;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 6002755
 */
public class PruebaHilos {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        ArrayList<MiHiloEjer1> lista = new ArrayList<>();
        Random aleat = new Random();
        for (int i = 0 ; i < 10; i++){
            String nombre = "Hilo "+ (i+1);
            lista.add(new MiHiloEjer1(nombre, aleat.nextInt(10)));
        }
        for (MiHiloEjer1 m : lista)
            m.start();
        
        for (MiHiloEjer1 m : lista)
            try {
                m.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PruebaHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        System.out.println("Todos los hilos han muerto");
    }
    
}
