package com.example.practica4_ejercicio3_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ToggleButton boton;
    CheckBox cBox;
    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.toggleButton);
        cBox = findViewById(R.id.checkBox);
        tView = findViewById(R.id.textView);
        cBox.setOnClickListener(this);
        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == cBox.getId()){
            if (cBox.isChecked()){
                boton.setEnabled(false);
            } else {
                boton.setEnabled(true);
            }
        } else if (view.getId() == boton.getId()) {
            if (boton.isChecked()) {
                tView.setText("Botón pulsado");
            } else {
                tView.setText("Pulsa el boton");
            }
        }
    }
}