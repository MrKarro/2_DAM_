package com.example.proyecto_final_dcs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ingresar, registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresar = findViewById(R.id.ingresar);
        registrar = findViewById(R.id.registrar);
        ingresar.setOnClickListener(this);
        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ingresar){


        } else if (view.getId() == R.id.registrar){

        }
    }
}