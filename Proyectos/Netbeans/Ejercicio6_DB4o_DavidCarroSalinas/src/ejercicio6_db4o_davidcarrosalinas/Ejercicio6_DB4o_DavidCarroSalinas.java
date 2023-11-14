/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6_db4o_davidcarrosalinas;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author 6002755
 */
public class Ejercicio6_DB4o_DavidCarroSalinas {

    /**
     * @param args the command line arguments
     */
    
    static Scanner teclado = new Scanner(System.in);
    static String rutaBD = "./prueba";
    static ObjectContainer bd;
    
    static LocalDate valorMin = LocalDate.of(1980,1,1);
    static LocalDate valorMax = LocalDate.of(1990,1,1);
    
    
    public static void main(String[] args) {
        
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutaBD);
        
        int selec;
        do{
            selec = muestraMenu();
        
        
            switch (selec){
                case 1:
                    creaBD();
                    break;
                case 2:
                    muestraDpto();
                    break;
                case 3:
                    muestraEmp();
                    break;
                case 4:
                    muestraVentas();
                    break;
                case 5:
                    muestraNacidos();
                    break;
                case 6:
                    muestraDptoSalario();
                    break;
                case 7:
                    insertarEmpleado();
                    break;
                case 8:
                    modificarEmpleado();
                    break;
                case 9:
                    borrarEmpleado();
                    break;
                case 10:

                    break;
                default:
                    System.out.println("Ha introducido un valor erroneo");
                    break;
            }
        } while (selec != 10);
        bd.close();
    }
    
    public static int muestraMenu(){
        System.out.println("_______________________");
        System.out.println("_______________________");
        System.out.println("1. Crear base de datos");
        System.out.println("2. Mostrar datos de departamentos");
        System.out.println("3. Mostrar datos de empleados");
        System.out.println("4. Mostrar datos de empleados de ventas");
        System.out.println("5. Mostrar datos de empleados contratados entre 1980 y 1990");
        System.out.println("6. Mostrar nombre de departamento y la suma de sus salarios");
        System.out.println("7. Insertar un nuevo empleado.");
        System.out.println("8. Modificar un empleado.");
        System.out.println("9. Borrar un empleado.");
        System.out.println("10. Salir.");        
        System.out.println("_______________________");
        System.out.println("_______________________");
        
        int eleccion = teclado.nextInt();
        return eleccion;
    }
    public static void creaBD(){
        Empleado e1  = new Empleado(1, "López", "contable", 345, LocalDate.of(1987,10,23), 23400.32f, 5.34f, 10);
        Empleado e2 = new Empleado(2, "Alonso", "contable", 346, LocalDate.of(11994,12,23), 20400.32f, 3.34f, 10);
        Empleado e3 = new Empleado(3, "Santana", "contable", 345, LocalDate.of(1980, 9, 23), 33670.20f, 8.84f, 10);
        Empleado e4 = new Empleado(4, "Gil", "investigad", 245,LocalDate.of(1987,01,23) , 23400.32f, 5.34f, 20);
        Departamento d1 = new Departamento(10, "CONTABILIDAD", "SEVILLA");
        Departamento d2 = new Departamento(20, "INVESTIGACIÓN", "MADRID");
        Departamento d3 = new Departamento(30, "VENTAS", "BARCELONA");
        Departamento d4 = new Departamento(40, "PRODUCCIÓN", "BILBAO");
        
        bd.store(e1); 
        bd.store(e2);
        bd.store(e3);
        bd.store(e4);
        bd.store(d1); 
        bd.store(d2);
        bd.store(d3);
        bd.store(d4);
        
    }
    public static void muestraDpto(){
        Departamento per = new Departamento(0, null, null);
        ObjectSet<Departamento> result = bd.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de departamentos..");
        else {
            System.out.printf("Número de registros: %d %n", 
            result.size());
            while (result.hasNext()) {
                Departamento p = result.next();
                System.out.printf("Numero departamento: %s, Nombre: %s, Localización: %s %n", 
                p.getDept_no(), p.getDnombre(), p.getLoc());
            }
        }
    }
    public static void muestraEmp(){
        
        
        Empleado per = new Empleado(0, null, null, 0, null, 0, 0,0);
        ObjectSet<Empleado> result = bd.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de Empleados..");
        else {
            System.out.printf("Número de registros: %d %n", 
            result.size());
            while (result.hasNext()) {
                Empleado p = result.next();
                System.out.printf("Numero empleado: %s, Nombre: %s %n", 
                p.getEmp_no(), p.getApellido());
            }
        }
    }
    
    public static void muestraVentas(){
        
        Empleado per = new Empleado(0, null, null, 0, null, 0, 0,30);
        ObjectSet<Empleado> result = bd.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de Empleados..");
        else {
            System.out.printf("Número de registros: %d %n", 
            result.size());
            while (result.hasNext()) {
                Empleado p = result.next();
                System.out.printf("Numero empleado: %s, Nombre: %s %n", 
                p.getEmp_no(), p.getApellido());
            }
        }
        
    }
    public static void muestraNacidos(){
        ObjectSet<Empleado> lista = bd.query(new Predicate<Empleado> () {
            
                @Override
                public boolean match (Empleado e) {
                    try{
                    
                        return e.getFecha_alt().isAfter(valorMin) &&
                               e.getFecha_alt().isBefore(valorMax);
                    
                    }catch(Exception ex){

                    }
                    return true;
                }
            });
        
        System.out.println("\n\nEMPLEADOS DADOS DE ALTA ENTRE 1980 Y 1990: \n");
        while (lista.hasNext())
            System.out.println("Empleado: "+((Empleado)lista.next()).getApellido());
    }
    public static void muestraDptoSalario(){
        
        Departamento per = new Departamento(0, null, null);
        ObjectSet<Departamento> result = bd.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de departamentos..");
        else {
            
            while (result.hasNext()) {
                Departamento p = result.next();
                
                Empleado per2 = new Empleado(0, null, null, 0, null, 0, 0,p.getDept_no());
                ObjectSet<Empleado> result2 = bd.queryByExample(per2);
                double suma = 0;
                if (result.size() == 0)
                    System.out.println("No existen Registros de Empleados..");
                else {
                    while (result2.hasNext()) {
                        
                        Empleado p2 = result2.next();
                        System.out.printf("\tNumero empleado: %s, Nombre: %s %n", 
                        p2.getEmp_no(), p2.getApellido());
                        suma += p2.getSalario();
                        
                    }
                }
                
                System.out.printf("Numero departamento: %s, Nombre: %s, Localización: %s, Salario total: %s %n", 
                p.getDept_no(), p.getDnombre(), p.getLoc(), suma);
                
            }
        }

    }
    
    public static void insertarEmpleado(){
        
        
        System.out.println("\n\nIntroduce los datos del nuevo empleado: ");
        System.out.println("Id:");
        int emp_no = teclado.nextInt();
        System.out.println("Nombre completo:");
        String apellido = teclado.next();
        System.out.println("Oficio:");
        String oficio = teclado.next();
        System.out.println("Dir:");
        int dir = teclado.nextInt();
        System.out.println("Año de incorporación:");
        int year = teclado.nextInt();
        System.out.println("Mes de incorporación:");
        int month = teclado.nextInt();
        System.out.println("Dia de incorporación:");
        int day = teclado.nextInt();
        LocalDate fecha_alt = LocalDate.of(year, month, day);
        System.out.println("Salario:");
        float salario = teclado.nextFloat();
        System.out.println("Comisión:");
        float comision = teclado.nextFloat();
        System.out.println("Numero depto:");
        int dept_no = teclado.nextInt();
        
        Empleado e = new Empleado(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);
        
        bd.store(e);
    }
    
    public static void modificarEmpleado(){
        System.out.println("Introduce el id del empleado a modificar:");
        int id = teclado.nextInt();
        Empleado modif =new Empleado();
        
        Empleado per = new Empleado(id, null, null, 0, null, 0, 0,0);
        ObjectSet<Empleado> result = bd.queryByExample(per);
        
        if (result.size() == 0)
            System.out.println("No existen Registros de Empleados..");
        else { 
            while (result.hasNext()) {
                modif = result.next();
            }
        }
        
        System.out.println("\n\nIntroduce los datos modificados: ");
        System.out.println("Nombre completo:");
        modif.setApellido(teclado.next()); 
        System.out.println("Oficio:");
        modif.setOficio(teclado.next()); 
        System.out.println("Dir:");
        int dir = teclado.nextInt();
        System.out.println("Año de incorporación:");
        int year = teclado.nextInt();
        System.out.println("Mes de incorporación:");
        int month = teclado.nextInt();
        System.out.println("Dia de incorporación:");
        int day = teclado.nextInt();
        modif.setFecha_alt( LocalDate.of(year, month, day));
        System.out.println("Salario:");
        modif.setSalario(teclado.nextFloat());
        System.out.println("Comisión:");
        modif.setComision(teclado.nextFloat());
        System.out.println("Numero depto:");
        modif.setDept_no(teclado.nextInt());
        
        bd.store(modif);
    }
    
    public static void borrarEmpleado(){
        System.out.println("Introduce el id del empleado a borrar:");
        int id = teclado.nextInt();
        Empleado modif =new Empleado();
        
        Empleado per = new Empleado(id, null, null, 0, null, 0, 0,0);
        ObjectSet<Empleado> result = bd.queryByExample(per);
        
        if (result.size() == 0)
            System.out.println("No existen Registros de Empleados..");
        else { 
            
            Empleado borrar = result.next();
            bd.delete(borrar);
            
        }
    }
}
    

