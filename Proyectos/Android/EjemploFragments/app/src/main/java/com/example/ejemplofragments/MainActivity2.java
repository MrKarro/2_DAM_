package com.example.ejemplofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, OnFragmentEventListener {

    Button enviar;
    EditText texto;
    TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texto = findViewById(R.id.nombre);
        enviar = findViewById(R.id.bot1);
        enviar.setOnClickListener(this);
        saludo = findViewById(R.id.saludo);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bot1){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment frag = new BlankFragment(texto.getText().toString());
            fragmentTransaction.replace(R.id.frame, frag);
            fragmentTransaction.commit();

        }
    }

    @Override
    public void saludar() {
        saludo.setText("Jelou");
    }
}