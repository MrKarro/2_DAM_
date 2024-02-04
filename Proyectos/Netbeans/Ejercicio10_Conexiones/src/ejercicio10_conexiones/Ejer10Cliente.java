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

import java.util.Scanner;
public class Ejer10Cliente {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hola soy el cliente");
        int puerto = 9876;

        try {
            InetAddress direccionDelServidor = InetAddress.getByName("localhost");
            DatagramSocket socketCliente = new DatagramSocket();

            String opcion = "";
            
            int[] nums = new int[2];
            char operacion = ' ';
            DatagramPacket datagrama = null;
            do {
                opcion = muestraMenu();

                
                byte[] sendData = opcion.getBytes();
                datagrama = new DatagramPacket(sendData, sendData.length, direccionDelServidor, puerto);
                

                switch (opcion) {
                    case "1":
                        nums = pideYManda();
                        operacion = '+';
                        break;
                    case "2":
                        nums = pideYManda();
                        operacion = '-';
                        break;
                    case "3":
                        nums = pideYManda();
                        operacion = '*';
                        break;
                    case "4":
                        nums = pideYManda();
                        operacion = '/';
                        break;
                    case "9":
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opci0n errónea");
                        break;
                }

                
                //se itera tres veces, una por cada numero y otra paara mandar la operacion
                
                byte[] env = new byte[1024];
                String cadena = opcion + "*" + nums[0] + "*" + nums[1] + "*" ;
                env = cadena.getBytes();

                datagrama.setData(env);
                datagrama.setLength(env.length);
                socketCliente.send(datagrama);
                

                if (!opcion.equals("9")) {
                    
                    byte[] recibido = new byte[1024];
                    datagrama.setData(recibido);
                    datagrama.setLength(recibido.length);
                    
                    socketCliente.receive(datagrama);
                    
                    String res = new String(datagrama.getData());
                    
                    System.out.println("La operación " + nums[0] + " " + operacion + " " + nums[1] + " da como resultado: " + res);
                }

            } while (!opcion.equals("9"));

            socketCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String muestraMenu() {
        System.out.println("Seleccione lo que quiere hacer:");
        System.out.println("1 - Sumar");
        System.out.println("2 - Restar");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("9 - Salir");

        System.out.print("Introduzca una opcion: ");
        String opcion = scanner.next();

        return opcion;
    }

    public static int[] pideYManda() throws IOException {
        int[] nums = new int[2];
        System.out.print("Ingrese primer número: ");
        nums[0] = scanner.nextInt();
        System.out.print("Ingrese segundo número: ");
        nums[1] = scanner.nextInt();

        return nums;
    }
    
}
