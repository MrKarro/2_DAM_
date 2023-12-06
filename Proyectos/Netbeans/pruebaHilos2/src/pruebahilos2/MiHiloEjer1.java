/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebahilos2;

/**
 *
 * @author 6002755
 */
public class MiHiloEjer1 extends Thread {
    private String nombre;
    private String tipo; 

    public MiHiloEjer1(String nombre, String tipo) {
        setName(nombre);
        this.tipo = tipo;
    }

    
    
    @Override
    public void run() {
        if (tipo.equals("1")){
            for (int i = 1; i<= 30; i++){
                System.out.println(i);
            }
        } else if (tipo.equals("2")){
            for (char a = 'a' ; a<='z'; a++){
                
                System.out.println(a);
            }
        }
    }
}
