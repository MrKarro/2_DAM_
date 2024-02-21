package com.mycompany.ejercicio13_entregafinal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private static Pregunta[] preguntas = new Pregunta[5];
    private static final int CLIENTES = 2;
    private static Ranking ranking = new Ranking();
    
    public static void main(String[] args) throws IOException, InterruptedException {
        int puerto = 9876;
        ServerSocket socket = new ServerSocket(puerto);
        System.out.println("Hola soy el servidor");  
        int i = 0;
        addPreguntas();
        List<HiloServidor> hilos = new ArrayList<>();
        while (i != CLIENTES) {
            System.out.println("Esperando conexion");
            Socket conexion = socket.accept();
            HiloServidor hilo = new HiloServidor(conexion, preguntas, ranking, i);
            hilos.add(hilo);
            hilo.start();
            i++;
        }
        
        for (HiloServidor hilo : hilos) {
            hilo.join();
        }
        
        System.out.println("longitud: " + ranking.getRanking().size());
        for (String clave : ranking.getRanking().keySet()) {
            Integer valor = ranking.getRanking().get(clave);
            System.out.println("Clave: " + clave + ", Valor: " + valor);
        }
    }
    
    private static void addPreguntas(){
        String [] respuestas1 = new String [4];
        respuestas1[0] = "Berlin";
        respuestas1[1] = "Paris";
        respuestas1[2] = "Roma";
        respuestas1[3] = "Madrid";
        Pregunta a = new Pregunta(
                "¿Cual es la capital de Francia?",
                respuestas1,
                1
        );
        String [] respuestas2 = new String [4];
        respuestas2[0] = "Nilo";
        respuestas2[1] = "Amazonas";
        respuestas2[2] = "Yangtse";
        respuestas2[3] = "Misisipi";
        Pregunta b = new Pregunta(
                "¿Cual es el rio mas largo del mundo?",
                respuestas2,
                2
        );
        String [] respuestas3 = new String [4];
        respuestas1[0] = "7";
        respuestas1[1] = "8";
        respuestas1[2] = "9";
        respuestas1[3] = "10";
        Pregunta c = new Pregunta(
                "¿Cuantos planetas hay en el sistema solar?",
                respuestas3,
                1
        );
        String [] respuestas4 = new String [4];
        respuestas1[0] = "Berlin";
        respuestas1[1] = "Paris";
        respuestas1[2] = "Roma";
        respuestas1[3] = "Madrid";
        Pregunta d = new Pregunta(
                "¿Cual es la capital de Francia?",
                respuestas1,
                1
        );
        String [] respuestas5 = new String [4];
        respuestas1[0] = "Berlin";
        respuestas1[1] = "Paris";
        respuestas1[2] = "Roma";
        respuestas1[3] = "Madrid";
        Pregunta e = new Pregunta(
                "¿Cual es la capital de Francia?",
                respuestas1,
                1
        );
        preguntas[0] = a;
        preguntas[1] = b;
        preguntas[2] = c;
        preguntas[3] = d;
        preguntas[4] = e;
    }
   
}
