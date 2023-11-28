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
            System.out.println("Hola soy " + nombre + " con id " + getId() + ", prioridad " + getPriority() + " y en mi grupo hay " + activeCount() + " hilos.");
        }
    }
}
