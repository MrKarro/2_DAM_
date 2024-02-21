
package com.mycompany.ejercicio13_entregafinal;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Ranking {
    private TreeMap<String, Integer> ranking = new TreeMap<>();
    Map<String, Integer> test;
    public Ranking(){
        test = Collections.synchronizedMap(new TreeMap<String, Integer>());
    }
    
    public void setRanking(TreeMap<String, Integer> ranking) {
        this.ranking = ranking;
    }
    
    public synchronized void agregarPuntuacion(String jugador, int puntuacion) {
        ranking.put(jugador, puntuacion);
        test.put(jugador, puntuacion);
    }

    // Otros métodos para obtener o manipular el ranking si es necesario...

    // Método para obtener el ranking completo
    public synchronized Map<String, Integer> getRanking() {
        return this.test;
    }
    
}
