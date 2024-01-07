/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14hilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Jugador extends Thread{
    private String nombre;
    private boolean jugado;
    private Arbitro arbitro;
    private Cola cola;

    public Jugador(String nombre, Arbitro arbitro, Cola cola) {
        this.nombre = nombre;
        this.arbitro = arbitro;
        this.jugado = false;
        this.cola = cola;
    }

    @Override
    public void run() {
        while (!arbitro.isJuegoTerminado()){
           
            try {
                int num = new Random().nextInt(50) + 1;
                System.out.println("El " + nombre + " ha jugado el numero " + num);
                cola.put(num);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean haJugado) {
        this.jugado = haJugado;
    }
    
}