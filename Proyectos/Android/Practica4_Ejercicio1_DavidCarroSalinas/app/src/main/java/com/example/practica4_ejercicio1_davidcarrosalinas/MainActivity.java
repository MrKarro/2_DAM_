package com.example.practica4_ejercicio1_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button izq;
    Button dere;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izq.setOnClickListener(this);
        dere.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button_derecha)
            texto.setText("Ha pulsado el botón derecho.");
        else if (view.getId() == R.id.button_izquierda)
            texto.setText("Ha pulsado el botón izquierdo.");
    }


}
