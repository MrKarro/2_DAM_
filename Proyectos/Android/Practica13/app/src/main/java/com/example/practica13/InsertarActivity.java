package com.example.practica13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertarActivity extends AppCompatActivity implements View.OnClickListener {

    Button insertar;
    EditText dni, nombre, apellidos, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        insertar = findViewById(R.id.botEnviar);
        dni = findViewById(R.id.dni);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.botEnviar) {
            SQLHelper helper = new SQLHelper(this);
            Alumno a = new Alumno(dni.getText().toString(), nombre.getText().toString(), apellidos.getText().toString(), Integer.parseInt(edad.getText().toString()));

            helper.insertarAlumno(a);

        }


    }
}