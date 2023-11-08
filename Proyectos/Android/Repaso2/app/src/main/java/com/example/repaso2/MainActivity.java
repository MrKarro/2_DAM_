package com.example.repaso2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] matriculas = {"1234ABC", "2345ASD", "3456QWE", "4567ZXC", "5678RTY"};
    String[] marcas = {"Mazda", "Opel", "Audi", "Peugeot", "Seat"};
    String[] modelos = {"RX5", "Corsa", "A1", "207", "Ibiza"};
    String[] colores = {"Blanco", "Negro", "Azul", "Verde", "Amarillo"};

    Coche[] coches;
    Spinner sp;
    TextView marca, modelo, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coches = creaCoches();
        sp = findViewById(R.id.spinner);
        marca = findViewById(R.id.marca);
        modelo = findViewById(R.id.modelo);
        color = findViewById(R.id.color);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, matriculas);

        sp.setAdapter(adaptador);
        sp.setOnItemSelectedListener(this);



    }

    private Coche[] creaCoches(){

        Coche[] coches = new Coche[matriculas.length];
        for(int i = 0; i< matriculas.length ; i++){
            coches[i] = new Coche(matriculas[i], marcas[i], modelos[i], colores[i]);
        }
        return coches;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        marca.setText(coches[i].getMarca());
        modelo.setText(coches[i].getModelo());
        color.setText(coches[i].getColor());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}