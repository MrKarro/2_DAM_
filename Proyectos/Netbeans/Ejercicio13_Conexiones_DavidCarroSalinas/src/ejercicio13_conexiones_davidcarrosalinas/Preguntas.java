/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13_conexiones_davidcarrosalinas;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Preguntas implements Serializable{
    String[] preguntas = {
            "¿Cuántos días tiene una semana?",
            "¿Qué animal maulla?",
            "¿Cuál es el color del cielo en un día despejado?",
            "¿Cuántas patas tiene una araña?",
            "¿Qué planeta es conocido como el planeta rojo?"
        };
    String[][] opcionesRespuesta = {
            {"A- 5", "B- 6", "C- 7", "D- 8"},
            {"A- Perro", "B- Gato", "C- Pájaro", "D- Pez"},
            {"A- Rojo", "B- Verde", "C- Azul", "D- Amarillo"},
            {"A- 6", "B- 8", "C- 10", "D- 12"},
            {"A- Marte", "B- Júpiter", "C- Tierra", "D- Venus"}
            
        };
    


    public String[] getPreguntas() {
        
        return preguntas;
    }

    public String[][] getRespuestas() {
        return opcionesRespuesta;
    }
}
