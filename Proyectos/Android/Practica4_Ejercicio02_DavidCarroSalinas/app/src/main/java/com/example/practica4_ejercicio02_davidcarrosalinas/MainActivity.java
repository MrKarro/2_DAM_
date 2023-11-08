package com.example.practica4_ejercicio02_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText texto;
    TextView etiq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enviar = findViewById(R.id.button_enviar);
        texto = findViewById(R.id.editText_rellenar);
        etiq = findViewById(R.id.etiqueta);
        enviar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        etiq.setText(texto.getText());
        texto.setText("");
    }
}