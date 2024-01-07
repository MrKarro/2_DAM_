/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio14hilos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Ejercicio14Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numJugadores = 3;
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Cola cola = new Cola();
        Arbitro arbitro = new Arbitro(jugadores, cola);
        
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador("Jugador " + (i + 1), arbitro, cola));
        }
        
        
        
        arbitro.start();

        for (Jugador jugador : jugadores) {
            jugador.start();
        }
        
        
    }
    
}
