package com.example.zapateria_david_carro_salinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Spinner spTipos;
    EditText descripcion, numero, codigo;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spTipos = findViewById(R.id.spTipos);
        descripcion = findViewById(R.id.etDesc);
        numero = findViewById(R.id.etNumero);
        codigo = findViewById(R.id.etCodigo);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, MainActivity.tipos);
        spTipos.setAdapter(adaptador);

        aceptar = findViewById(R.id.aceptar);
        aceptar.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.aceptar){


            if (descripcion.getText().toString().isEmpty()){
                Toast.makeText(this, "Campo descripción vacío", Toast.LENGTH_SHORT).show();
                return;
            } else if (numero.getText().toString().isEmpty()){
                Toast.makeText(this, "Campo número vacío", Toast.LENGTH_SHORT).show();
                return;
            } else if (codigo.getText().toString().isEmpty()){
                Toast.makeText(this, "Campo código vacío", Toast.LENGTH_SHORT).show();
                return;
            }


            String tipo = spTipos.getItemAtPosition(spTipos.getSelectedItemPosition()).toString();
            String desc = descripcion.getText().toString();
            int num =Integer.parseInt(numero.getText().toString());
            String cod = codigo.getText().toString();
            Calzado c = new Calzado(tipo, desc, num, cod);

            Intent intent = new Intent();
            intent.putExtra("calzado", c);
            setResult(RESULT_OK, intent);
            finish();

        }
    }


}