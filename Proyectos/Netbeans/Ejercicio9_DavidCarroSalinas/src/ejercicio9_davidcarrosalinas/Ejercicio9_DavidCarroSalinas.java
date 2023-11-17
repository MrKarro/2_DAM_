/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9_davidcarrosalinas;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6002755
 */
public class Ejercicio9_DavidCarroSalinas {

    static Scanner teclado = new Scanner(System.in);
    static Statement st = null;
    static Connection connection;
    
    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "123456");
            st = connection.createStatement();
            int selec;
            do{
                selec = muestraMenu();

                switch (selec){
                    case 1:
                        creaTablaDpto();
                        break;

                    case 2:
                        borraTablaDpto();
                        break;

                    case 3:
                        creaTablaEmp();
                        break;

                    case 4:
                        borraTablaEmp();
                        break;
                    case 5:
                        creaDpto();
                        break;

                    case 6:
                        borraDpto();
                        break;

                    case 7:
                        modificaDpto();
                        break;
                    case 8:
                        creaDpto();
                        break;

                    case 9:
                        borraDpto();
                        break;

                    case 10:
                        modificaDpto();
                        break;
                    case 11:
                        muestraMetadata();
                        break;
                        
                    case 12:
                        break;
                        
                   
                    default:
                        System.out.println("No ha introducido un valor correcto.");

                }
            
            } while (selec != 12);
            
            
            
            
        } catch (SQLException ex) {
             Logger.getLogger(Ejercicio9_DavidCarroSalinas.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
    }
    
    public static int muestraMenu(){
        System.out.println("------------------");
        System.out.println("1. Crear tabla departamento");
        System.out.println("2. Borra tabla departamento");
        System.out.println("3. Crear tabla empleado");
        System.out.println("4. Borra tabla empleado");
        System.out.println("5. Crear departamento");
        System.out.println("6. Borra departamento");
        System.out.println("7. Modifica departamento");
        System.out.println("8. Crear empleado");
        System.out.println("9. Borra empleado");
        System.out.println("10. Modifica empleado");
        System.out.println("11. Muestra datos de BD, tablas y columnas");
        System.out.println("12. Salir del programa");        
        System.out.println("----------------");
        System.out.println("Introduce una opcion: ");
        int selec = teclado.nextInt();
        return selec;
    
    }
    
    
    
    public static void creaTablaDpto() throws SQLException{
        int fil = st.executeUpdate("CREATE TABLE departamentos ( dept_no int primary key, dnombre VARCHAR(15), loc VARCHAR(15));");
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido crear.");
    }
    public static void borraTablaDpto() throws SQLException{
        int fil = st.executeUpdate("DROP TABLE departamentos;");
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido borrar.");
    }
    
    public static void creaTablaEmp() throws SQLException{
        int fil = st.executeUpdate("create table  empleados (\n" +
                                "    emp_no int primary key,\n" +
                                "    apellido VARCHAR(10),\n" +
                                "    oficio VARCHAR(10),\n" +
                                "    dir int,\n" +
                                "    fecha_alta DATE,\n" +
                                "    salario int,\n" +
                                "    comision int,\n" +
                                "    dept_no int, \n" +
                                "    foreign key (dept_no) references departamentos (dept_no)\n" +
                                ");");
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido crear.");
    }
    
    public static void borraTablaEmp() throws SQLException{
        int fil = st.executeUpdate("DROP TABLE empleados;");
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido borrar.");
    }
    public static void creaDpto() throws SQLException{
        String[] datos = datosDpto();
        
        if (existeDpto(Integer.parseInt(datos[0] ))){
            System.out.println("El departamento ya existe.");
            return;
        } else {
        
            String sentencia = "INSERT INTO departamentos VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sentencia, datos);
            int fil = ps.executeUpdate();
            if (fil != 0)
                System.out.println("Se han modificado " + fil + " filas.");
            else
                System.out.println("No se ha podido crear.");   
        }
        
    }
    public static void borraDpto() throws SQLException{
        System.out.println("Introduce número de departamento:");
        int num = teclado.nextInt();
        int fil = st.executeUpdate("DELETE FROM departamentos WHERE dept_no = " + num);
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido borrar.");

    }
    public static void modificaDpto() throws SQLException{
        System.out.println("Introduce número de departamento a modificar:");
        int num = teclado.nextInt();
        String[] datos = new String[3];
        datos[2] = String.valueOf(num);
        System.out.println("Introduce nuevo nombre de departamento:");
        datos[0] = teclado.next();
        System.out.println("Introduce nueva localización de departamento:");
        datos[1] = teclado.next();
        
        
        String sentencia = "UPDATE departamentos SET dnombre = ?, loc = ? WHERE dpto_no = ? ";
        PreparedStatement ps = connection.prepareStatement(sentencia, datos);
        int fil = ps.executeUpdate();
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido crear.");
        
    }
    public static void creaEmp() throws SQLException{
        String[] datos = datosEmp();
        
        if (!existeDpto(Integer.parseInt(datos[7] ))){
            System.out.println("El departamento no existe.");
            return;
        } else {
        
            String sentencia = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sentencia, datos);
            int fil = ps.executeUpdate();
            if (fil != 0)
                System.out.println("Se han modificado " + fil + " filas.");
            else
                System.out.println("No se ha podido crear.");   
        }
    }
    public static void borraEmp() throws SQLException{
        System.out.println("Introduce número de empleado:");
        int num = teclado.nextInt();
        int fil = st.executeUpdate("DELETE FROM empleados WHERE dept_no = " + num);
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido borrar.");
    }
    public static void modificaEmp() throws SQLException{
        System.out.println("Introduce número de empleado a modificar:");
        int num = teclado.nextInt();
        String[] datos = new String[8];
        datos[7] = String.valueOf(num);
        
        System.out.println("Introduce nombre del empleado:");
        datos[0] = teclado.next();
        System.out.println("Introduce oficio de empleado:");
        datos[1] = teclado.next();
        System.out.println("Introduce dir de empleado: ");
        datos[2] = String.valueOf(teclado.nextInt());
        
        datos[3] = LocalDate.now().toString();
        System.out.println("Introduce salario de departamento:");
        datos[4] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce comisión de empleado: ");
        datos[5] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce numero de departamento:");
        datos[6] = String.valueOf(teclado.nextInt());
       
        String sentencia = "UPDATE departamentos SET apellido = ?, oficio = ?, dir = ?, fecha_alta = ?, salario = ?, comision = ?, dept_no = ? WHERE emp_no = ? ";
        PreparedStatement ps = connection.prepareStatement(sentencia, datos);
        int fil = ps.executeUpdate();
        if (fil != 0)
            System.out.println("Se han modificado " + fil + " filas.");
        else
            System.out.println("No se ha podido crear.");
        
        
    }
    
    public static void muestraMetadata() throws SQLException{
        
        DatabaseMetaData dbmd=connection.getMetaData();
        ResultSet result = null;
        String nombre= dbmd.getDatabaseProductName();
        String driver= dbmd.getDriverName();
        String url= dbmd.getURL();
        String usuario= dbmd.getUserName();
        
        
        System.out.println("\n\nINFORMACIÓN BASE DATOS");
        System.out.println("Nombre: "+nombre);
        System.out.println("Driver: "+driver);
        System.out.println("URL: "+url);
        System.out.println("Usuario: "+usuario);
        
        ArrayList<String> lista = new ArrayList<>();
        // información sobre tablas y vistas
        result= dbmd.getTables(null, "prueba", null, null);
        
        System.out.println("\n\nINFORMACIÓN SOBRE TABLAS:");
        while (result.next()){
            String catalogo= result.getString(1);
            String esquema= result.getString(2);
            String tabla= result.getString(3);
            String tipo= result.getString(4);
            
            if (tipo.equalsIgnoreCase("table") && !tabla.equals("sys_config")){
                
                System.out.println(tipo + " - Catálogo: "+ catalogo+
            ", Esquema: "+esquema+", Nombre: "+tabla);
                lista.add(tabla);
                
                
            }
        
        }
        
        
        ResultSet columnas=null;
        System.out.println("\n\nINFORMACIÓN SOBRE COLUMNAS:");
        for (String tabla : lista){
            columnas= dbmd.getColumns(null, "prueba", tabla , null);
            while (columnas.next()){
                String name= columnas.getString("TABLE_NAME"); //getString(3);
                String nombreCol= columnas.getString("COLUMN_NAME"); //getString(4);
                String tipoCol= columnas.getString("TYPE_NAME"); //getString(6);
                String tamCol= columnas.getString("COLUMN_SIZE"); //getString(7);
                String nula= columnas.getString("IS_NULLABLE"); //getString(18);
                System.out.println("Tabla: "+name+" Columna: "+nombreCol+", Tipo: "+ 
                tipoCol + ", Tamaño: "+tamCol+", ¿Es nula?: "+ nula);
            }
        }
    }

    
    public static String[] datosDpto(){
        String[] datos = new String[3];
        
        System.out.println("Introduce número de departamento:");
        datos[0] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce nombre de departamento:");
        datos[1] = teclado.next();
        System.out.println("Introduce localización de departamento:");
        datos[2] = teclado.next();
        return datos;
    }
    
    public static boolean existeDpto(int num) throws SQLException{
        ResultSet rs = st.executeQuery("SELECT dept_no FROM departamentos");
        while(rs.next()){
            if ( num == (int)rs.getObject(1)){
                return true;
            }
        }
        return false;
        
    }
    
    public static String[] datosEmp(){
        String[] datos = new String[8];
        
        System.out.println("Introduce número de empleado: ");
        datos[0] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce nombre del empleado:");
        datos[1] = teclado.next();
        System.out.println("Introduce oficio de empleado:");
        datos[2] = teclado.next();
        System.out.println("Introduce dir de empleado: ");
        datos[3] = String.valueOf(teclado.nextInt());
        
        datos[4] = LocalDate.now().toString();
        System.out.println("Introduce salario de departamento:");
        datos[5] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce comisión de empleado: ");
        datos[6] = String.valueOf(teclado.nextInt());
        System.out.println("Introduce numero de departamento:");
        datos[7] = String.valueOf(teclado.nextInt());
        
        
        
        return datos;
    }
    
        
        
    
    
    
}
