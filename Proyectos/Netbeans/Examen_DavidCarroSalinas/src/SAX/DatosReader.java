/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SAX;
import java.io.*;
import java.util.ArrayList;
import modelo.Ciclo;
import modelo.Informatica;
import modelo.Modulo;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 *
 * @author 6002755
 */
public class DatosReader implements XMLReader {
    
    private ContentHandler handler;
    private final AttributesImpl atts = new AttributesImpl();
    //métodos que serán usados por el transformer
    @Override
    public void parse(InputSource input) throws IOException, SAXException {
        if (!(input instanceof Informatica)) { String m = "El único parámetro para el parser es un Alm_datos";
            throw new SAXException(m); }
        if (handler == null) { throw new SAXException("Sin ContentHandler"); }
        
        Informatica source = (Informatica) input;
        ArrayList<Ciclo> ciclos = source.getCiclos();
        handler.startDocument();
        handler.startElement("", "informatica", "informatica", atts);
        for (Ciclo c : ciclos) {
            handler.startElement("", "ciclo", "ciclo", atts);
            
                handler.startElement("", "nombre_corto", "nombre_corto", atts);
                char[] nombre_corto = c.getNombreCorto().toCharArray();
                handler.characters(nombre_corto, 0, nombre_corto.length);
                handler.endElement("", "nombre_corto", "nombre_corto");

                handler.startElement("", "nombre_largo", "nombre_largo", atts);
                char[] nombre_largo = c.getNombreLargo().toCharArray();
                handler.characters(nombre_largo, 0, nombre_largo.length);
                handler.endElement("", "nombre_largo", "nombre_largo");

                handler.startElement("", "grado", "grado", atts);
                char[] grado = c.getGrado().toCharArray();
                handler.characters(grado, 0, grado.length);
                handler.endElement("", "grado", "grado");


                handler.startElement("", "horas", "horas", atts);
                char[] horas = String.valueOf(c.getHoras()).toCharArray();
                handler.characters(horas, 0, grado.length);
                handler.endElement("", "horas", "horas");
                
                
                handler.startElement("", "modulos", "modulos", atts);
                
                for (Modulo m : c.getModulos()){
                    handler.startElement("", "modulo", "modulo", atts);
                    
                    handler.startElement("", "nombre", "nombre", atts);
                    char[] nombre = m.getNombre().toCharArray();
                    handler.characters(nombre, 0, nombre.length);
                    handler.endElement("", "nombre", "nombre");

                    handler.startElement("", "curso", "curso", atts);
                    char[] curso = m.getCurso().toCharArray();
                    handler.characters(curso, 0, curso.length);
                    handler.endElement("", "curso", "curso");
                    handler.endElement("", "modulo", "modulo");
                }
                handler.endElement("", "modulos", "modulos");
            
            handler.endElement("", "ciclo", "ciclo");

        }
        handler.endElement("", "informatica", "informatica");
    }
    
    @Override
    public ContentHandler getContentHandler() {
        return handler; }
    @Override
    public void setContentHandler(ContentHandler handler) {
        this.handler = handler; }
    @Override
    public void parse(String systemId) { }
    @Override
    public boolean getFeature(String name) {
        return false; }
    @Override
    public void setFeature(String name, boolean value) { }
    @Override
    public Object getProperty(String name) {
        return null;
    }
    @Override
    public void setProperty(String name, Object value) { }
    @Override
    public void setEntityResolver(EntityResolver resolver) { }
    @Override
    public EntityResolver getEntityResolver() {
        return null; }
    @Override
    public void setDTDHandler(DTDHandler handler) { }
    @Override
    public DTDHandler getDTDHandler() {
        return null; }
    @Override
    public void setErrorHandler(ErrorHandler handler) { }
    @Override
    public ErrorHandler getErrorHandler() {
        return null;
    }


}
