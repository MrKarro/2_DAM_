/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import DOM.LeeDOM;
import SAX.EscribeSAX;
import XStream.Serializacion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import javax.xml.transform.TransformerException;
import modelo.Ciclo;
import modelo.Informatica;
import modelo.Modelo;
import modelo.Modulo;
import mysql.Conexion;

/**
 *
 * @author 6002755
 */
public class Vista {
    
    
    
    
    public static int muestraMenu(){
        return Modelo.muestraMenu();
        
        
    }
    
    public Informatica leerDOM() throws ParseException{
        return LeeDOM.leerDOM();
    }
    public void escribeDelimitado(Informatica inf) throws IOException{
        Modelo.escribeDelimitado(inf);
        
    }
    public void escribeEncolumnado(Informatica inf) throws IOException{
        Modelo.escribeEncolumnado(inf);
        
    }
    public void escribeXStream(Informatica inf) throws FileNotFoundException{
        Serializacion.escribeXStream(inf);
    }
    public void escribeBinario(Informatica inf) throws IOException{
        Modelo.escribeBinario(inf);
        
    }
    public Informatica leeBinario() throws IOException, FileNotFoundException, ClassNotFoundException{
        return Modelo.leeBinario();
        
    }
    public void muestraAlineado(Informatica inf){
        
        Modelo.muestraAlineado(inf);
        
    }
    public void escribeSAX(Informatica inf) throws TransformerException{
        EscribeSAX.escribeSAX(inf);
    }
    public void conexionBD(Informatica inf) throws SQLException{
        Conexion.insertaTodo(inf);
        Conexion.consultaModulos();
    }
    
}
