package modelo;

import com.thoughtworks.xstream.XStream;
import entidades.Empleado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *
 * @author Carlos
 */
public class Modelo implements Serializable {

    private ArrayList<Empleado> empleados;
    DocumentBuilderFactory factory;
    
    public Modelo() {
        empleados = new ArrayList<>();
    }

    public ArrayList<String> mostrarEmpleados() {   
       ArrayList<String> emp_mostrar = new ArrayList<>();
       for (Empleado emp: empleados){
           emp_mostrar.add(emp.getColumna());
       }
       return emp_mostrar;
    }

    public void generarAleatorios(int n) {
        for(int i=0; i< n; i++){
            Empleado e= new Empleado();
            e.emp_aleatorio();
            empleados.add(e);
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean escribeDom(){
        factory = DocumentBuilderFactory.newInstance();
        try {
            
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados",
            null);
            document.setXmlVersion("1.0");
            
            
            
            for (Empleado emp :empleados){
                
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
                
                Element apell1 = document.createElement("apell1");
                Text textapell1 = document.createTextNode(emp.getApell1());
                raiz.appendChild(apell1); //se une el elemento con su padre
                apell1.appendChild(textapell1); // se añade el valor del elemento
                
                Element apell2 = document.createElement("apell2");
                Text textapell2 = document.createTextNode(emp.getApell2());
                raiz.appendChild(apell2); //se une el elemento con su padre
                apell2.appendChild(textapell2); // se añade el valor del elemento
                
                Element sueldo = document.createElement("sueldo");
                Text textsueldo = document.createTextNode(Double.toString(emp.getSalario()));
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
            
            
            
            
            
        } catch (TransformerException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public void leerDOM() throws ParseException, IOException, SAXException, ParserConfigurationException {
        empleados.clear();
        
        //Pasamos un fichero XML a un árbol DOM usando el DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Se crea un Java DOM XML parser(analizador sintáctico)
        Document document = builder.parse("empleados.xml");
        document.getDocumentElement().normalize();
        //Se visualiza el nombre del elemento raíz
        System.out.println("");
        System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
        
        NodeList listaempleados = document.getElementsByTagName("empleado");
        
        for (int i = 0; i < listaempleados.getLength(); i++) {
            Node empleado = listaempleados.item(i); //obtiene un nodo
            if (empleado.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) empleado;
                
                //Todo lo que recibes es un String, ya uqe viene de XML, si en vez de imprimirlo por pantalla lo parseas puedes crear un array/arrayList de empleados.
                
                Empleado e = new Empleado(Integer.parseInt(getNodo("id", elemento)), getNodo("nombre", elemento), getNodo("apell1", elemento), getNodo("apell2", elemento), Float.parseFloat(getNodo("sueldo", elemento)));
                empleados.add(e);
                
            }
        }
        
        
    }
    private static String getNodo(String tag, Element elem) {
        NodeList nodo = elem.getElementsByTagName(tag).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
    public void leerSax() throws IOException{
        try {
            //Se crea el procesador de XML
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            
            //Con esto se dice al lector de XML como gestionar los eventos
            reader.setContentHandler(new GestionContenido());
            //aquí se señala el documento en el que esta el xml
            reader.parse(new InputSource(new FileInputStream("empleados.xml")));
            
            
            
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void escribeSax(){
        
        
        try {
            XMLReader datosReader = new DatosReader();
            InputSource datosSource = new Alm_datos(50);
            Source source = new SAXSource(datosReader, datosSource);
            
            
            File f = new File("empleadosSAX.xml");
            Result resultado = new StreamResult(f);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(source, resultado);
        } catch (TransformerException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void leerXSTream(){
        ArrayList<Empleado> listaemp = new ArrayList<>();
        try {
            XStream xstream= new XStream();
            xstream.alias("Alm_datosXS", Alm_datos.class);
            xstream.alias("EmpleadoXS", Empleado.class);
            
            xstream.allowTypes(new String[]{"entidades.Empleado"});
            listaemp= (ArrayList) xstream.fromXML(new FileInputStream("EmpleadosXS.xml"));
            
            
            File pagHTML = new File("pagina.html");
            FileOutputStream fos = new FileOutputStream(pagHTML);
            Source estilos = new StreamSource("EmpleadosXSL.xsl");
            Source datos = new StreamSource("EmpleadosXS.xml");
            Result result = new StreamResult(fos);
            Transformer transformer= 
            TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos, result);
            fos.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }
    public void escribeXSTream(){
        try {
            XStream xstream= new XStream();
            xstream.alias("Alm_datosXS", Alm_datos.class);
            xstream.alias("EmpleadoXS", Empleado.class);
            Alm_datos listaemp = new Alm_datos(15);
            
            //en la listaemp se debe pasar un arraylist por lo que se usa el getDatos para pasar el atributo que tiene la propia clase.
            xstream.toXML(listaemp.getDatos(), new FileOutputStream("EmpleadosXS.xml"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
A