/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueb;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class HiloServidor extends Thread {

    private Socket conexion;
    private Preguntas preguntas;
    private Tabla tabla;
    
    String[] respuestasCorrectas = {"C", "B", "C", "B", "A"};
    

    public HiloServidor(Socket conexion, Preguntas preguntas, Tabla tabla) {
        this.conexion = conexion;
        this.preguntas = preguntas;
        this.tabla = tabla;
  
    }

    @Override
    public void run() {
        try{
            
            OutputStream os = conexion.getOutputStream();
            ObjectOutputStream dos = new ObjectOutputStream(os);
            InputStream is = conexion.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            dos.writeObject(preguntas);

            ArrayList<String> respuestasYNombre = new ArrayList<>();
            String respuesta;
            while (!(respuesta = dis.readUTF()).equals("fin")) {
                respuestasYNombre.add(respuesta);
            }

            int puntuacion = 0;
            for (int i = 0; i< respuestasYNombre.size()-1; i++){
                if (respuestasYNombre.get(i).equalsIgnoreCase(respuestasCorrectas[i])){
                    puntuacion++;
                    System.out.println(puntuacion);
                }
            }
            String nombre = respuestasYNombre.get(respuestasYNombre.size()-1);
            tabla.addPuntos(nombre, puntuacion);
            
            
            
            os.close();
            dos.close();
            is.close();
            dis.close();
            conexion.close();
            
            
            
        
        } catch (Exception e){
            System.out.println(e.getMessage());
            
        }
        tabla.muestraTabla();
    }
        
}
