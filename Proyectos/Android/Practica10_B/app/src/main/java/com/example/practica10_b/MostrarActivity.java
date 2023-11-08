package com.example.practica10_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MostrarActivity extends AppCompatActivity {



    Button volver;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        volver = findViewById(R.id.volver);
        lista = findViewById(R.id.lista);



    }
}