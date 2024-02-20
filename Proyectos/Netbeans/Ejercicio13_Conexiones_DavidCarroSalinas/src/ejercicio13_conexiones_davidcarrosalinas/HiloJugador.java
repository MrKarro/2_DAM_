/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones_davidcarrosalinas;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class HiloJugador implements Runnable {
    private DatagramSocket socketServidor;
    private DatagramPacket datagrama;

    public HiloJugador(DatagramSocket socketServidor, DatagramPacket datagrama) {
        this.socketServidor = socketServidor;
        this.datagrama = datagrama;
    }

    @Override
    public void run() {
        try {
            // Convertir los datos recibidos en un ArrayList de respuestas
            byte[] recibido = datagrama.getData();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(recibido);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            ArrayList<String> respuestas = (ArrayList<String>) objectInputStream.readObject();

            // Comparar las respuestas con las respuestas correctas
            int correctas = 0;
            for (int i = 0; i < respuestas.size(); i++) {
                if (!respuestas.get(i).equalsIgnoreCase(respuestasCorrectas[i])) {
                    correctas++;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
