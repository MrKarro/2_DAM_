/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaaccesoejer03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 6002755
 */
public class PruebaAccesoEjer03 {
    static Scanner teclado = new Scanner(System.in);
    
    static final int MOSTRAR    = 1;
    static final int CREA_DIR   = 2;
    static final int CREA_FICH  = 3;
    static final int CAMBIAR    = 4;
    static final int BORRAR     = 5;
    static final int SALIR      = 6;

    public static void main(String[] args) {
        int eleccion;
        do{
            eleccion = muestraMenu();
            
            switch (eleccion){
                case MOSTRAR:
                    muestraDirectorio();
                    break;
                case CREA_DIR:
                    creaDirectorio();
                    break;
                    
                case CREA_FICH:
                    creaFichero();
                    break;
                case CAMBIAR:
                    cambiaNombre();
                    break;
                case BORRAR:
                    borraFichero();
                    break;
                case SALIR:
                    
                    break;
            }
            
            
        } while (eleccion != 6);
        
    }
    
    private static int muestraMenu(){
        System.out.println("\n==========================\n");
        System.out.println(MOSTRAR + ". Mostrar contenido de directorio.");
        System.out.println(CREA_DIR + ". Crear un directorio.");
        System.out.println(CREA_FICH + ". Crear un fichero.");
        System.out.println(CAMBIAR + ". Cambiar el nombre a un fichero.");
        System.out.println(BORRAR + ". Borrar un fichero.");
        System.out.println(SALIR + ". Salir");
        System.out.println("\n==========================\n");
        
        System.out.print("Introduzca su elección:\t");
        int eleccion = teclado.nextInt();
        return eleccion;
            
    }
    
    private static String pideRuta(){
        System.out.println("\n==========================\n");
        System.out.println("Introduce la ruta al archivo:");
        String ruta = teclado.next();
        System.out.println("\n==========================\n");
        return ruta;
    }

    private static void muestraDirectorio() {
        String ruta = pideRuta();
        File f = new File(ruta);
        if (f.exists()){
            if (f.isDirectory()){
                String[] lista = f.list();
                for (String nombre : lista){
            
                    File actual = new File(f, nombre);
                    if (actual.isDirectory())
                        System.out.println(actual.getName() + " es directorio." );
                    else if (actual.isFile())
                        System.out.println(actual.getName() + " es fichero y tiene un tamaño de " + actual.length() + " bytes.");

                    else if (f.isFile())
                        System.out.println(f.getName() + " es fichero y tiene un tamaño de " + f.length() + " bytes.");
                }
            }
        } else
            System.out.println("Usted no ha introducido una ruta correcta.");
        
    }

    private static void creaDirectorio() {
        String ruta = pideRuta();
        File f = new File(ruta);
        if (f.exists())
            System.out.println("Esta ruta ya está en uso.");
        else
            f.mkdir();
    }

    private static void creaFichero() {
        String ruta = pideRuta();
        File f = new File(ruta);
        if (f.exists())
            System.out.println("Esta ruta ya está en uso.");
        else{
            try{
            f.createNewFile();
            } catch (IOException e){
                System.out.println("Error de entrada/salida.");
                
            }
        }
    }

    private static void cambiaNombre() {
        String ruta = pideRuta();
        File f = new File(ruta);
        if (!f.exists())
            System.out.println("Este fichero no existe.");
        else{
            System.out.println("Introduce el nuevo nombre:\t");
            String nuevo = f.getParentFile().getAbsolutePath() + teclado.next();
            
            File nue = new File(nuevo);
            f.renameTo(nue);
        }
        
    }

    private static void borraFichero() {
        String ruta = pideRuta();
        File f = new File(ruta);
        if (!f.exists())
            System.out.println("Esta ruta no está en uso.");
        else
            f.delete();
        
    }
}
