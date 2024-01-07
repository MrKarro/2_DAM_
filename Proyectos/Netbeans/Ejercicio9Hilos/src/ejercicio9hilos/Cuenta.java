/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9hilos;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Cuenta {
    private int dinero;
    
    Cuenta(int dinero){
        this.dinero = dinero;
    }
    
    public synchronized void retirarDinero(String nombre, int dinero){
        if (this.dinero >= 10){
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(MiHiloEjer9.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dinero -= dinero;
            System.out.println(nombre + " ha retirado  " + dinero + ", quedan " + this.dinero);
        } else {
            System.out.println("No se puede retirar dinero.");
        }
    }
}
