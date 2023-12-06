/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebahilos;

/**
 *
 * @author 6002755
 */
public class MiHiloEjer1 extends Thread {
    private String nombre;
    private int veces; 

    MiHiloEjer1(String nombre, int veces){
        setName(nombre);
        this.veces = veces;
    }
    
    @Override
    public void run() {
        for (int i = 0 ; i < veces; i++){
            System.out.println("Hola soy " + getName() + " con id " + getId() + ", prioridad " + getPriority() + " y en mi grupo hay " + activeCount() + " hilos.");
        }
    }
}
