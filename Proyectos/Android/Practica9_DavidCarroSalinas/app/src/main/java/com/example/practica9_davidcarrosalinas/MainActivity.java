package com.example.practica9_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {

    String[] arrayMarcas = {"Audi", "Peugeot", "Seat"};
    String[] arrayColores = {"Azul", "Blanco", "Negro", "Verde", "Rojo"};
    Spinner marcas, modelos;

    ListView colores;
    Button enviar;
    String colorSeleccionado;

    ArrayAdapter<CharSequence> adaptadorModelos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marcas = findViewById(R.id.marcas);
        modelos = findViewById(R.id.modelos);
        colores = findViewById(R.id.colores);
        enviar = findViewById(R.id.enviar);
        enviar.setEnabled(false);


        ArrayAdapter<String> adaptadorMarcas = new ArrayAdapter<String>(this, R.layout.itemmarcas, arrayMarcas);
        marcas.setAdapter(adaptadorMarcas);

        ArrayAdapter<String> adaptadorColores = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arrayColores);
        colores.setAdapter(adaptadorColores);

        marcas.setOnItemSelectedListener(this);
        modelos.setOnItemSelectedListener(this);
        colores.setOnItemClickListener(this);
        enviar.setOnClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        enviar.setEnabled(true);
        colorSeleccionado = arrayColores[i];
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.marcas){
            switch (i){
                case 0:
                    adaptadorModelos = ArrayAdapter.createFromResource(this, R.array.modeloAudi, R.layout.itemmodelo);
                    break;
                case 1:
                    adaptadorModelos = ArrayAdapter.createFromResource(this, R.array.modeloPeugeot, R.layout.itemmodelo);
                    break;
                case 2:
                    adaptadorModelos = ArrayAdapter.createFromResource(this, R.array.modeloSeat, R.layout.itemmodelo);
                    break;
            }
            if (adaptadorModelos != null){
                modelos.setAdapter(adaptadorModelos);
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.enviar){
            String texto = marcas.getSelectedItem().toString() + " " + modelos.getSelectedItem().toString() + " " + colorSeleccionado;
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }
    }
}