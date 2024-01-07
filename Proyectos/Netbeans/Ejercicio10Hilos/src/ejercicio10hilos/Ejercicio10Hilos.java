/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10hilos;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio10Hilos {

    /**
     * @param args the command line arguments
     */
    private static long tiempoInicio = 0;
    private static long tiempoFin = 0;
    private static ArrayList<Cliente> cola = new ArrayList<>();
    
    public static void main(String[] args) {
        creaCola();
        
        String[] nombres = {"David", "Alberto", "Mia", "Victor", "Lidia", "otroNombre", "otroNombre2", "otroNombre3", "otroNombre4", "otroNombre5"};
        
        ArrayList<MiHilo> hilos = new ArrayList<>();
        for (String nombre : nombres){
            MiHilo h = new MiHilo(nombre, cola);
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
                Logger.getLogger(Ejercicio10Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tiempoFin = System.nanoTime();
        System.out.println("Todos los cajeros han tardado " + ((tiempoFin-tiempoInicio)/(long) 1e9) + " en trabajar");
        
    }
    
    
    private static void creaCola(){
        Random aleat = new Random();
        for ( int i = 0; i< 100; i++){
            Cliente c = new Cliente(aleat.nextInt(20));
            cola.add(c);
        }
    }
    
}
