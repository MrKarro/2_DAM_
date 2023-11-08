/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesoejer10_streams;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class AccesoEjer10_Streams {
    
    static final int VISUALIZAR_TODO     = 1;
    static final int VISUALIZAR_ID       = 2;
    static final int ANADIR              = 3;
    static final int MODIFICAR           = 4;
    static final int SALIR               = 6;
    
    static final int LONG_EMPLEADO     = 66;
    
    static RandomAccessFile raf = null;
    static StringBuffer buf = null;
    
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        File f = new File("./empleados.txt");
        
        try {
            raf = new RandomAccessFile(f, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoEjer10_Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (f.length() == 0){
            addDefault(f);
        }
        
        
        int eleccion = 0;
        do{
            try {
                eleccion = muestraMenu();
                switch (eleccion){
                    case VISUALIZAR_TODO:
                        verTodo(f);
                        break;
                        
                    case VISUALIZAR_ID:
                        verId();
                        break;
                    case ANADIR:
                        addEmpleado(f);
                        break;
                        
                    case MODIFICAR:
                        modificar();
                        break;
                        
                    case SALIR:
                        break;
                        
                }
            } catch (EOFException ex) {
                
            } catch (IOException ex) {
                Logger.getLogger(AccesoEjer10_Streams.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(eleccion != SALIR);
        
        raf.close();
        
        
        
    }

    private static void verId() throws IOException {
        System.out.println("Introduzca la posición del empleado que desea visualizar:");
        int pos = teclado.nextInt();
        raf.seek((pos-1)* LONG_EMPLEADO );
        int id = raf.readInt();
        
        char[] nombre = new char[25];
        for (int i = 0; i < 25 ; i++){
            nombre[i] += raf.readChar();
        }
        String nombreBien = new String(nombre).trim();
        
        
        int edad = raf.readInt();
        double salario = raf.readDouble();
        
        System.out.printf("%-5s %-15s %-2s  %-10s\n", id, nombreBien, edad, salario);
    }

    private static void verTodo(File f) throws IOException {
        System.out.printf("%-5s %-15s %-2s  %-10s\n", "ID", "Nombre", "Edad", "salario");
        
        raf.seek(0);
        long size = f.length();
        while (size > raf.getFilePointer()){
            int id = raf.readInt();
            
            char[] nombre = new char[25];
            for (int i = 0; i < 25 ; i++){
                nombre[i] += raf.readChar();
            }
            String nombreBien = new String(nombre).trim();
            
            
            int edad = raf.readInt();
            double salario = raf.readDouble();
            
            System.out.printf("%-5s %-15s %-2s  %-10s\n", id, nombreBien, edad, salario);
            
        }
    }

    private static void addEmpleado(File f) throws IOException {
        
        System.out.println("Introduce los datos del empleado:");
        System.out.println("Nombre:");
        String nombreRec = teclado.next();
        System.out.println("ID:");
        int idRec = teclado.nextInt();
        System.out.println("Edad:");
        int edadRec = teclado.nextInt();
        System.out.println("Salario:");
        double salarioRec = teclado.nextDouble();
        raf.skipBytes((int) f.length());
        raf.writeInt(idRec);
        buf = new StringBuffer(nombreRec);
        buf.setLength(25);
        raf.writeChars(buf.toString());
        raf.writeInt(edadRec);
        raf.writeDouble(salarioRec);
    }
    
    private static int muestraMenu(){
        System.out.println("\n==========================\n");
        System.out.println(VISUALIZAR_TODO + ". Visualizar fichero.");
        System.out.println(VISUALIZAR_ID + ". Visualizar empleado(por ID).");
        System.out.println(ANADIR + ". Añade un empleado.");
        System.out.println(MODIFICAR + ". Modificar datos de empleado.");
        System.out.println(SALIR + ". Salir");
        System.out.println("\n==========================\n");
        
        System.out.print("Introduzca su elección:\t");
        int eleccion = teclado.nextInt();
        return eleccion;
            
    }
    
   
    
    private static void modificar() throws IOException{
        System.out.println("Introduzca la posición del empleado que desea modificar:");
        int posicion = teclado.nextInt();
        raf.seek((posicion-1)* LONG_EMPLEADO );
        int id = raf.readInt();

        char[] nombre = new char[25];
        for (int i = 0; i < 25 ; i++){
            nombre[i] += raf.readChar();
        }
        String nombreBien = new String(nombre).trim();


        int edad = raf.readInt();
        double salario = raf.readDouble();
        System.out.println("Estos son los datos del empleado que desea modificar:");
        System.out.printf("%-5s %-15s %-2s  %-10s\n", id, nombreBien, edad, salario);

        raf.seek((posicion-1)* LONG_EMPLEADO );
        System.out.println("Introduce los nuevos datos del empleado:");

        System.out.println("Nombre:");
        String nombreRec = teclado.next();
        System.out.println("ID:");
        int idRec = teclado.nextInt();
        System.out.println("Edad:");
        int edadRec = teclado.nextInt();
        System.out.println("Salario:");
        double salarioRec = teclado.nextDouble();
        
        raf.writeInt(idRec);
        buf = new StringBuffer(nombreRec);
        buf.setLength(25);
        raf.writeChars(buf.toString());
        raf.writeInt(edadRec);
        raf.writeDouble(salarioRec);
        
        
        
        
    }
    private static void addDefault(File f) throws IOException{
        int[] ids = {101, 102, 103, 104, 105};
        String[] nombres = {"Juan", "María", "Carlos", "Laura", "Pedro"};
        int[] edades = {30, 28, 35, 29, 32};
        double[] salarios = {45000, 48000, 52000, 42000, 55000};
        
        for (int i = 0; i < ids.length; i++) {
            raf.seek((int) f.length());
            raf.writeInt(ids[i]);
            buf = new StringBuffer(nombres[i]);
            buf.setLength(25);
            raf.writeChars(buf.toString());
            raf.writeInt(edades[i]);
            raf.writeDouble(salarios[i]);
        }
        
        
        
    }
        
}
