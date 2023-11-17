/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio08_conexiones;

import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio08_Conexiones {

    /**
     * @param args the command line arguments
     */
    static Connection conexion;
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        int elec = 0;
        
        do{
        
            try {
                


                elec = muestraMenu();
                switch (elec) {
                    case 1:
                        conexion = DriverManager.getConnection("jdbc:sqlite:./prueba.db");

                        break;
                    case 2:
                        conexion = DriverManager.getConnection("jdbc:derby:./prueba");

                        break;
                    case 3:
                        conexion = DriverManager.getConnection("jdbc:hsqldb:file:./prueba");
                        break;
                    case 4:
                        conexion = DriverManager.getConnection("jdbc:h2:./prueba");
                        break;
                    default:
                        System.out.println("Error, usted ha introducido un valor erróneo.");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Ejercicio08_Conexiones.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }while (elec != 5);
        
        
        
        
    }
    
    
    public static int muestraMenu(){
        System.out.println("------------------");
        System.out.println("Elige un gestor:");
        System.out.println("1. SQLite");
        System.out.println("2. Derby");
        System.out.println("3. HSQLDB");
        System.out.println("4. H2");
        System.out.println("5. Salir del programa");        
        System.out.println("----------------");
        System.out.println("Introduce una opcion: ");
        int selec = teclado.nextInt();
        return selec;
    
    }
    
    public static void muestraMetadata() throws SQLException{
        
        DatabaseMetaData dbmd=conexion.getMetaData();
        ResultSet result = null;
        String nombre= dbmd.getDatabaseProductName();
        String driver= dbmd.getDriverName();
        String url= dbmd.getURL();
        String usuario= dbmd.getUserName();
        
        
        System.out.println("\n\nINFORMACIÓN BASE DATOS");
        System.out.println("Nombre: "+nombre);
        System.out.println("Driver: "+driver);
        System.out.println("URL: "+url);
        System.out.println("Usuario: "+usuario);
        
        ArrayList<String> lista = new ArrayList<>();
        // información sobre tablas y vistas
        result= dbmd.getTables(null, "prueba", null, null);
        
        System.out.println("\n\nINFORMACIÓN SOBRE TABLAS:");
        while (result.next()){
            String catalogo= result.getString(1);
            String esquema= result.getString(2);
            String tabla= result.getString(3);
            String tipo= result.getString(4);
            
            if (tipo.equalsIgnoreCase("table")){
                
                System.out.println(tipo + " - Catálogo: "+ catalogo+
            ", Esquema: "+esquema+", Nombre: "+tabla);
                lista.add(tabla);
                
                
            }
        
        }
        
        
        ResultSet columnas=null;
        System.out.println("\n\nINFORMACIÓN SOBRE COLUMNAS:");
        for (String tabla : lista){
            columnas= dbmd.getColumns(null, "prueba", tabla , null);
            while (columnas.next()){
                String name= columnas.getString("TABLE_NAME"); //getString(3);
                String nombreCol= columnas.getString("COLUMN_NAME"); //getString(4);
                String tipoCol= columnas.getString("TYPE_NAME"); //getString(6);
                String tamCol= columnas.getString("COLUMN_SIZE"); //getString(7);
                String nula= columnas.getString("IS_NULLABLE"); //getString(18);
                System.out.println("Tabla: "+name+" Columna: "+nombreCol+", Tipo: "+ 
                tipoCol + ", Tamaño: "+tamCol+", ¿Es nula?: "+ nula);
            }
        }
    }
}
