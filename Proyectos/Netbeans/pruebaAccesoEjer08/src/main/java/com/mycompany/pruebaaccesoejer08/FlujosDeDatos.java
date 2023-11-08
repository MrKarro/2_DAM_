/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaaccesoejer08;

import java.io.DataOutputStream;
import java.io.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class FlujosDeDatos {
    String archivoDeDatos = "datos_de_facturacion.bin";
    double[] precios = {19.99, 9.99, 15.99, 3.99, 4.99};
    int[] numerosDeUnidades = {12, 8, 13, 29, 50};
    String[] descripciones = {"Acceso a datos", "Bases de datos", "Java",
    "Android Studio", "Programación móviles"};
    static Scanner teclado = new Scanner(System.in);
    
    
    public void escribirDisco(){
        DataOutputStream dos = null;
        try {
            String ruta = "./" + archivoDeDatos;
            dos = new DataOutputStream(new FileOutputStream(new File(ruta)));
            for (int i = 0; i< precios.length; i++){
                dos.writeDouble(precios[i]);
                dos.writeInt(numerosDeUnidades[i]);
                dos.writeUTF(descripciones[i]);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dos.close();
            } catch (IOException ex) {
                Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void leerDisco(){
        DataInputStream dis = null;
        ArrayList<Double> precios = new ArrayList<Double>();
        ArrayList<Integer> unidades = new ArrayList<Integer>();
        ArrayList<String> nombres = new ArrayList<String>();
        try {
           
            String ruta = "./" + archivoDeDatos;
            dis = new DataInputStream(new FileInputStream(new File(ruta)));
            
            precios.add(dis.readDouble());
            unidades.add(dis.readInt());
            nombres.add(dis.readUTF());
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(FlujosDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (precios.size() == unidades.size() && precios.size()== nombres.size()){
                for (int i = 0; i< precios.size(); i++){
                    this.precios = new double[precios.size()];
                    this.numerosDeUnidades = new int[unidades.size()];
                    this.descripciones = new String[nombres.size()];
                    
                    this.precios[i] = precios.get(i);
                    this.numerosDeUnidades[i] = unidades.get(i);
                    this.descripciones[i] = nombres.get(i);
                    
                }
                
            }

    }
    public void appendElemento(){
        System.out.println("Introduzca el nombre:");
        String nombre = teclado.next();
        System.out.println("Introduzca el numero de unidades:");
        int unidades = teclado.nextInt();
        System.out.println("Introduzca el precio:");
        double precio = teclado.nextDouble();
        
        String[] copNombres = Arrays.copyOf(descripciones, descripciones.length + 1);
        copNombres[copNombres.length-1] = nombre;
        int[] copUnidades = Arrays.copyOf(numerosDeUnidades, numerosDeUnidades.length +1);
        copUnidades[copUnidades.length-1] = unidades;
        double[] copPrecios = Arrays.copyOf(precios, precios.length+1);
        copPrecios[copPrecios.length-1] = precio;
        
        precios = copPrecios;
        numerosDeUnidades = copUnidades;
        descripciones = copNombres;
        
        
    }
    public void muestraElementos(){
        
        for (int i = 0; i < precios.length; i++){
            System.out.println("Nombre: " + descripciones[i] + "\nUnidades: " + numerosDeUnidades[i] + "\nPrecio: " + precios[i]);
        }
    }
    
    
    
}


