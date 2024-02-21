/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14hilos;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Arbitro extends Thread{
    
    private Cola cola;
    private int numeroAAdivinar;
    private int turnoActual;
    private boolean juegoTerminado;
    private ArrayList<Jugador> jugadores;
    private CyclicBarrier barrera;
    
    
    public Arbitro(ArrayList<Jugador> jugadores, Cola cola) {
        this.cola = cola;
        this.numeroAAdivinar = new Random().nextInt(50) + 1;
        this.turnoActual = 0;
        this.juegoTerminado = false;
        this.jugadores = jugadores;
        barrera = new CyclicBarrier(jugadores.size() + 1);
       
    }
    
    @Override
    public void run() {
        for (int i = 1; !juegoTerminado; i++){
            System.out.println("TURNO " + i);
            
            compruebaJugada();
            
            try {
                barrera.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }  
        
        
    }
    
    public synchronized void compruebaJugada(){
        for (int j = 0; j < jugadores.size(); j++){
                int numeroRecibido = cola.get();  // Toma el número de la cola
                System.out.println("Árbitro verificando número: " + numeroRecibido);
                if (comprobarNumero(numeroRecibido)) {
                    System.out.println("¡Un jugador ha acertado, el juego acaba!");
                    setJuegoTerminado(true);
                    return;
                }
            }
    } 

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }
    private boolean comprobarNumero(int recibido)
    {
        if (recibido == numeroAAdivinar){
            return true;
        } else {
            return false;
        }
    }    
    
    
}
