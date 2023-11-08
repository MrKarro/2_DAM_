/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaaccesoejercicioimagen;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class PruebaAccesoEjercicioImagen {

    public static void main(String[] args) {
        BufferedInputStream bis;
        BufferedOutputStream bos;
        try {
            bis = new BufferedInputStream(new FileInputStream(".\\imagen.jpg"));
            
            bos = new BufferedOutputStream(new FileOutputStream(".\\copia_imagen.jpg"));
            
            int c;
            while ((c = bis.read()) != -1){
                
                bos.write(c);
                
            }
            
            bis.close();
            bos.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error, fichero no encontrado.");
        } catch (IOException e){
            System.out.println("Error de entrada/salida");
        } 
    }
}
