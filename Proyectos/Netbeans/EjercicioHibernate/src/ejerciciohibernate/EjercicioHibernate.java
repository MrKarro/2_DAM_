/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciohibernate;

import clases.SessionfactoryUtil;
import java.util.Scanner;
import org.hibernate.SessionFactory;


/**
 *
 * @author 6002755
 */
public class EjercicioHibernate {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        Modelo m = new Modelo();
        SessionFactory sesion = SessionfactoryUtil.getSessionFactory();
        int opcion;
        do{
            opcion = muestraMenu();
            switch (opcion) {
                case 01:
                    
                    m.insertaDepto(sesion);                    
                    break;
                case 02:
                    m.borraDepto(sesion);
                    break;
                case 03:
                    m.modificaDepto(sesion);

                    break;
                case 04:
                    m.muestraDepto(sesion);
                    
                    break;
                case 11:
                    m.insertaEmpleado(sesion);
                    break;
                case 12:
                    m.borraEmpleado(sesion);

                    break;
                case 13:
                    m.modificaEmpleado(sesion);
              
                    break;
                case 14:
                    m.muestraEmpleado(sesion);
                    
                    break;
                case 21:
                    m.empDepto(sesion);
                    
                    break;
                case 22:
                    m.listaDepto(sesion);
                    
                    break;
                case 23:
                    m.listaEmp(sesion);
                    break;
                case 31:
                    m.salariosDepto(sesion);
                    
                    break;
                case 32:
                    m.salariosEmpresa(sesion);
                    
                    break;
                case 41:
                    m.cargaTodo(sesion);
                    System.out.println("  Realizando Carga de Departamentos...");
                    break;
                case 42:
                    m.cargaTodo(sesion);
                    System.out.println("  Realizando Carga de Empleados...");
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        } while (opcion != 0);

        System.exit(0);
    }
    
    public static int muestraMenu(){
        System.out.println("Menú Principal");
        
        System.out.println("\n\n---Departamentos---");
        System.out.println("\t01. Alta");
        System.out.println("\t02. Baja");
        System.out.println("\t03. Modificación");
        System.out.println("\t04. Consulta (dado un departamento)");
        
        System.out.println("\n\n---Empleados---");
        System.out.println("\t11. Alta");
        System.out.println("\t12. Baja");
        System.out.println("\t13. Modificación");
        System.out.println("\t14. Consulta (dado un empleado)");
        
        System.out.println("\n\n---Listados---");
        System.out.println("\t21. Empleados de un Departamento (dado depto)");
        System.out.println("\t22. Departamentos");
        System.out.println("\t23. Empleados");
        
        System.out.println("\n\n---Consultas---");
        System.out.println("\t31. Media del salario, Salario máximo y Total de salarios (dado depto)");
        System.out.println("\t32. Media del salario, Salario máximo y Total de salarios de la empresa");
        
        System.out.println("\n\n---Añadir---");
        System.out.println("\t41. Cargar departamentos");
        System.out.println("\t42. Cargar empleados");
        
        System.out.println("\n\n---0. Salir---");
        
        System.out.println("\n\nIntroduce tu elección:");
        int elecc = teclado.nextInt();
        
        return elecc;

    }
    
}
