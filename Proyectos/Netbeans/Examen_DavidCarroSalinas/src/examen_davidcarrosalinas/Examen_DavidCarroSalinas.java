/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_davidcarrosalinas;

import DOM.LeeDOM;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;
import modelo.Informatica;
import vista.Vista;

/**
 *
 * @author 6002755
 */
public class Examen_DavidCarroSalinas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        try {
            // TODO code application logic here
            
            Vista v = new Vista();
            Informatica inf = null;
            int elecc;
            do{
            elecc = v.muestraMenu();
            
            switch (elecc){
                case 1:
                    v.muestraAlineado(inf);
                    break;
                    
                case 2:
                    v.escribeDelimitado(inf);
                    break;
                    
                case 3:
                    v.escribeEncolumnado(inf);
                    break;
                    
                case 4:
                    v.escribeBinario(inf);
                    break;
                    
                case 5:
                    inf = v.leeBinario();
                    break;
                    
                case 6:
                    inf = v.leerDOM();
                    break;
                    
                case 7:
                    v.escribeSAX(inf);
                    break;
                    
                case 8:
                    v.escribeXStream(inf); 
                    break;
                    
                    
                case 9:
                    v.conexionBD(inf);
                    break;
                    
                case 10:
                
                    break;
                    
                default:
                    
                    System.out.println("Entrada inválida.");
                    break;
            }
            
            } while (elecc != 10);
        } catch (ParseException ex) {
            Logger.getLogger(Examen_DavidCarroSalinas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Examen_DavidCarroSalinas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Examen_DavidCarroSalinas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
}
