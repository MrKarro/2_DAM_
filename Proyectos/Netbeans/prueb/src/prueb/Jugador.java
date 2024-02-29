/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Jugador {
    
    private static Socket socketCliente;
    private static String nombre;
    
    public static void main(String[] args) {
        try{
        
            InetAddress dir = InetAddress.getByName("localhost");
            int puerto = 9876;
            socketCliente = new Socket(dir, puerto);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce tu nombre: ");
            nombre = scanner.next();

            ObjectInputStream ois = new ObjectInputStream(socketCliente.getInputStream());
            Preguntas preg =(Preguntas) ois.readObject();
            ArrayList<String> respuestas = (ArrayList<String>) preg.hazPreguntas();
            System.out.println("resp " + respuestas.size());
            respuestas.add(nombre);
            respuestas.add("fin");
            DataOutputStream oos = new DataOutputStream(socketCliente.getOutputStream());
            for (String s : respuestas){
                oos.writeUTF(s);
            }
            
        
            
            
            ois.close();
            oos.close();
            
            
        } catch (Exception e){
            
        }
    }
        
    
}
