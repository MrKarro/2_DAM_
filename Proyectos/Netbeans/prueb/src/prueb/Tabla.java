/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author 6002755
 */
public class Tabla {
    Map<String, Integer> tabla = new HashMap<String, Integer>();
    
    
    
    
    
    public synchronized void addPuntos(String nombre, int puntuacion ){
        tabla.put(nombre, puntuacion);
    }
    public void muestraTabla(){
        System.out.println(tabla.size());
        List<Entry<String, Integer>> list = new ArrayList<>(tabla.entrySet());
        list.sort(Collections.reverseOrder(Entry.comparingByValue()));
        for (Entry<String, Integer> entry : list) {
            System.out.println("Nomabre: " + entry.getKey() + " || Puntos: " + entry.getValue());
        }
    }
}
