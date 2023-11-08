package com.example.practica10_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, apellidos, edad, dni, telefono;
    Spinner provincia;
    Button aceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nombre = findViewById(R.id.edNombre);
        apellidos = findViewById(R.id.edApellidos);
        edad = findViewById(R.id.edEdad);
        dni = findViewById(R.id.edDni);
        telefono = findViewById(R.id.edTelef);
        provincia = findViewById(R.id.provincias);
        aceptar = findViewById(R.id.aceptar);

        aceptar.setOnClickListener(this);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.provincias , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        provincia.setAdapter(adaptador);



    }

    @Override
    public void onClick(View view) {
        String nom = nombre.getText().toString();
        String apell = apellidos.getText().toString();
        int ed = Integer.parseInt(edad.getText().toString());
        String dniOk = dni.getText().toString();
        String telef = telefono.getText().toString();
        String prov = provincia.getSelectedItem().toString();


        Usuario u = new Usuario(nom, apell, ed, dniOk, telef, prov);
        Intent intent = new Intent();
        intent.putExtra("nuevo", u);
        setResult(RESULT_OK, intent);

    }
}