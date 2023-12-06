/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5hilos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio5Hilos {

    /**
     * @param args the command line arguments
     */
    private static long tiempoInicio = 0;
    private static long tiempoFin = 0;
    
    public static void main(String[] args) {
        String[] nombres = {"David", "Alberto", "Mia", "Victor", "Lidia", "Adolfo", "Juans", "Adrian", "otroNombre", "otroNombre2"};
        
        ArrayList<MiHilo> hilos = new ArrayList<>();
        for (String nombre : nombres){
            MiHilo h = new MiHilo(nombre);
            hilos.add(h);
        }
        tiempoInicio = System.nanoTime();
        for (MiHilo h : hilos){
            h.start();
        }
        for (MiHilo h : hilos){
            try {
                h.join();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio5Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tiempoFin = System.nanoTime();
        System.out.println("Todos los cajeros han tardado " + ((tiempoFin-tiempoInicio)/(long) 1e9) + " en trabajar");
        
        
        
        
    }
    
}
