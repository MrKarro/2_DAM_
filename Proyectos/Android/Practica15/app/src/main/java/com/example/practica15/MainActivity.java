package com.example.practica15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner lista;
    Button datos, foto;
    TextView delegado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista);

        datos = findViewById(R.id.datos);
        foto = findViewById(R.id.foto);
        delegado = findViewById(R.id.delegado);

        ArrayAdapter adapt = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Alumno.aleat(10));

        lista.setAdapter(adapt);

    }







}