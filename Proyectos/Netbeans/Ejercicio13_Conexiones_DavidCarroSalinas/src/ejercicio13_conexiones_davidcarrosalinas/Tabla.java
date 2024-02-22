/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones_davidcarrosalinas;

import java.util.Map;

/**
 *
 * @author 6002755
 */
public class Tabla {
    Map<String, Integer> tabla;
    
    
    
    public synchronized void addPuntos(String nombre, int puntuacion ){
        tabla.put(nombre, puntuacion);
    }
    public void muestraTabla(){
        for (String clave : tabla.keySet()) {
            Integer valor = tabla.get(clave);
            System.out.println("Nombre: " + clave + ", Puntuación: " + valor);
        }
    }
}
