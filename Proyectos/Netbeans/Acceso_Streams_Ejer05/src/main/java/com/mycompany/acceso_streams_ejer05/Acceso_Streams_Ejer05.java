/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acceso_streams_ejer05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
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
public class Acceso_Streams_Ejer05 {
    
    static String libro = System.getProperty("user.dir") + System.getProperty("file.separator") + "el_quijote.txt";
   static String salida = "./numero.txt";

    public static void main(String[] args) {
        
        File entrada = new File(libro);
        if (!entrada.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }  
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            File sal = new File(salida);
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(sal)));
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(entrada)));
            
            String linea;
            int numeroDeLineas = 0;
            while ((linea = dis.readLine()) != null) {
                
                numeroDeLineas++;
            }
            System.out.println("El libro tiene " + numeroDeLineas + " líneas.");
            dos.writeChars("El libro tiene " + numeroDeLineas + " líneas.");
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acceso_Streams_Ejer05.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Acceso_Streams_Ejer05.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dos.close();
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(Acceso_Streams_Ejer05.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
