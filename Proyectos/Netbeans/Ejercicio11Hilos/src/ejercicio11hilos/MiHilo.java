/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class MiHilo extends Thread {

    String texto;
    int id;
    Object testigo;

    MiHilo(String texto, int id, Object testigo) {
        this.texto = texto;
        this.id = id;
        this.testigo = testigo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (testigo) {
                if (this.id == 1) {
                    try {
                        System.out.print(texto);
                        testigo.wait();
                        testigo.notify();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        testigo.notify();
                        System.out.print(texto);
                        testigo.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

}
