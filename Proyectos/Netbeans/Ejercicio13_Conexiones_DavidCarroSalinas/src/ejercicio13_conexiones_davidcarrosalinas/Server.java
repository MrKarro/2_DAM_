/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones_davidcarrosalinas;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */

public class Server {
    
    static Tabla tabla;
    static Preguntas preguntas = new Preguntas();
    
    public static void main(String[] args) {
        System.out.println("Hola soy el servidor");
        int puerto = 9876;
        
        ServerSocket socket = new ServerSocket(puerto);
        
        while (true) {
            System.out.println("Esperando conexion");
            Socket conexion = socket.accept();
            HiloServidor hilo = new HiloServidor(conexion, preguntas, tabla);
            
            hilo.start();
            
        }
        


       
    }
    
}
