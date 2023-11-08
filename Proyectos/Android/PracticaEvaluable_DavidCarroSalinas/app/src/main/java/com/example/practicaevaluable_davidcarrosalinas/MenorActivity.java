package com.example.practicaevaluable_davidcarrosalinas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MenorActivity extends AppCompatActivity {

    TextView texto;
    LinearLayout lay;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor);
        texto = findViewById(R.id.textViewMenor);
        lay = findViewById(R.id.fondo);



        if (getIntent().getExtras() != null){
            String recibido = getIntent().getStringExtra("nombre");
            texto.setText("Hola " + recibido);

            String color = getIntent().getStringExtra("color");
            if (color.equals("rosa")){
                lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.rosa));
            } else if (color.equals("azul")){
                lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.azul));

            } else if (color.equals("verde")){
                lay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.verde));
            }



        }
    }
}