/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.sql.*;
import java.util.Scanner;
import modelo.Ciclo;
import modelo.Informatica;
import modelo.Modulo;


/**
 *
 * @author 6002755
 */
public class Conexion {
    
    public static void consultaModulos(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "123456");
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduzca un ciclo que buscar:");
            String ciclo = teclado.next();
            System.out.println("Introduzca un curso que buscar:");
            String curso = teclado.next();
            
            
            String sql = "SELECT modulo.nombre FROM ciclo, modulo WHERE ciclo.nombre_corto = ? AND modulo.curso = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, ciclo);
            ps.setString(2, curso);
            ResultSet resul = ps.executeQuery();
            
            while (resul.next()) {
                
                System.out.println("Modulo: " + resul.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void insertaTodo(Informatica inf) throws SQLException{
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "123456");
        for (Ciclo c : inf.getCiclos()){
            
            String sql = "INSERT INTO ciclo VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, c.getNombreCorto());
            ps.setString(2, c.getNombreLargo());
            ps.setString(3, c.getGrado());
            ps.setInt(4, c.getHoras());
            ps.executeUpdate();
            for (Modulo m : c.getModulos()){
                sql = "INSERT INTO modulo VALUES (?, ?, ?)";
                PreparedStatement ps2 = conexion.prepareStatement(sql);
                ps2.setString(1, m.getNombre());
                ps2.setString(2, m.getCurso());
                ps2.setString(3, c.getNombreCorto());       
                ps2.executeUpdate();
            }
        
        }
        
        
    }
    
    
}
