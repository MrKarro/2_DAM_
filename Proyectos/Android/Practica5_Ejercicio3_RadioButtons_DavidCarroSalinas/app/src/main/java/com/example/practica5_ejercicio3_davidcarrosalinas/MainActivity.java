package com.example.practica5_ejercicio3_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button limpiar;
    RadioGroup grupo;
    ConstraintLayout lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay = findViewById(R.id.fondo);
        grupo = findViewById(R.id.radioGroup);
        RadioButton bAzul = findViewById(R.id.radioButton_azul);
        RadioButton bRojo = findViewById(R.id.radioButton_rojo);
        RadioButton bVerde = findViewById(R.id.radioButton_verde);
        limpiar = findViewById(R.id.button_limpiar);
        limpiar.setOnClickListener(this);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton_rojo) {
                    lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.rojo));
                } else if (i == R.id.radioButton_azul)
                    lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.azul));
                else if (i == R.id.radioButton_verde)
                    lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.verde));
            }
        });

    }


    @Override
    public void onClick(View view) {
        if (limpiar.getId() == view.getId()) {
            grupo.clearCheck();
            lay.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }

    }
}