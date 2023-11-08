package com.example.practica11_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {

    TextView nombre, apellido, edad, dni, provincia, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        nombre = findViewById(R.id.nombreMostrar);
        apellido = findViewById(R.id.apellidoMostrar);
        edad = findViewById(R.id.edadMostrar);
        dni = findViewById(R.id.dniMostrar);
        provincia = findViewById(R.id.provinciaMostrar);
        telefono = findViewById(R.id.telefMostrar);

        if (getIntent().getExtras() != null){
            Usuario u =(Usuario) getIntent().getSerializableExtra("usuario");

            nombre.setText(u.getNombre());
            apellido.setText(u.getApell());
            edad.setText(String.valueOf(u.getEdad()));
            dni.setText(u.getDni());
            telefono.setText(u.getTelefono());
            provincia.setText(u.getProvincia());

        }


    }
}