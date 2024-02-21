package com.mycompany.ejercicio13_entregafinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloServidor extends Thread {
    
    private Socket conexion;
    private Pregunta[] preguntas;
    private Ranking ranking;
    private int numJugador;
    
    public HiloServidor(Socket conexion, Pregunta[] preguntas, Ranking ranking, int numJugador){
        this.conexion = conexion;
        this.preguntas = preguntas;
        this.ranking = ranking;
        this.numJugador = numJugador;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("Hola, soy un hilo");
            OutputStream osSalida;
            ObjectOutputStream dosSalida;
            InputStream isEntrada;
            DataInputStream disEntrada;
            int[] respuesta = new int[preguntas.length];
            dosSalida = new ObjectOutputStream(conexion.getOutputStream());
            osSalida = conexion.getOutputStream();
            disEntrada = new DataInputStream(conexion.getInputStream());
            isEntrada = conexion.getInputStream();
            int puntuacion = 0;
            for(int i = 0 ; i<preguntas.length; i++){
                if(i == preguntas.length-1){
                    preguntas[i].setIsUltima(true);
                }
                //Enviar pregunta
                dosSalida.writeObject(preguntas[i]);              
                respuesta[i] = disEntrada.read();
                //Recibir respuesta  
                System.out.println("he recibido el mensaje");
                if(preguntas[i].getResultado() == respuesta[i]){
                    System.out.println("Acierto");
                    puntuacion ++;
                } else {
                    System.out.println("Error");
                }
            }           
            osSalida.close();
            dosSalida.close();
            isEntrada.close();
            disEntrada.close();
            ranking.agregarPuntuacion("jugador"+numJugador, puntuacion);
            conexion.close();
            
        } catch (IOException ex) {

            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
