
package com.mycompany.ejercicio13_entregafinal;

import java.io.Serializable;


public class Pregunta implements Serializable{
    private static final long serialVersionUID = 1;
    private String pregunta;
    private String [] respuestas;
    private int resultado;
    private boolean isUltima = false;

    public Pregunta(String pregunta, String[] respuestas, int resultado) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.resultado = resultado;
    }

    public boolean isIsUltima() {
        return isUltima;
    }

    public void setIsUltima(boolean isUltima) {
        this.isUltima = isUltima;
    }

    @Override
    public String toString() {
        String n = pregunta;
        for(String respuesta : respuestas){
            n.concat("\n\t" + respuesta);
        }
        return n;
    }
    
    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getResultado() {
        return resultado;
    }
    
    
}
