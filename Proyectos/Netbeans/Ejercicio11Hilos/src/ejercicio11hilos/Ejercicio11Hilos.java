/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio11hilos;

/**
 *
 * @author 6002755
 */
public class Ejercicio11Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object testigo = new Object();
        
        MiHilo ping = new MiHilo("Ping\t", 1, testigo);
        MiHilo pong = new MiHilo("Pong\n", 2, testigo);
        
        ping.start();
        pong.start();
        
    }
    
}
