/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaaccesoejer02;

import java.io.File;

/**
 *
 * @author 6002755
 */
public class PruebaAccesoEjer02 {

    public static void main(String[] args) {
        String ruta;
        if (args.length == 0)
            ruta = ".";
        else 
            ruta = args[0];
   
       
        
        File f = new File(ruta);
        String[] lista = f.list();
        for (String nombre : lista){
            
            File actual = new File(f, nombre);
            if (actual.isDirectory())
                System.out.println(actual.getName() + " es directorio." );
            else if (actual.isFile())
                System.out.println(actual.getName() + " es fichero y tiene un tamaño de " + actual.length() + " bytes.");
            
            
        }
    }
}
