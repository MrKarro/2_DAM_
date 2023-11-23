/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XStream;

import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import modelo.Ciclo;
import modelo.Informatica;
import modelo.Modulo;

/**
 *
 * @author 6002755
 */
public class Serializacion {
    
    public static void escribeXStream(Informatica inf) throws FileNotFoundException{
        XStream xstream= new XStream();
        
        xstream.alias("InformaticaXS", Informatica.class);
        xstream.alias("CicloXS", Ciclo.class);
        xstream.alias("ModuloXS", Modulo.class);
        
        xstream.toXML(inf, new FileOutputStream("informaticaXST.xml"));

        
        

        
        
    }
    
}
