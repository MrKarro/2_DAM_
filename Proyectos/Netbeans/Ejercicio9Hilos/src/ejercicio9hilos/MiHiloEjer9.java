/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9hilos;



/**
 *
 * @author 6002755
 */
public class MiHiloEjer9 extends Thread {
    
    private String nombre;
    private Cuenta cuenta;

    public MiHiloEjer9(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i< 4; i++){
            //synchronized (cuenta) {
                cuenta.retirarDinero(this.nombre, 10);
            //}
            
            
        }
    }
    
    
    
}
