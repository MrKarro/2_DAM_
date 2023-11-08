/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaaccesolecturaficheros;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class PruebaAccesoLecturaFicheros {

    public static void main(String[] args) {
        BufferedReader br;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader(".\\prueba.txt"));
            bw = new BufferedWriter(new FileWriter(".\\copia.txt"));
            int c, cont = 0 ;
            while ((c = br.read()) != -1){
                cont++;
                bw.write( Character.toUpperCase(c));
            } 
            System.out.println("Se han leído " + cont + " caracteres.");
            br.close();
            bw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PruebaAccesoLecturaFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PruebaAccesoLecturaFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
