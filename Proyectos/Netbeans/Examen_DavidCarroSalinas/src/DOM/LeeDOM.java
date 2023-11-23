/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DOM;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Ciclo;
import modelo.Informatica;
import modelo.Modulo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 6002755
 */
public class LeeDOM {
    
    
    public static Informatica leerDOM() throws ParseException {
        
        ArrayList<Ciclo> ciclos = new ArrayList<>();
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //Pasamos un fichero XML a un árbol DOM usando el DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Se crea un Java DOM XML parser(analizador sintáctico)
            Document document = builder.parse("informatica.xml");
            document.getDocumentElement().normalize();
            //Se visualiza el nombre del elemento raíz
            System.out.println("Elemento raiz:" + 
            document.getDocumentElement().getNodeName());
            
            NodeList listaciclos = document.getElementsByTagName("ciclo");
            
            for (int i = 0; i < listaciclos.getLength(); i++) {
                Node ciclo = listaciclos.item(i); //obtiene un nodo
                if (ciclo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) ciclo; 
                    
                    String nombreCorto = getNodo("nombre_corto", elemento);
                    String nombreLargo = getNodo("nombre_largo", elemento);
                    String grado = getNodo("grado", elemento);
                    int horas = Integer.parseInt(getNodo("horas", elemento));
                    
                    NodeList modulos = elemento.getElementsByTagName("modulo");
                    ArrayList<Modulo> mods = new ArrayList<>();
                    for(int j = 0; j < modulos.getLength(); j++){
                        Node mod = modulos.item(j);
                        
                        if (mod.getNodeType() == Node.ELEMENT_NODE){
                            Element elem = (Element) mod;
                            String nom = getNodo("nombre", elem);
                            String curso = getNodo("curso", elem);
                            
                            Modulo m = new Modulo(nom, curso);
                            mods.add(m);
                        }
                    }
                    Ciclo c = new Ciclo(nombreCorto, nombreLargo, grado, horas, mods);
                    ciclos.add(c);
                    
                    System.out.println(ciclos.size());
                }
        }
            
            
            
            
        } catch (SAXException ex) {
            Logger.getLogger(LeeDOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeeDOM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LeeDOM.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ciclos.size());
        
        Informatica inf = new Informatica(ciclos);
        return inf;
    }
    
    private static String getNodo(String tag, Element elem) {
        NodeList nodo = 
        elem.getElementsByTagName(tag).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}
    
    
