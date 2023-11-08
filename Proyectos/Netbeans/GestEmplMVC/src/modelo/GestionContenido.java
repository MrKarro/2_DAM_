/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author 6002755
 */
class GestionContenido extends DefaultHandler{
    

    @Override
    public void startDocument() throws SAXException {
        System.out.println("\nPrincipio del documento XML"); 
    }

    @Override
    
    public void endDocument() throws SAXException {
        System.out.println("\nFin del documento XML"); 
    }
    
    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        System.out.print("\nEtiqueta -> "+name);
        //Recorremos los atributos
        System.out.println("\t"+attributes.getLength()+" atributos: ");
        for(int i=0;i<attributes.getLength();i++){
        System.out.print("\t"+attributes.getQName(i)+": "+attributes.getValue(i));
        } }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("\tTexto: "+String.valueOf(ch, start, length)); }
    
    @Override
    public void endElement(String uri, String localName, String name)
    throws SAXException {
        System.out.println("fin "+name); 
    }
}