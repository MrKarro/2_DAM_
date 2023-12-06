/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebahilos2;

/**
 *
 * @author 6002755
 */
public class PruebaHilos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MiHiloEjer1 t1 = new MiHiloEjer1("Tipo 1", "1");
        MiHiloEjer1 t2 = new MiHiloEjer1("Tipo 2", "2");
        
        t1.start();
        t2.start();
    }
    
}
