/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10_conexiones;

/**
 *
 * @author Usuario
 */
import java.io.*;
import java.net.*;
public class Ejer10Servidor {
    public static void main(String[] args) {
        System.out.println("Hola soy el servidor");
        int puerto = 9876;
        int priNum;
        int segNum;

        try {
            DatagramSocket socketServidor = new DatagramSocket(puerto);

            byte[] recibido = new byte[1024];
            DatagramPacket datagrama = new DatagramPacket(recibido, recibido.length);

            while (true) {
                recibido = new byte[1024];
                
                datagrama.setData(recibido);
                datagrama.setLength(recibido.length);
                
                
                socketServidor.receive(datagrama);
                String infoRecibida = new String(datagrama.getData());
                
                String[] recib = infoRecibida.split("[*]");
                
                
                
                if (recibido.equals("9")) {
                    break; 
                }
                priNum = Integer.parseInt(recib[1]);
                segNum = Integer.parseInt(recib[2]);
                
                float resultado = 0f;

                switch (recib[0]) {
                    case "1":
                        resultado = priNum + segNum;
                        break;
                    case "2":
                        resultado = priNum - segNum;
                        break;
                    case "3":
                        resultado = priNum * segNum;
                        break;
                    case "4":
                        resultado = (float) priNum / segNum;
                        break;
                    default:
                        
                        break;
                }

                
                String resultadoStr = String.valueOf(resultado);
                datagrama.setData(resultadoStr.getBytes());
                datagrama.setLength(resultadoStr.getBytes().length);
                
                socketServidor.send(datagrama);
                System.out.println("Soy el servidor y he enviado un mensaje");
                
            }

            socketServidor.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
