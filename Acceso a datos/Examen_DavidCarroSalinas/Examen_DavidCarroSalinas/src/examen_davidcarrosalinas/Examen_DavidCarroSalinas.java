/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_davidcarrosalinas;

import clases.Clientes;
import clases.Detallepedidos;
import clases.Pedidos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Alumno
 */
public class Examen_DavidCarroSalinas {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    SessionFactoryUtil ses = new SessionFactoryUtil();
    public static void main(String[] args) {
        SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
        
        String recib;
        do{
            recib = muestraMenu();
            switch (recib){
                case "1":
                    mostrarPedido(sesion);
                    break;

                case "2":
                    altaPedido(sesion);
                    break;

                case "9":
                    System.out.println("Saliendo del programa.");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida");


            }
        
        } while (!recib.equals("9"));
        
    }
    
    public static String muestraMenu(){
        System.out.println("============================");
        System.out.println("1- Mostrar pedido.");
        System.out.println("2- Alta pedido.");
        System.out.println("9- Salir.");
        System.out.println("============================");
        System.out.println("Introduce la opción:");
        String recib = teclado.next();
        return recib;
        
    }
    
    
    public static void mostrarPedido(SessionFactory sesion){
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Información de pedido.");
        Pedidos ped = new Pedidos();
        System.out.println("Número pedido: ");
        int pedido = teclado.nextInt();
        ped = (Pedidos) session.get(Pedidos.class, pedido);
        
        if (ped == null) {
            System.out.println("Ese pedido NO existe...");
        } else {
            System.out.println("Datos de pedido:");
            System.out.println(ped);
            System.out.println("Datos de cliente: ");
            System.out.println(ped.getClientes());
            

            Query q= session.createQuery("from Detallepedidos where CodigoPedido = " + ped.getCodigoPedido());
            
            Detallepedidos detall = new Detallepedidos();
            List<Detallepedidos> lista = q.list();
            Iterator <Detallepedidos> iter= lista.iterator();
            System.out.println("Detalles de pedido: ");
            System.out.println(detall);
            System.out.println("Datos de productos: ");
            while (iter.hasNext()) {
                detall = (Detallepedidos) iter.next();
                System.out.println(detall.getProductos());
            }
        }
        tx.commit();
        session.close();

        
    }
    public static void altaPedido(SessionFactory sesion){
        try {
            Session session = sesion.openSession();
            Transaction tx = session.beginTransaction();
            Pedidos ped = new Pedidos();
            System.out.println("Introduce la información del pedido a insertar:.");
            
            System.out.println("Introduce código de pedido:");
            
            int codigoPedido = teclado.nextInt();
            if (((Pedidos) session.get(Pedidos.class, codigoPedido)) != null){
                System.out.println("El id ya existe.");
                return;
            }
            
            
            System.out.println("Introduce código de cliente:");
            
            int codigoCliente = teclado.nextInt();
            
            Clientes cliente = (Clientes) session.get(Clientes.class, codigoCliente);
            
            
            
            System.out.println("Introduce dia:");
            String dia = teclado.next();
            System.out.println("Introduce mes:");
            String mes = teclado.next();
            System.out.println("Introduce año:");
            String anho = teclado.next();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fec = dia + "/" + mes + "/" + anho ;
            Date fechaPedido = sdf.parse(fec);
            Date fechaEsperada = sdf.parse(fec);
            Date fechaEntrega = sdf.parse(fec);
            System.out.println("Introduce estado:");
            String estado = teclado.next();
            System.out.println("Introduce comentario:");
            String comentarios = teclado.next();
            
            ped.setCodigoPedido(codigoPedido);
            ped.setClientes(cliente);
            ped.setComentarios(comentarios);
            ped.setEstado(estado);
            ped.setFechaPedido(fechaPedido);
            ped.setFechaEsperada(fechaEsperada);
            ped.setFechaEntrega(fechaEntrega);
            session.save(ped);
        
            tx.commit();
            session.close();
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Examen_DavidCarroSalinas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
    }
    
}
