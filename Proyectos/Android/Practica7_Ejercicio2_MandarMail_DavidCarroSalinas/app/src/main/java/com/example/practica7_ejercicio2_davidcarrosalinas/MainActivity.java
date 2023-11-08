package com.example.practica7_ejercicio2_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText destinatario, asunto, cuerpo;
    Button enviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        destinatario = findViewById(R.id.editTextDestinatario);
        asunto = findViewById(R.id.editTextAsunto);
        cuerpo = findViewById(R.id.editTextCuerpo);
        enviar = findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEnviar){
            Intent intent = new Intent(Intent.ACTION_SEND);

            String[] correos = new String[1];
            correos[0] = destinatario.getText().toString();
            intent.putExtra(Intent.EXTRA_EMAIL, correos);
            intent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, cuerpo.getText().toString());
            intent.setType("text/plain");

            Intent chooser = Intent.createChooser(intent, getResources().getString(R.string.chooser_title));
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(chooser);
            }


        }

    }
}