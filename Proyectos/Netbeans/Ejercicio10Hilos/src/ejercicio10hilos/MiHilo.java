/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class MiHilo extends Thread {
    private Cajero c;
    private String nombre;
    
    static long duracion;
    
    MiHilo(String nombre, ArrayList<Cliente> cola){
        this.nombre = nombre;
        this.c = new Cajero(nombre, cola);
    }
   

    @Override
    public void run() {
        c.setInicio(System.nanoTime());
        Random aleat = new Random();
        System.out.println("\t\tSoy " + c.getNombre() + "\t y comienzo a trabajar.");
        int cont = 0;
        while (!c.getCola().isEmpty()){
            Cliente cli = c.llamaCliente(c.getCola());
            for (int i = 0; i < cli.getArticulos(); i++){
                try {
                    sleep(aleat.nextInt(200) + 100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cont++;
        }
        
       
        System.out.println("\t\tSoy " + c.getNombre() + "\t he atendido ya a " + cont + " clientes y he trabajado " + c.tiempo() + " segundos.");
        
    }
    
    
    
    
}
