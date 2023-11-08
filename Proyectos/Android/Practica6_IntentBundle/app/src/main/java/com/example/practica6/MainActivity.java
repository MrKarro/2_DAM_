package com.example.practica6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, apellidos, fecha, direccion, telefono;
    Button enviar, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editText_Nombre);
        apellidos = findViewById(R.id.editTextApellidos);
        fecha = findViewById(R.id.editTextFecha);
        direccion = findViewById(R.id.editTextDireccion);
        telefono = findViewById(R.id.editTextTelefono);

        enviar = findViewById(R.id.buttonEnviar);
        reset = findViewById(R.id.buttonReset);

        enviar.setOnClickListener(this);
        reset.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEnviar){
            if (comprobarCampos()){
                Bundle b = new Bundle();

                b.putString("nombre", String.valueOf(nombre.getText()));
                b.putString("apellidos", String.valueOf(apellidos.getText()));
                b.putString("fecha", String.valueOf(fecha.getText()));
                b.putString("direccion", String.valueOf(direccion.getText()));
                b.putString("telefono", String.valueOf(telefono.getText()));
                Intent intent = new Intent(this, ResumenActivity.class);
                intent.putExtra("datos", b);
                startActivity(intent);




            }

        } else if (view.getId() == R.id.buttonReset){
            nombre.setText("");
            apellidos.setText("");
            fecha.setText("");
            direccion.setText("");
            telefono.setText("");
        }
    }

    private boolean comprobarCampos() {

        Boolean lleno = true;
        if (esVacio(nombre) || esVacio(apellidos) || esVacio(fecha) || esVacio(direccion) || esVacio(telefono)) {
            lleno = false;
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show();
        }

        String [] partida = fecha.getText().toString().split("-");
        int numero;
        try{
            int ano = Integer.parseInt(partida[2]);
            int mes = Integer.parseInt(partida[1]);
            int dia = Integer.parseInt(partida[0]);

            LocalDate fec = LocalDate.of(ano, mes, dia);
            numero = Integer.parseInt(String.valueOf(telefono.getText()));
        } catch (Exception e)  {
            lleno = false;
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }

        return lleno;
    }
    private boolean esVacio(EditText edit){
        if (edit.getText().toString().isEmpty())
            return true;
        return false;
    }
}