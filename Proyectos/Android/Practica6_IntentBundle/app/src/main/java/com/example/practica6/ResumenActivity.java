package com.example.practica6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ResumenActivity extends AppCompatActivity {
    TextView nombre, apellidos, fecha, direccion, telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        nombre = findViewById(R.id.textViewNombre);
        apellidos = findViewById(R.id.textViewApellidos);
        fecha = findViewById(R.id.textViewFecha);
        direccion = findViewById(R.id.textViewDireccion);
        telefono = findViewById(R.id.textViewTelefono);

        if (getIntent().getExtras() != null  && getIntent().getBundleExtra("datos") != null){
            Bundle b = getIntent().getBundleExtra("datos");
            nombre.setText(b.getString("nombre"));
            apellidos.setText(b.getString("apellidos"));
            fecha.setText(b.getString("fecha"));
            direccion.setText(b.getString("direccion"));
            telefono.setText(b.getString("telefono"));


        }
    }
}