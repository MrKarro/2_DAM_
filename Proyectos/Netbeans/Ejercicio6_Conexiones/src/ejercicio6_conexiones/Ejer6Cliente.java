/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6_conexiones;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Ejer6Cliente {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        int puerto = 9876;

        try {
            InetAddress direccionDelServidor = InetAddress.getByName("localhost");
            Socket cliente = new Socket(direccionDelServidor, puerto);

            
            
            //abrimos las conexiones
            
            OutputStream osSalida = cliente.getOutputStream();
            DataOutputStream doSalida = new DataOutputStream(osSalida);
            InputStream isEntrada = cliente.getInputStream();
            DataInputStream diEntrada = new DataInputStream(isEntrada);
            
            
            
            String opcion = "";
            int priNum = 0;
            int segNum = 0;
            int[] nums = new int[2];
            char operacion = ' ';
            do{
                opcion = muestraMenu();
                doSalida.writeUTF(opcion);
                switch(opcion){
                    case "1":
                        nums = pideYManda(doSalida);
                        operacion = '+';
                        break;
                    case "2":
                        nums = pideYManda(doSalida);
                        operacion = '-';
                        break;
                    case "3":
                        nums = pideYManda(doSalida);
                        operacion = '*';
                        break;
                    case "4":
                        nums = pideYManda(doSalida);
                        operacion = '/';
                        break;
                    case "9":
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        System.out.println("Opci0n errónea");
                        break;


                }
                
                float res = diEntrada.readFloat();
                System.out.println("La operaci0n " + nums[0] + " " + operacion + " " + nums[1] + " da como resultado: " + res);
                
            } while (!opcion.equals("9"));

            
            //Recibimos lo que el servidor nos ha enviado y lo imprimimos
            
            
           
           


            doSalida.close();
            osSalida.close();
            isEntrada.close();
            diEntrada.close();
            cliente.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String muestraMenu(){
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
    public static int[] pideYManda(DataOutputStream doSalida) throws IOException{
        int[] nums = new int[2];
        System.out.print("Ingrese primer número: ");
        nums[0] = scanner.nextInt();
        doSalida.writeInt(nums[0]);
        System.out.print("Ingrese segundo número: ");
        nums[1] = scanner.nextInt();
        doSalida.writeInt(nums[1]);
        
        return nums;
    }
    

}
