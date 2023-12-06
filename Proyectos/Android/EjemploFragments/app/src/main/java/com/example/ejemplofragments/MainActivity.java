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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnFragmentEventListener {

    Button enviar, cambio, botFrag;
    EditText texto;
    TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.nombre);
        enviar = findViewById(R.id.bot1);
        enviar.setOnClickListener(this);
        saludo = findViewById(R.id.saludo);
        cambio = findViewById(R.id.bot2);
        cambio.setOnClickListener(this);
        botFrag = findViewById(R.id.botFrag);
        botFrag.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bot1){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment frag = new BlankFragment(texto.getText().toString());
            fragmentTransaction.replace(R.id.frame, frag);
            fragmentTransaction.commit();

        } else if (view.getId() == R.id.bot2){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        } else if (view.getId() == R.id.botFrag){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            BlankFragment2 frag = new BlankFragment2();
            Bundle args = new Bundle();
            args.putString("nombre", texto.getText().toString());
            frag.setArguments(args);
            fragmentTransaction.replace(R.id.frame, frag);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void saludar() {
        saludo.setText("HOLA");
    }
}