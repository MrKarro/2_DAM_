/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import entidades.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Modelo;


/**
 *
 * @author Carlos
 */
public class Vista {
    Controlador c= new Controlador();

    public void cargar_aleatorios() {
        System.out.println("¿Cuántos empleados vas a generar?: ");
        Scanner sc = new Scanner(System.in);
        String ent;
        ent = sc.nextLine();
        c.generarAleatorios(Integer.parseInt(ent));
    }

    public void mostrarEmpleados() {
        ArrayList<String> emp_mostrar = c.mostrarEmpleados();
        for (String st: emp_mostrar){
            System.out.println(st);
        }
            
    }
    
    public void escribeDom(){
        if (c.escribeDom())
            System.out.println("DOM escrito correctamente");
        else
            System.out.println("No se ha escrito DOM correctamente.");
        
    }
    public void leerDom(){
        c.leerDom();
    }
    public void leerSax(){
        c.leerSax();
    }
    public void escribeSax(){
        c.escribeSax();
    }
    public void leerXSTream(){
        
        c.leerXSTream();
        
        
    }
    public void escribeXSTream(){
        c.escribeXSTream();
    }

 

   
} // fin class Vista

