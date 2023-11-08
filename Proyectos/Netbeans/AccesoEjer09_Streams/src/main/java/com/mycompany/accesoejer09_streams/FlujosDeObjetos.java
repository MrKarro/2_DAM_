/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesoejer09_streams;

import java.io.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlujosDeObjetos {
    
    private static final Scanner teclado = new Scanner(System.in);
    
    String archivoDeDatos = "datosDeFacturacion.bin";
    BigDecimal[] precio_unitario = {
        new BigDecimal("19.99"),
        new BigDecimal("9.99"),
        new BigDecimal("15.99"),
        new BigDecimal("3.99"),
        new BigDecimal("4.99")
    };
    int[] num_unidades = {12, 8, 13, 29, 50};
    String[] descripciones = {"Acceso a datos", "Bases de datos", "Java", "Android Studio", "Programación móviles"};

    public void escribirDisco() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDeDatos))) {
            oos.writeObject(precio_unitario);
            oos.writeObject(num_unidades);
            oos.writeObject(descripciones);
        } catch (IOException ex) {
            Logger.getLogger(FlujosDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leerDisco() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDeDatos))) {
            precio_unitario = (BigDecimal[]) ois.readObject();
            num_unidades = (int[]) ois.readObject();
            descripciones = (String[]) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FlujosDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void appendElemento() {
        System.out.println("Introduzca el nombre:");
        String nombre = teclado.next();
        System.out.println("Introduzca el número de unidades:");
        int unidades = teclado.nextInt();
        System.out.println("Introduzca el precio:");
        BigDecimal precio = new BigDecimal(teclado.next());

        ArrayList<BigDecimal> precioList = new ArrayList<>(Arrays.asList(precio_unitario));
        precioList.add(precio);
        precio_unitario = precioList.toArray(new BigDecimal[0]);

        ArrayList<Integer> unidadesList = new ArrayList<>();
        unidadesList.addAll(Arrays.stream(num_unidades).boxed().toList());
        unidadesList.add(unidades);
        num_unidades = unidadesList.stream().mapToInt(Integer::intValue).toArray();

        ArrayList<String> descripcionesList = new ArrayList<>(Arrays.asList(descripciones));
        descripcionesList.add(nombre);
        descripciones = descripcionesList.toArray(new String[0]);
    }

    public void muestraElementos() {
        for (int i = 0; i < precio_unitario.length; i++) {
            System.out.println("Nombre: " + descripciones[i] + "\nUnidades: " + num_unidades[i] + "\nPrecio: " + precio_unitario[i]);
        }
    }
    
    
}