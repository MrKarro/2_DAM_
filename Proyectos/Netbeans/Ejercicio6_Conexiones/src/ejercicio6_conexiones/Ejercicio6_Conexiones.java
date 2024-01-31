/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6_conexiones;

/**
 *
 * @author usuario
 */
public class Ejercicio6_Conexiones {
    public static void main(String[] args) {
        
        Thread servidorThread = new Thread(() -> Ejer6Servidor.main(null));
        servidorThread.start();

        // Esperar un momento para que el servidor esté listo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Iniciar el cliente
        Ejer6Cliente.main(null);
        
    }
}
