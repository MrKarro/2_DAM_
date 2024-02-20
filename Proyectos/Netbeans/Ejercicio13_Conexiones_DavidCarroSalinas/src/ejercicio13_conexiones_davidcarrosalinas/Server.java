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
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Server {
    
    String[] respuestasCorrectas = {"C", "B", "C", "B", "A"};
    
    public static void main(String[] args) {
        System.out.println("Hola soy el servidor");
        int puerto = 9876;

    

        
        
        try {
            DatagramSocket socketServidor = new DatagramSocket(puerto);

            byte[] recibido = new byte[1024];
            DatagramPacket datagrama = new DatagramPacket(recibido, recibido.length);

            while (true) {
                recibido = new byte[1024];
                datagrama.setData(recibido);
                datagrama.setLength(recibido.length);
                socketServidor.receive(datagrama);
                
                // Convertir los datos recibidos en un ArrayList de respuestas
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(recibido);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                ArrayList<String> respuestas = (ArrayList<String>) objectInputStream.readObject();

                // Comparar las respuestas con las respuestas correctas
                boolean respuestasCorrectas = true;
                
                for (int i = 0; i < listaPreguntas.size(); i++) {
                    if (!listaPreguntas.get(i).getRespuesta().equalsIgnoreCase(respuestas.get(i))) {
                        respuestasCorrectas = false;
                        break;
                    }
                }

                // Enviar mensaje al cliente
                String mensaje;
                if (respuestasCorrectas) {
                    mensaje = "¡Enhorabuena! Todas las respuestas son correctas.";
                } else {
                    mensaje = "Algunas respuestas son incorrectas. Inténtalo de nuevo.";
                }
                DatagramPacket respuestaDatagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length,
                        datagrama.getAddress(), datagrama.getPort());
                socketServidor.send(respuestaDatagrama);
                System.out.println("Soy el servidor y he enviado un mensaje");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
