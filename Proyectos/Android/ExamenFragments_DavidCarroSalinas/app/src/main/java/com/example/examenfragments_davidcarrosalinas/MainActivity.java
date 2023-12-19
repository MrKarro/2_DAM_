package com.example.examenfragments_davidcarrosalinas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenfragments_davidcarrosalinas.Modelo.SQLHelper;
import com.example.examenfragments_davidcarrosalinas.Modelo.Usuario;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText user, pass;
    Button inicio;
    private SQLHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        inicio = findViewById(R.id.inicio);
        inicio.setOnClickListener(this);
        helper = new SQLHelper(this);




    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.inicio){

            Usuario usuario = helper.iniciarSesion(user.getText().toString(), pass.getText().toString());
            if (usuario != null){
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);

            }

        }
    }
}