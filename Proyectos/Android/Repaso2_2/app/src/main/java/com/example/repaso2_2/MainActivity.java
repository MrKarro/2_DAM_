package com.example.repaso2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] matriculas = {"1234ABC", "2345ASD", "3456QWE", "4567ZXC", "5678RTY"};
    String[] marcas = {"Mazda", "Opel", "Audi", "Peugeot", "Seat"};
    String[] modelos = {"RX5", "Corsa", "A1", "207", "Ibiza"};
    String[] colores = {"Blanco", "Negro", "Azul", "Verde", "Amarillo"};

    Coche[] coches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coches = creaCoches();


    }
    private Coche[] creaCoches(){

        Coche[] coches = new Coche[matriculas.length];
        for(int i = 0; i< matriculas.length ; i++){
            coches[i] = new Coche(matriculas[i], marcas[i], modelos[i], colores[i]);
        }
        return coches;
    }
}