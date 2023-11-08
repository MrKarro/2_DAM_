/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestempl;

import java.text.ParseException;
import java.util.Scanner;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Carlos
 */
public class GestEmplMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Vista v = new Vista();
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        String menu = "1. Mostrar empleados\n"
                + "2. Generar empleados aleatorios\n"
                + "3. Escribir DOM\n"
                + "4. Leer DOM\n"
                + "5. Escribir SAX\n"
                + "6. leer SAX\n"
                + "7. Escribir XStream\n"
                + "8. leer XTream/ Generar HTML\n"
                + "q. Salir\n";
        String opcion;
        do {
            System.out.print(menu);
            opcion = sc.nextLine();
            switch (opcion.toLowerCase()) {
                case "1":
                case "mostrar empleados":
                case "mostrar":
                    v.mostrarEmpleados();
                    break;
                case "2":
                case "generar aleatorios":
                case "generar":
                case "aleatorios":
                    v.cargar_aleatorios();
                    break;
                case "3":
                case "escribir":
                case "escribir dom":
                    v.escribeDom();
                    break;
                case "4":
                case "leer dom":
                    v.leerDom();
                    break;
                case "5":
                case "escribir sax":
                    v.escribeSax();
                    break;
                case "6":
                case "leer sax":
                    v.leerSax();
                    break;
                case "7":
                case "escribir xtream":
                    v.escribeXSTream();
                    break;
                case "8":
                case "leer xtream":
                    v.leerXSTream();
                    break;
                case "salir":
                case "q":
                    salir = true;
                    break;
                default:
                    System.err.printf("%nOpciÃ³n incorrecta%n%n");
                    break;
            } // fin de switch
        } while (!salir);
    }

}
