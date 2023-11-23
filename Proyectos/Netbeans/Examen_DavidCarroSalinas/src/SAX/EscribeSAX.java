/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SAX;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import modelo.Informatica;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author 6002755
 */
public class EscribeSAX {
    
    public static void escribeSAX(Informatica inf) throws TransformerConfigurationException, TransformerException{
        XMLReader datosReader = new DatosReader();
        InputSource datosSource = inf; 
        Source source = new SAXSource(datosReader, datosSource);
        
        File f = new File("informaticaSAX.xml");
        Result resultado = new StreamResult(f);
        
        Transformer transformer = 
        TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        
        transformer.transform(source, resultado);
        
        
    }
    
    
}
