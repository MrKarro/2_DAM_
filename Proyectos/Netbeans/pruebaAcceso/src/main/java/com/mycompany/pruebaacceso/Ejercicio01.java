/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaacceso;
import java.io.File;

/**
 *
 * @author 6002755
 */

public class Ejercicio01 {

    public static void main(String[] args) {
        
        String ruta;
        if (args.length == 0)
            ruta = ".";
        else 
            ruta = args[0];
   
       
        
        File f = new File(ruta);
        String[] lista = f.list();
        for (String nombre : lista){
            System.out.println(nombre);
            
        }
             
    }
}
