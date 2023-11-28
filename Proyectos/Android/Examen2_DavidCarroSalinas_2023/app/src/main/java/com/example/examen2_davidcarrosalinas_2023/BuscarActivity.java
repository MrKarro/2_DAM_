package com.example.examen2_davidcarrosalinas_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BuscarActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    RadioButton gato, perro, pajaro;
    RadioGroup grupo;
    Button buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);


        gato = findViewById(R.id.gato);
        perro = findViewById(R.id.perro);
        pajaro = findViewById(R.id.pajaro);
        grupo = findViewById(R.id.tipo);
        buscar = findViewById(R.id.buscar);
        buscar.setOnClickListener(this);
        grupo.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        buscar.setEnabled(true);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, MostrarActivity.class);
        if (view.getId() == R.id.buscar){
            if (gato.isChecked()){
                intent.putExtra("animal", "Gato");
                Toast.makeText(this, "Prueba entra gato", Toast.LENGTH_SHORT).show();
            } else if (perro.isChecked()){
                intent.putExtra("animal", "Perro");
            } else if (pajaro.isChecked()) {
                intent.putExtra("animal", "Pajaro");
            }
        }
        startActivity(intent);
    }
}