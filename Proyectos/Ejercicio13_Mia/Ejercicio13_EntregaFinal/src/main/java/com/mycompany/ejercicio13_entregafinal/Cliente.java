package com.mycompany.ejercicio13_entregafinal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    private static Scanner teclado = new Scanner(System.in);
    private static Socket cliente;
    private static final int puerto = 9876;

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
       InetAddress dir = InetAddress.getByName("localhost");
       cliente = new Socket(dir, puerto);
       System.out.println("Hola, te has conectado al trivial online\n");
       ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
       while (true){           
            Pregunta pregunta = (Pregunta) ois.readObject();
            System.out.println(pregunta.toString());
            for(String r : pregunta.getRespuestas()){
                System.out.println("\n\t" + r);
            }
            int respuesta = teclado.nextInt();
            cliente.getOutputStream().write(respuesta);
            if(pregunta.isIsUltima()){
                break;
            }
       }   
    }

}
