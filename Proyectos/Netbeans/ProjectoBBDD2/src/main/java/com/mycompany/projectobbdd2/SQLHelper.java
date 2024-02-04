/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectobbdd2;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class SQLHelper {
    static final String BBDD = "./bar.db";
    Connection con = null;
    
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
          
        }

        
        

        
        
        

        return connection;

        
    }


}
