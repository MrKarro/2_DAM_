/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6_conexiones;

import java.io.*;
import java.net.*;
/**
 *
 * @author usuario
 */
public class Ejer6Servidor {
    public static void main(String[] args) {
		
        
        int puerto = 9876;
        try {
            ServerSocket socketServidor = new ServerSocket(puerto);
            Socket comunicacionConCliente = socketServidor.accept();

            InputStream isEntrada = comunicacionConCliente.getInputStream();
            DataInputStream diEntrada = new DataInputStream(isEntrada);
             OutputStream osSalida = comunicacionConCliente.getOutputStream();
            DataOutputStream doSalida = new DataOutputStream(osSalida);
            String recibido = "";
            do{
                recibido = diEntrada.readUTF();
                int priNum = diEntrada.readInt();
                int segNum = diEntrada.readInt();
                float resultado = 0f;
                switch(recibido){
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
                        resultado =(float) priNum / segNum;
                        break;
                    case "9":
                        
                        break;
                    default:

                }

                doSalida.writeFloat(resultado);
            } while (!recibido.equals("9"));

            doSalida.close();
            osSalida.close();
            isEntrada.close();
            diEntrada.close();
            comunicacionConCliente.close();
            socketServidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
