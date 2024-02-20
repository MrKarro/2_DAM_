/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones_davidcarrosalinas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Jugador {
    public static void main(String[] args) {
        // Dirección IP y puerto del servidor
        String servidorIP = "127.0.0.1"; // Cambia esto por la dirección IP del servidor
        int puerto = 9876;

        try {
            DatagramSocket socketCliente = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            InetAddress direccionServidor = InetAddress.getByName(servidorIP);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socketCliente.connect(direccionServidor, puerto);

            socketCliente.receive(packet);            
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Preguntas preguntasRecibidas = (Preguntas) objectInputStream.readObject();
            String[] preguntas = preguntasRecibidas.getPreguntas();
            String[][] respuestasPosibles = preguntasRecibidas.getRespuestas();
            String[] respuestas = new String[preguntas.length];

            for (int i = 0; i < preguntas.length; i++) {
                System.out.println("Pregunta " + (i + 1) + ": " + preguntas[i]);
                System.out.println("Respuestas posibles:");
                for (int j = 0; j < respuestasPosibles[i].length; j++) {
                    System.out.println(respuestasPosibles[i][j]);
                }
                System.out.print("Ingresa la respuesta: ");
                respuestas[i] = scanner.nextLine();
               
            }
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(respuestas);
            objectOutputStream.flush();
            byte[] datosRespuestas = byteArrayOutputStream.toByteArray();

            // Enviar los datos al servidor
            DatagramPacket packetEnviar = new DatagramPacket(datosRespuestas, datosRespuestas.length, direccionServidor, puerto);
            socketCliente.send(packetEnviar);

            
            scanner.close();
            objectOutputStream.close();
            objectInputStream.close();
            socketCliente.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
