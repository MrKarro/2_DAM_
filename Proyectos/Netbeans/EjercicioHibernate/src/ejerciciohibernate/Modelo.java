/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciohibernate;

import clases.SessionfactoryUtil;
import entidades.Departamentos;
import entidades.Empleados;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 6002755
 */
public class Modelo {

    public void insertaDepto(SessionFactory sesion) {

        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Inserción de una fila en la tabla Departamentos.");
        Scanner scr = new Scanner(System.in);
        Departamentos depart = new Departamentos();
        System.out.println("Número departamento: ");
        depart.setDeptNo(Integer.parseInt(scr.nextLine()));
        System.out.println("Nombre departamento: ");
        depart.setDnombre(scr.nextLine());
        System.out.println("Localización: ");
        depart.setLoc(scr.nextLine());

        //Inserción de un departamento
        session.save(depart);
        tx.commit();
        session.close();
    }
    public void borraDepto(SessionFactory sesion){
        Departamentos dep = new Departamentos();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de departamento que quieres borrar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        dep= (Departamentos) session.get(Departamentos.class, num);
        if (dep==null)
            System.out.println("El departamento no existe");
        else {
            session.delete(dep);
        }
        tx.commit();
        session.close();
    }
    public void modificaDepto(SessionFactory sesion){
        Departamentos dep = new Departamentos();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de departamento que quieres modificar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        dep= (Departamentos) session.load(Departamentos.class, num);
        if (dep==null)
            System.out.println("El departamento no existe");
        else {
            System.out.println("Nombre departamento: ");
            dep.setDnombre(scr.nextLine());
            System.out.println("Localización: ");
            dep.setLoc(scr.nextLine());
            session.update(dep);

        }
        tx.commit();
        session.close();
    }
    
    public void muestraDepto(SessionFactory sesion){
        Departamentos dep = new Departamentos();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de departamento que quieres consultar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        dep= (Departamentos) session.get(Departamentos.class, num);
        if (dep==null)
            System.out.println("El departamento no existe");
        else {
            System.out.println("Depto.: "+dep.getDnombre());
            System.out.println("Localización: "+dep.getLoc());
        }
        tx.commit();
        session.close();

    }
    public void insertaEmpleado(SessionFactory sesion){
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Inserción de un empleado.");
        Scanner scr = new Scanner(System.in);
        Empleados emp = new Empleados();
        
        System.out.println("Introduce el número de empleado:");
        emp.setEmpNo(scr.nextInt());
        System.out.println("Número de departamento:");
        int numDepto = scr.nextByte();
        Departamentos dep = new Departamentos();
        emp.setDepartamentos((Departamentos) session.get(Departamentos.class, numDepto));
        
        System.out.println("Introduce el nombre:");
        emp.setApellido(scr.next());
        System.out.println("Introduce el oficio:");
        emp.setOficio(scr.next());
        System.out.println("Introduce dir:");
        emp.setDir(scr.nextInt());
       
        emp.setFechaAlta(Date.from(Instant.now()));
        System.out.println("Introduce salario:");
        emp.setSalario(scr.nextInt());
        System.out.println("Introduce comision:");
        emp.setSalario(scr.nextInt());
        

        //Inserción de un empleado
        session.save(emp);
        tx.commit();
        session.close();
    }
    public void borraEmpleado(SessionFactory sesion){
        Empleados emp = new Empleados();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de empleado que quieres borrar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        emp= (Empleados) session.get(Departamentos.class, num);
        if (emp==null)
            System.out.println("El empleado no existe");
        else {
            session.delete(emp);
        }
        tx.commit();
        session.close();
    }
    public void modificaEmpleado(SessionFactory sesion){
        Empleados emp = new Empleados();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de empleado que quieres modificar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        emp= (Empleados) session.load(Empleados.class, num);
        if (emp==null)
            System.out.println("El departamento no existe");
        else {
            System.out.println("Número de departamento:");
            int numDepto = scr.nextByte();
            Departamentos dep = new Departamentos();
            emp.setDepartamentos((Departamentos) session.get(Departamentos.class, numDepto));

            System.out.println("Introduce el nombre:");
            emp.setApellido(scr.next());
            System.out.println("Introduce el oficio:");
            emp.setOficio(scr.next());
            System.out.println("Introduce dir:");
            emp.setDir(scr.nextInt());

            emp.setFechaAlta(Date.from(Instant.now()));
            System.out.println("Introduce salario:");
            emp.setSalario(scr.nextInt());
            System.out.println("Introduce comision:");
            emp.setSalario(scr.nextInt());
            session.update(emp);

        }
        tx.commit();
        session.close();
    }
    public void muestraEmpleado(SessionFactory sesion){
        Empleados emp = new Empleados();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Introduce el numero de empleado que quieres mostrar:");
        Scanner scr = new Scanner(System.in);
        int num = scr.nextByte();
        
        emp= (Empleados) session.load(Empleados.class, num);
        if (emp==null)
            System.out.println("El departamento no existe");
        else {
            System.out.println(emp);

        }
        tx.commit();
        session.close();
    }

