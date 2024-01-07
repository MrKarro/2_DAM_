/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9hilos;

/**
 *
 * @author 6002755
 */
public class Ejercicio9Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(40);
        
        MiHiloEjer9 h1 = new MiHiloEjer9("David", cuenta);
        MiHiloEjer9 h2 = new MiHiloEjer9("Carro", cuenta);
        
        h1.start();
        h2.start();
        
        
        
    }
    
}
