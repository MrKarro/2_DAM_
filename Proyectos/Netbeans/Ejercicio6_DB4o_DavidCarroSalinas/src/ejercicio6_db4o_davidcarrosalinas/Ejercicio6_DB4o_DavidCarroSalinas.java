/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6_db4o_davidcarrosalinas;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author 6002755
 */
public class Ejercicio6_DB4o_DavidCarroSalinas {

    /**
     * @param args the command line arguments
     */
    
    static Scanner teclado = new Scanner(System.in);
    static String rutaBD = "./prueba";
    static ObjectContainer bd;
    
    public static void main(String[] args) {
        
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutaBD);
        
        
        
        
        Empleado per = new Empleado(0, null, null, 0, null, 0, 0,20);
        ObjectSet<Empleado> result = bd.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de Empleados..");
        else {
            System.out.printf("Número de registros: %d %n", 
            result.size());
            while (result.hasNext()) {
                Empleado p = result.next();
                System.out.printf("Numero empleado: %s, Nombre: %s %n", 
                p.getEmp_no(), p.getApellido());
            }
        }
        
        bd.close();
        
        
        

    }
    
    public int muestraMenu(){
        System.out.println("_______________________");
        System.out.println("_______________________");
        System.out.println("1. Crear base de datos");
        System.out.println("2. Mostrar datos de departamentos");
        System.out.println("3. Mostrar datos de empleados");
        System.out.println("4. Mostrar datos de empleados de ventas");
        System.out.println("5. Mostrar datos de empleados contratados entre 1980 y 1990");
        System.out.println("6. Mostrar nombre de departamento y la suma de sus salarios");
        System.out.println("7. Insertar un nuevo empleado.");
        System.out.println("8. Modificar un empleado.");
        System.out.println("9. Borrar un empleado.");
        System.out.println("_______________________");
        System.out.println("_______________________");
        
        int eleccion = teclado.nextInt();
        return eleccion;
    }
    public void creaBD(){
        
        
        Empleado e1  = new Empleado(1, "López", "contable", 345, LocalDate.of(1987,10,23), 23400.32f, 5.34f, 10);
        Empleado e2 = new Empleado(2, "Alonso", "contable", 346, LocalDate.of(11994,12,23), 20400.32f, 3.34f, 10);
        Empleado e3 = new Empleado(3, "Santana", "contable", 345, LocalDate.of(1980, 9, 23), 33670.20f, 8.84f, 10);
        Empleado e4 = new Empleado(4, "Gil", "investigad", 245,LocalDate.of(1987,01,23) , 23400.32f, 5.34f, 20);
        Departamento d1 = new Departamento(10, "CONTABILIDAD", "SEVILLA");
        Departamento d2 = new Departamento(20, "INVESTIGACIÓN", "MADRID");
        Departamento d3 = new Departamento(30, "VENTAS", "BARCELONA");
        Departamento d4 = new Departamento(40, "PRODUCCIÓN", "BILBAO");
        
        bd.store(e1); 
        bd.store(e2);
        bd.store(e3);
        bd.store(e4);
        bd.store(d1); 
        bd.store(d2);
        bd.store(d3);
        bd.store(d4);
        
    }
    
    public void muestraDpto(){
        
    }
    public void muestraEmp(){
        
    }
    
    public void muestraVentas(){
        
    }
    public void muestraNacidos(){
        
    }
    public void muestraDptoSalario(){
        
    }
    
        
        
        

}
    

