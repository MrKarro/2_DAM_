/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5hilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class MiHilo extends Thread {
    private Cajero c;
    private String nombre;
    static long duracion;
    
    MiHilo(String nombre){
        this.nombre = nombre;
        this.c = new Cajero(nombre);
    }
   

    @Override
    public void run() {
        c.setInicio(System.nanoTime());
        Random aleat = new Random();
        int cont = 0;
        for (Cliente cli : c.getClientes()){

            System.out.println("Hola, Soy " + c.getNombre() + " he atendido ya a " + cont + " clientes y llevo trabajando " + c.tiempo() + " segundos.");

            for (int k = 0; k< cli.getArticulos(); k++){
                try {
                    sleep(aleat.nextInt(200) + 100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cont++;
            System.out.println("Adios, Soy " + c.getNombre() + " he atendido ya a " + cont + " clientes y llevo trabajando " + c.tiempo() + " segundos.");
        }
        
       
        System.out.println("\t\tSoy " + c.getNombre() + " he atendido ya a " + c.getClientes().size() + " clientes y he trabajado " + c.tiempo() + " segundos.");
        
    }
    
    
    
    
}
