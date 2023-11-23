/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Modelo {
    
    
    
    public static int muestraMenu(){
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("1. Mostrar datos.");
        System.out.println("2. Escribir delimitado.");
        System.out.println("3. Escribir encolumnado.");
        System.out.println("4. Escribir binario.");
        System.out.println("5. Leer binario.");
        System.out.println("6. Leer DOM.");
        System.out.println("7. Escribir SAX.");
        System.out.println("8. Escribir XStream.");
        System.out.println("9. Muestra ciclo (MySQL).");
        System.out.println("10. Salir.");
        
        System.out.println("=======================");
        System.out.println("=======================");
        
        System.out.println("Introduce una opcion:");
        
        Scanner teclado = new Scanner(System.in);
        
        int elec = teclado.nextInt();
        
        return elec;
        
        
    }
    
    public static void muestraAlineado(Informatica inf){
        
        for (Ciclo c : inf.getCiclos()){
            System.out.printf("%s\t %s\t %s \n", c.getNombreCorto(), c.getGrado(), String.valueOf(c.getHoras()));
            for (Modulo m : c.getModulos()){
                System.out.printf("\t%s\t\t\t %s \n", m.getNombre(), m.getCurso());
            }
        }
        
    }
    
    public static void escribeDelimitado(Informatica inf) throws IOException{
        
        FileWriter fw = new FileWriter("./delimitado.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        
            for (Ciclo c : inf.getCiclos()){
                System.out.println(c.toString());
                bw.append(c.toString());
                
            }
        bw.close();
         
    }
    public static void escribeEncolumnado(Informatica inf) throws IOException{

            for (Ciclo c : inf.getCiclos()){
                String nombre = c.getNombreCorto() + ".txt";
                FileWriter fw = new FileWriter(nombre);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Modulo m : c.getModulos()){
                
                    String escrib = m.getCurso() + "\t\t" + m.getNombre() + "\n";
                
                    bw.append(escrib);
                }
                bw.close();
            }
        
         
    }
    
    
    
    public static void escribeBinario(Informatica inf) throws FileNotFoundException, IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datosMem.bin"));
        
        oos.writeObject(inf);
        
    }
    public static Informatica leeBinario() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datosMem.bin"));
        Informatica inf = (Informatica) ois.readObject();
        return inf;
        
    }
    
}
