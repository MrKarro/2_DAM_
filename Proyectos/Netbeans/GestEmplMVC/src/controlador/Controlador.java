/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Alm_datos;
import modelo.Modelo;
import org.xml.sax.SAXException;

/**
 *
 * @author Carlos
 */
public class Controlador {
    Modelo m= new Modelo();

    public void generarAleatorios(int parseInt) {
        m.generarAleatorios(parseInt);
    }

    public ArrayList<String> mostrarEmpleados() {
       return m.mostrarEmpleados();
    }
    
    public boolean escribeDom(){
        
        return m.escribeDom();
    }
    public void leerDom(){
        try {
            m.leerDOM();
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerSax(){
        try {
            m.leerSax();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribeSax(){
        m.escribeSax();
    }
    
    public void leerXSTream(){
        
        m.leerXSTream();
        
    }
    public void escribeXSTream(){
        m.escribeXSTream();
    }
    
}
