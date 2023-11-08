/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoejer09_streams;

import java.util.Scanner;

/**
 *
 * @author 6002755
 */
public class AccesoEjer09_Streams {
    
    static final int ESCRIBIR    = 1;
    static final int LEER        = 2;
    static final int ANADIR      = 3;
    static final int MOSTRAR     = 4;
    static final int SALIR       = 6;
    
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        
        int eleccion;
        FlujosDeObjetos flujo = new FlujosDeObjetos();
        do{
            eleccion = muestraMenu();
            
            switch (eleccion){
                case ESCRIBIR:
                    flujo.escribirDisco();
                    break;
                case LEER:
                    flujo.leerDisco();
                    break;
                    
                case ANADIR:
                    flujo.appendElemento();
                    break;
                case MOSTRAR:
                    flujo.muestraElementos();
                    break;
                case SALIR:
                    
                    break;
            }
            
            
        } while (eleccion != SALIR);
        
    }
    
    
    private static int muestraMenu(){
        System.out.println("\n==========================\n");
        System.out.println(ESCRIBIR + ". Escribe en disco las estructuras.");
        System.out.println(LEER + ". Lee las estructuras del disco.");
        System.out.println(ANADIR + ". Añade un elemento.");
        System.out.println(MOSTRAR + ". Muestra los elementos.");
        System.out.println(SALIR + ". Salir");
        System.out.println("\n==========================\n");
        
        System.out.print("Introduzca su elección:\t");
        int eleccion = teclado.nextInt();
        return eleccion;
            
    }
}
