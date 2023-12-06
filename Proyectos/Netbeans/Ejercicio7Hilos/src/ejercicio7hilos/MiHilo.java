/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7hilos;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author 6002755
 */
public class MiHilo extends Thread{
    private String nombre;
    

    MiHilo(String nombre){
        setName(nombre);
        
    }
    
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("Soy " + getName());
                if (activeCount()<= 2){
                    System.out.println("soy el hilo " + getName() + " y soy el último superviviente");
                    
                }
                sleep(1000);
            }

            
        } catch (InterruptedException ex) {
            interrupt();
            System.out.println("Soy el hilo " + getName() + " y me muero.");
        }
        
    }
}
