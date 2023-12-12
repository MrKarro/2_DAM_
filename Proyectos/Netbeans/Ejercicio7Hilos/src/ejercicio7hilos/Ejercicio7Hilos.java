/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7hilos;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio7Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<MiHilo> lista = new ArrayList<>();
        Random aleat = new Random();
        for (int i = 0 ; i < 10; i++){
            String nombre = "Hilo "+ (i+1);
            lista.add(new MiHilo(nombre));
        }
        
        for (MiHilo m : lista)
            m.start();
        
        try {
            while (Thread.activeCount() > 1 ){

                int posicion = aleat.nextInt(10);
                if (lista.get(posicion).isAlive()){
                    lista.get(posicion).interrupt();
                    sleep(1000);
                }
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio7Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println("\t\tTodos los hilos han muerto.");
    }
    
}
