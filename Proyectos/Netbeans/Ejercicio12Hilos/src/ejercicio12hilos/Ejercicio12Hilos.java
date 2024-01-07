/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio12hilos;

import java.io.File;

/**
 *
 * @author 6002755
 */
public class Ejercicio12Hilos {

    private static String RUTA = "./prueba.txt";
    
    public static void main(String[] args) {
        File archivo = new File(RUTA);
        Cola cola = new Cola();
        ProductorEjer12 prod = new ProductorEjer12(cola, archivo);
        Consumidor cons = new Consumidor(cola, ' ');
        
        
        prod.start();
        cons.start();
        
    }
    
}
