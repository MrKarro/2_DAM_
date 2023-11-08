package com.example.practica5_ejercicio2_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText texto = findViewById(R.id.eText);
        TextView etiq = findViewById(R.id.tView);
        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                char[] letrasDni = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
                char[] dni = String.valueOf(texto.getText()).toCharArray();
                if (dni.length == 9) {
                    char letra = dni[dni.length - 1];
                    String numerosCad = "";
                    for (int j = 0; j < (dni.length - 1); j++)
                        numerosCad += dni[j];

                    int numero = Integer.parseInt(numerosCad);
                    int letraNum = numero % 23;
                    //comprobación de fallo
                    /*
                    etiq.setText(letra + " numLetra" + letraNum + "numero " + numero);
                     */
                    if (letrasDni[letraNum] == letra) {
                        etiq.setText("");

                    }
                }

            }
        });

    }
}