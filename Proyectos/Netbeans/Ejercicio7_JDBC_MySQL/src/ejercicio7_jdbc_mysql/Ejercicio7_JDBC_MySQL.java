/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7_jdbc_mysql;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio7_JDBC_MySQL {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    static Statement st = null;
    
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "123456");
            st = connection.createStatement();
            int selec;
            do{
                selec = muestraMenu();

                switch (selec){
                    case 1:
                        muestraVentas();
                        break;

                    case 2:
                        muestraNacidos();
                        break;

                    case 3:
                        muestraDpto();
                        break;

                    case 4:
                        break;
                    default:
                        System.out.println("No ha introducido un valor correcto.");

                }
            
            } while (selec != 4);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio7_JDBC_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public static int muestraMenu(){
        System.out.println("------------------");
        System.out.println("1. Mostrar empleados de ventas");
        System.out.println("2. Mostrar empleados nacidos entre 1980 y 1990");
        System.out.println("3. Ver departamento y suma de salario");
        System.out.println("4. Salir");
        System.out.println("----------------");
        System.out.println("Introduce una opcion: ");
        int selec = teclado.nextInt();
        return selec;
    
    }
    
    public static void muestraVentas() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT apellido FROM empleados WHERE dept_no LIKE 30");
        while(rs.next()){
            System.out.println(rs.getObject(1));
        }
        
    }
    public static void muestraNacidos() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT apellido FROM empleados WHERE fecha_alta > '1980-01-01' AND fecha_alta < '1990-10-01';");
        while(rs.next()){
            System.out.println(rs.getObject(1));
        }
    }
    public static void muestraDpto() throws SQLException{
        ResultSet rs = st.executeQuery("SELECT dnombre, sum(salario) FROM empleados, departamentos WHERE empleados.dept_no = departamentos.dept_no GROUP BY dnombre");
        while(rs.next()){
            System.out.println(rs.getObject(1)+" - "+rs.getObject(2));
        }
    }
    
    
    
}
