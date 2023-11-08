/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acceso_pruebaxml;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author 6002755
 */
public class Acceso_PruebaXML_DOM {

    static Empleados[] emps;
    static DocumentBuilderFactory factory;
    

    public static void main(String[] args) {
        
        factory = DocumentBuilderFactory.newInstance();
        
        emps = addEmpleados();
        
        try {
            
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados",
            null);
            document.setXmlVersion("1.0");
            
            
            
            for (Empleados emp :emps){
                
                Element raiz = document.createElement("empleado");
                document.getDocumentElement().appendChild(raiz);
                //se crea cada atributo del nodo
            
                Element id = document.createElement("id");
                Text textid = document.createTextNode(Integer.toString(emp.getId()));
                raiz.appendChild(id); //se une el elemento con su padre
                id.appendChild(textid); // se añade el valor del elemento
                
                Element nombre = document.createElement("nombre");
                Text textnombre = document.createTextNode(emp.getNombre());
                raiz.appendChild(nombre);
                nombre.appendChild(textnombre);
                
                Element edad = document.createElement("edad");
                Text textedad = document.createTextNode(Integer.toString(emp.getEdad()));
                raiz.appendChild(edad); //se une el elemento con su padre
                edad.appendChild(textedad); // se añade el valor del elemento
                
                Element sueldo = document.createElement("sueldo");
                Text textsueldo = document.createTextNode(Double.toString(emp.getSueldo()));
                raiz.appendChild(sueldo); //se une el elemento con su padre
                sueldo.appendChild(textsueldo); // se añade el valor del elemento
            
            }
            
            
            //se crea la fuente XML partir del documento
            Source source = new DOMSource(document);
            //se crea el fichero de texto Empleados.xml
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            // se crea un TransformerFactory
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //se transforma el árbol al fichero
            transformer.transform(source, result);
            //se visualiza el documento por pantalla
            Result console= new StreamResult(System.out);
            transformer.transform(source, console);
            
            leerDOM();
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Acceso_PruebaXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Acceso_PruebaXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Acceso_PruebaXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Acceso_PruebaXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Acceso_PruebaXML_DOM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private static Empleados[] addEmpleados() {
        
        int[] ids = {101, 102, 103, 104, 105};
        String[] nombres = {"Juan", "María", "Carlos", "Laura", "Pedro"};
        int[] edades = {30, 28, 35, 29, 32};
        double[] salarios = {45000, 48000, 52000, 42000, 55000};
        
        Empleados[] emps = new Empleados[ids.length];
        
        
        for (int i = 0; i< ids.length; i++){
            emps[i] = new Empleados(ids[i], nombres[i], edades[i], salarios[i]);
        }
        return emps;
    }
    
    public static void leerDOM() throws ParseException, IOException, SAXException, ParserConfigurationException {
        
        
        //Pasamos un fichero XML a un árbol DOM usando el DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Se crea un Java DOM XML parser(analizador sintáctico)
        Document document = builder.parse("empleados.xml");
        document.getDocumentElement().normalize();
        //Se visualiza el nombre del elemento raíz
        System.out.println("");
        System.out.println("Elemento raiz: " +
        document.getDocumentElement().getNodeName());
        
        NodeList listaempleados = document.getElementsByTagName("empleado");
        
        for (int i = 0; i < listaempleados.getLength(); i++) {
            Node empleado = listaempleados.item(i); //obtiene un nodo
            if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) empleado;
                
                //Todo lo que recibes es un String, ya uqe viene de XML, si en vez de imprimirlo por pantalla lo parseas puedes crear un array/arrayList de empleados.
                System.out.println("Id: " + getNodo("id", elemento));
                System.out.println("Nombre: " + getNodo("nombre", elemento));
                System.out.println("Edad: " + getNodo("edad", elemento));
                System.out.println("Sueldo: " + getNodo("sueldo", elemento));
            }
        }  
    }
    
    
    private static String getNodo(String tag, Element elem) {
        NodeList nodo = elem.getElementsByTagName(tag).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}
