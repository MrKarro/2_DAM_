import java.util.ArrayList;

/**
 * Ejercicio1
 */
import java.util.Random;
public class Ejercicio1 {

    public static void main(String[] args) {
        ArrayList<MiHiloEjer1> lista = new ArrayList<>();
        Random aleat = new Random();
        for (int i = 0 ; i < 10; i++){
            String nombre = "Hilo "+ (i+1);
            lista.add(new MiHiloEjer1(nombre, aleat.nextInt(10)));
        }
    }
}