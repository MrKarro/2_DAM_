package com.example.practica7_ejercicio1_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    Button confirmar;
    RadioButton aceptar;
    RadioButton cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        confirmar = findViewById(R.id.buttonConfirmar);
        confirmar.setOnClickListener(this);
        aceptar = findViewById(R.id.radioButtonAceptar);
        cancelar = findViewById(R.id.radioButtonCancelar);
        texto = findViewById(R.id.textView);
        if (getIntent().getExtras() != null){
            String recibido = getIntent().getStringExtra("usuario");
            texto.setText(recibido + " bienvenido, confirme su elección.");

        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonConfirmar){
            Intent intent = new Intent();
            if (aceptar.isChecked())
                intent.putExtra("resultado", "ACEPTADO");
            else
                intent.putExtra("resultado", "DENEGADO");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}