/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12hilos;

/**
 *
 * @author 6002755
 */
public class Consumidor extends Thread {
    
    private Cola cola;
    private char recibido;
   
    
    
    public Consumidor(Cola cola, char letra){
        this.cola = cola;
        this.recibido = letra;
        
    }

    @Override
    public void run() {
        recibido = cola.get();
        while (recibido != '*'){
            System.out.println(recibido);
            
            recibido = cola.get();
            
        }
        
        
    }
    
    
    
}
