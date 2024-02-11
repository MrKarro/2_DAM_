/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectobbdd2;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author 6002755
 */
public class SQLHelper {
    static final String BBDD = "./bar.bd";
    
    
    public SQLHelper(){  
        
    }
    
    public static Connection crearComprobarBBDD() throws SQLException {

        // Se crea un archivo para comprobar si la base de datos existe
        File archivoBD = new File(BBDD);
        // Se crea la conexión a la base de datos
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + BBDD);
        //Se comprueba si no existe la base de datos se crea
        if (!archivoBD.exists()) {
            // Se genera una sentencia para crear las tablas de la BBDD y se introduces unos datos de ejemplo.
            Statement statement = connection.createStatement();
            String codigoSQL = 
                "CREATE TABLE Vendedor ( " +
                    "nombre VARCHAR(255) NOT NULL, " +
                    "numVenta INTEGER NOT NULL " +
                "); " +

                "CREATE TABLE Comanda ( " +
                  "refresco INTEGER NOT NULL, " +
                  "cafe INTEGER NOT NULL, " +
                  "cerveza INTEGER NOT NULL, " +
                  "infusion INTEGER NOT NULL,  " +
                  "bocadillo INTEGER NOT NULL, " +
                  "racion INTEGER NOT NULL " +
                ");";



            statement.executeUpdate(codigoSQL);
            System.out.println("BBDD creada");
          
        }
        return connection;
    }
    
    public static void insertarDatos(Connection con) throws SQLException{
        String sql = 
                "INSERT INTO Vendedor (nombre, numVenta) VALUES ('David', 1);" +
                "INSERT INTO Vendedor (nombre, numVenta) VALUES ('Mía', 2);" +
                "INSERT INTO Vendedor (nombre, numVenta) VALUES ('Jiawei', 3);" +
                "INSERT INTO Vendedor (nombre, numVenta) VALUES ('Alberto', 4);" +
        
                "INSERT INTO Comanda (refresco, cafe, cerveza, infusion, bocadillo, racion) VALUES (1, 2, 3, 4, 5, 3);" +
                "INSERT INTO Comanda (refresco, cafe, cerveza, infusion, bocadillo, racion) VALUES (7, 8, 9, 10, 11, 2);" +
                "INSERT INTO Comanda (refresco, cafe, cerveza, infusion, bocadillo, racion) VALUES (2, 3, 1, 0, 5, 1);" +
                "INSERT INTO Comanda (refresco, cafe, cerveza, infusion, bocadillo, racion) VALUES (13, 14, 15, 16, 17, 1);" ;
        
        Statement stat = con.createStatement();
        
        stat.executeUpdate(sql);
    }
    public static void insertaVendedor(Vendedor v, Connection con){
        try {
            Statement stat = con.createStatement();
            String busca = "SELECT nombre, numVenta FROM Vendedor where numVenta = " + v.getNumVenta();
            ResultSet rs = stat.executeQuery(busca);
            if (!rs.next()){
                String sql = "INSERT INTO Vendedor VALUES ('" + v.getNombre() + "', " + v.getNumVenta() + ");";
            
                stat.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void insertaComanda(Comanda c, Connection con){
        try {
            String sql = "INSERT INTO Comanda (refresco, cafe, cerveza, infusion, bocadillo, racion) VALUES (" + c.getRefresco() + ", " + c.getCafe() + ", " + c.getCerveza() + ", " + c.getInfusion() + ", " + c.getBocadillo() + ", " + c.getRacion() + "); ";
            Statement stat = con.createStatement();
            
            stat.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<Vendedor> consultaVendedores(Connection con){
        ArrayList<Vendedor> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Vendedor;";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()){
                String nombre = rs.getString("nombre");
                int numEmp = rs.getInt("numVenta");
                Vendedor ven = new Vendedor(nombre, numEmp);
                lista.add(ven);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }
    
    public static ArrayList<Comanda> consultaComandas(Connection con){
        ArrayList<Comanda> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Comanda;";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()){
                
                
                int refresco = rs.getInt("refresco");
                int cafe = rs.getInt("cafe");
                int cerveza = rs.getInt("cerveza");
                int infusion = rs.getInt("infusion");
                int bocadillo = rs.getInt("bocadillo");
                int racion = rs.getInt("racion");
                Comanda com = new Comanda(refresco, cafe, cerveza, infusion, bocadillo, racion);
                lista.add(com);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }
    public static void borraBase(Connection con){
        try {
            String sql = "DROP TABLE Vendedor;";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            sql = "DROP TABLE Comanda;";
            stat.executeUpdate(sql);
            sql = 
                "CREATE TABLE Vendedor ( " +
                    "nombre VARCHAR(255) NOT NULL, " +
                    "numVenta INTEGER NOT NULL " +
                "); " +

                "CREATE TABLE Comanda ( " +
                  "refresco INTEGER NOT NULL, " +
                  "cafe INTEGER NOT NULL, " +
                  "cerveza INTEGER NOT NULL, " +
                  "infusion INTEGER NOT NULL,  " +
                  "bocadillo INTEGER NOT NULL, " +
                  "racion INTEGER NOT NULL " +
                ");";
            stat.executeUpdate(sql);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
