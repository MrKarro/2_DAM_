/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acceso_pruebaxml_sax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author 6002755
 */
public class Acceso_PruebaXML_SAX {

    public static void main(String[] args) {
        try {
            
            //Se crea el procesador de XML
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            
            //Con esto se dice al lector de XML como gestionar los eventos
            reader.setContentHandler(new GestionContenido());
            //aquí se señala el documento en el que esta el xml
            reader.parse(new InputSource(new FileInputStream("empleados.xml")));
            
            
            
            
            
            
        } catch (SAXException ex) {
            Logger.getLogger(Acceso_PruebaXML_SAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Acceso_PruebaXML_SAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Acceso_PruebaXML_SAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Acceso_PruebaXML_SAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
