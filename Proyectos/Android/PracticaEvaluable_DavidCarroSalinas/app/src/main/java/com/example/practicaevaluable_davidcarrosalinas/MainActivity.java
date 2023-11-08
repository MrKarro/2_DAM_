package com.example.practicaevaluable_davidcarrosalinas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.RadioAccessSpecifier;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int CODE = 1234;
    TextView nombre, edad;

    Button enviar;
    RadioGroup grupo;

    RadioButton rosa, azul, verde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editTextNombre);
        edad = findViewById(R.id.editTextEdad);
        rosa = findViewById(R.id.radioButtonRosa);
        azul = findViewById(R.id.radioButtonAzul);
        verde = findViewById(R.id.radioButtonVerde);
        grupo = findViewById(R.id.radioGroup);

        enviar = findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEnviar){
            if (nombre.getText().toString().isEmpty()){
                Toast.makeText(this, "Campo Nombre vacío", Toast.LENGTH_SHORT).show();
                return;
            } else if (edad.getText().toString().isEmpty()){
                Toast.makeText(this, "Campo Edad vacío", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean botonPulsado = false;
            if (rosa.isChecked()){
                botonPulsado = true;
            } else if (azul.isChecked()){
                botonPulsado = true;
            } else if (verde.isChecked()){
                botonPulsado = true;
            }
            if (!botonPulsado){
                Toast.makeText(this, "Campo Color vacío", Toast.LENGTH_SHORT).show();
                return;
            }




            if (Integer.parseInt(edad.getText().toString()) >= 18){
                Intent intent = new Intent(this, MayorActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, MenorActivity.class);
                intent.putExtra("nombre", nombre.getText().toString());

                if (rosa.isChecked()){
                    intent.putExtra("color", "rosa");
                } else if (azul.isChecked()){
                    intent.putExtra("color", "azul");
                } else if (verde.isChecked()){
                    intent.putExtra("color", "verde");
                }
                startActivity(intent);

            }

            
        }
    }
}