    public void empDepto(SessionFactory sesion) {
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Empleados de un Departamento.");
        Departamentos dep = new Departamentos();
        Scanner scr = new Scanner(System.in);
        System.out.println("Número departamento: ");
        int depto = scr.nextByte();
        dep = (Departamentos) session.get(Departamentos.class, depto);
        if (dep == null) {
            System.out.println("Ese departamento NO existe...");
        } else {
            Set<Empleados> listaempleados = dep.getEmpleadoses();
            Iterator<Empleados> it = listaempleados.iterator();
            while (it.hasNext()) {
                Empleados empl = new Empleados();
                empl = it.next();
                System.out.println(empl);
            }
        }
        tx.commit();
        session.close();
    }
    public void listaDepto(SessionFactory sesion){
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q= session.createQuery("from Departamentos");
        List <Departamentos> lista= q.list();
        Iterator<Departamentos> it= q.iterate();
        while (it.hasNext()) {
            Departamentos dep = new Departamentos();
            dep = it.next();
            System.out.println(dep);
        }
        
        tx.commit();
        session.close();
    }
    public void listaEmp(SessionFactory sesion){
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q= session.createQuery("from Empleados");
        List <Empleados> lista= q.list();
        Iterator<Empleados> it= q.iterate();
        while (it.hasNext()) {
            Empleados emp = new Empleados();
            emp = it.next();
            System.out.println(emp);
        }
        
        tx.commit();
        session.close();
    }
    
    public void salariosDepto(SessionFactory sesion){
        Session session = sesion.openSession();
        Scanner scr = new Scanner(System.in);
        System.out.println("Introduce el número de departamento:");
        int num = scr.nextInt();
        
        Query q= session.createQuery("select avg(e.salario) as media, max(e.salario) as max, sum(e.salario) as suma\n" +
"from Empleados as e \n" +
"where e.departamentos.deptNo = " + num);
        Object[] string = (Object[]) q.uniqueResult();
        System.out.println("Media de salario: " + string[0]);
        System.out.println("Maximo salario: " + string[1]);
        System.out.println("Suma de salarios: " + string[2]);
        
        
        session.close();
    }
    public void salariosEmpresa(SessionFactory sesion){
        Session session = sesion.openSession();
        
        
        Query q= session.createQuery("select avg(e.salario) as media, max(e.salario) as max, sum(e.salario) as suma\n" +
"from Empleados as e");
        Object[] string = (Object[]) q.uniqueResult();
        System.out.println("Media de salario: " + string[0]);
        System.out.println("Maximo salario: " + string[1]);
        System.out.println("Suma de salarios: " + string[2]);
        
        
        session.close();
    }
    
    
    
    
    public void cargaTodo(SessionFactory sesion){
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q= session.createQuery("delete from Empleados");
        q.executeUpdate();
        q= session.createQuery("delete from Departamentos");
        q.executeUpdate();
        q = session.createQuery("insert into Departamentos (deptNo, dnombre, loc)"
                + "select d.deptNo, d.dnombre, d.loc from Auxdept as d");
        q.executeUpdate();
        
        
        q = session.createQuery("insert into Empleados (empNo, apellido, oficio, dir, fechaAlta, salario, comision, departamentos) "
            + "select a.empNo, a.apellido, a.oficio, a.dir, a.fechaAlta, a.salario, a.comision, d "
            + "from Auxemp as a, Departamentos as d "
            + "where a.auxdept.deptNo = d.deptNo");
        q.executeUpdate();
        
        
        tx.commit();
        session.close();
        
    }

}
