/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12hilos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class ProductorEjer12 extends Thread {
    
    private Cola cola;
    private char letra;
    private File archivo;
    
    
    public ProductorEjer12(Cola cola, File archivo){
        this.cola = cola;
        this.archivo = archivo;
    }

    @Override
    public void run() {
        
        try (FileReader lector = new FileReader(archivo)){
            
            int valor = lector.read();
            while (valor != -1){
                cola.put((char)valor);
                valor = lector.read();
            }
            
            
            
            lector.close();
        
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(ProductorEjer12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductorEjer12.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cola.put('*');
        }
        
        
    }
    
    
    
    
    
}
