package com.example.practica8_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WhatsActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText texto;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats);

        texto = findViewById(R.id.editTextText);
        enviar = findViewById(R.id.buttonEnviar);
        texto.addTextChangedListener(this);
        enviar.setOnClickListener(this);
        enviar.setEnabled(false);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if (!texto.getText().toString().isEmpty()){
            enviar.setEnabled(true);
        } else
            enviar.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEnviar){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.setPackage("com.whatsapp");
            intent.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
            try{
                startActivity(intent);
            }catch (ActivityNotFoundException ex){
                Toast.makeText(this, "La aplicación Whastapp no se encuentra instalada en el dispositivo.", Toast.LENGTH_SHORT).show();

            }
        }

    }
}